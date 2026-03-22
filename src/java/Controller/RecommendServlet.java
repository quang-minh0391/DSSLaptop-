package Controller;

import Model.laptop_data;
import Service.DSSService;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RecommendServlet", urlPatterns = {"/recommend"})
public class RecommendServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // 1. Lấy dữ liệu từ Form JSP và xử lý Null an toàn
            String budgetStr = request.getParameter("budget");
            String purpose = getStringParameter(request, "purpose");
            String environment = getStringParameter(request, "environment");
            String frequency = getStringParameter(request, "frequency");
            
            String brand = getStringParameter(request, "brand");
            String cpu = getStringParameter(request, "cpu_class");
            String gpu = getStringParameter(request, "gpu_type");
            String refresh = getStringParameter(request, "refresh_rate");

            // Xử lý các trường số
            int ram = getIntParameter(request, "ram_gb", 0); // Để 0 nếu user không chọn để AI tự gợi ý
            int storage = getIntParameter(request, "storage_gb", 0);
            double budget = getDoubleParameter(request, "budget", 0.0);
            double screen = getDoubleParameter(request, "screen_size", 0.0);
            double battery = getDoubleParameter(request, "battery_wh", 0.0);

            System.out.println("LOG: Nhận yêu cầu tư vấn với ngân sách " + budget + " VND");

            // 2. Gọi DSSService để gửi thông tin sang Python Flask
            DSSService dssService = new DSSService();
            List<laptop_data> recommendedLaptops = dssService.getLaptopRecommendations(
                    brand, cpu, gpu, ram, storage, refresh, 
                    screen, battery, budget, purpose, 
                    environment, frequency
            );

            // 3. Đẩy dữ liệu sang giao diện (result.jsp)
            if (recommendedLaptops != null && !recommendedLaptops.isEmpty()) {
                request.setAttribute("laptopList", recommendedLaptops);
                // Lấy phân khúc dự đoán từ máy đầu tiên (đã được DSSService gán vào)
                request.setAttribute("predictedCategory", recommendedLaptops.get(0).getTarget_category());
                System.out.println("LOG: Tìm thấy " + recommendedLaptops.size() + " máy phù hợp.");
            } else {
                System.out.println("LOG: Không tìm thấy máy nào.");
            }
            
            request.setAttribute("userBudget", budget);
            request.getRequestDispatcher("result.jsp").forward(request, response);
            
        } catch (Exception e) {
            System.err.println("LOG ERROR: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("errorMessage", "Lỗi kết nối hệ thống AI: " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // --- Các hàm hỗ trợ đọc tham số an toàn ---

    // Hàm mới: Đảm bảo không bị null khi gửi sang Python
    private String getStringParameter(HttpServletRequest request, String paramName) {
        String value = request.getParameter(paramName);
        return (value == null) ? "" : value.trim();
    }

    private int getIntParameter(HttpServletRequest request, String paramName, int defaultValue) {
        String value = request.getParameter(paramName);
        if (value == null || value.trim().isEmpty()) return defaultValue;
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private double getDoubleParameter(HttpServletRequest request, String paramName, double defaultValue) {
        String value = request.getParameter(paramName);
        if (value == null || value.trim().isEmpty()) return defaultValue;
        try {
            // Loại bỏ dấu phẩy hoặc khoảng trắng nếu có
            value = value.replace(",", "").trim();
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}