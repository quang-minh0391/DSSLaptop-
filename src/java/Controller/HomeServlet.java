package Controller;

import DAO.DAOEnvironment;
import DAO.DAOFrequency;
import Model.Environment;
import Model.Frequency;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet xử lý trang chủ, lấy dữ liệu từ DB đổ lên form index.jsp
 * @author ADMIN
 */
@WebServlet(name="HomeServlet", urlPatterns={"/home"}) // Bạn nên đổi pattern thành /home cho chuyên nghiệp
public class HomeServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try {
            // 1. Khởi tạo các DAO
            DAOEnvironment daoEnv = new DAOEnvironment();
            DAOFrequency daoFreq = new DAOFrequency();
            
            // 2. Lấy danh sách từ Database
            List<Environment> envList = daoEnv.getAll();
            List<Frequency> freqList = daoFreq.getAll();
            
            // 3. Đưa dữ liệu vào request attribute để JSP có thể đọc được bằng JSTL
            request.setAttribute("envList", envList);
            request.setAttribute("freqList", freqList);
            
            // 4. Chuyển hướng (Forward) sang trang index.jsp
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } catch (Exception e) {
            // Xử lý nếu lỗi kết nối Database
            e.printStackTrace();
            response.getWriter().println("Lỗi hệ thống khi tải dữ liệu: " + e.getMessage());
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Nếu người dùng POST vào trang chủ, ta vẫn trả về giao diện trang chủ
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Home Controller for Laptop DSS";
    }
}