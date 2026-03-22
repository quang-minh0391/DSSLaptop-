package Service;

import Model.laptop_data;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONObject;

public class DSSService {

    public List<laptop_data> getLaptopRecommendations(String brand, String cpu, String gpu, int ram, int storage, 
                                                     String refresh, double screen, double battery, double budget, 
                                                     String purpose, String environment, String frequency) {
        List<laptop_data> recommendations = new ArrayList<>();
        
        try {
            System.out.println("🚀 Đang kết nối tới AI Engine (127.0.0.1:8001)...");
            URL url = new URL("http://127.0.0.1:8001/api/recommend");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setConnectTimeout(5000); 

            // 1. Đóng gói JSON gửi sang Python (Key phải khớp với app.py nhận)
            JSONObject jsonInput = new JSONObject();
            jsonInput.put("Brand", brand != null ? brand : "");
            jsonInput.put("CPU_Class", cpu != null ? cpu : "");
            jsonInput.put("GPU_Type", gpu != null ? gpu : "");
            jsonInput.put("RAM_GB", ram);
            jsonInput.put("Storage_GB", storage);
            jsonInput.put("Refresh_Rate", refresh != null ? refresh : "");
            jsonInput.put("Screen_Size_Num", screen);
            jsonInput.put("Battery_Wh", battery);
            jsonInput.put("budget", budget);
            jsonInput.put("purpose", purpose != null ? purpose : "");
            jsonInput.put("Environment", environment != null ? environment : "");
            jsonInput.put("Frequency", frequency != null ? frequency : "");

            // Gửi dữ liệu đi
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInput.toString().getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // 2. Nhận phản hồi
            int code = conn.getResponseCode();
            if (code == 200) {
                // Đọc luồng dữ liệu với UTF-8
                Scanner scanner = new Scanner(conn.getInputStream(), StandardCharsets.UTF_8.name());
                String responseStr = scanner.useDelimiter("\\A").next();
                scanner.close();

                System.out.println("✅ Đã nhận dữ liệu từ AI.");

                JSONObject jsonResponse = new JSONObject(responseStr);
                if (jsonResponse.optString("status").equals("success")) {
                    // Trích xuất mảng "data" từ JSON
                    String dataJson = jsonResponse.getJSONArray("data").toString();
                    
                    // Lấy phân khúc AI dự đoán
                    String predicted = jsonResponse.optString("predicted_category", "HỌC TẬP / VĂN PHÒNG");
                    
                    // Dùng Gson để chuyển JSON Array thành List Object
                    // RẤT QUAN TRỌNG: Gson sẽ dùng @SerializedName trong Model để map dữ liệu
                    Gson gson = new Gson();
                    recommendations = gson.fromJson(dataJson, new TypeToken<List<laptop_data>>(){}.getType());

                    if (!recommendations.isEmpty()) {
                        // Đảm bảo máy đầu tiên luôn mang thông tin phân khúc để hiện lên header Result.jsp
                        recommendations.get(0).setTarget_category(predicted);
                    } else {
                        System.out.println("⚠️ Flask trả về danh sách rỗng.");
                        laptop_data dummy = new laptop_data();
                        dummy.setTarget_category(predicted);
                        dummy.setLaptop_name("KHÔNG CÓ MÁY PHÙ HỢP VỚI NGÂN SÁCH/YÊU CẦU");
                        recommendations.add(dummy);
                    }
                }
            } else {
                System.err.println("❌ Lỗi Server Flask: HTTP Code " + code);
            }
        } catch (Exception e) {
            System.err.println("❌ Lỗi kết nối Flask: " + e.getMessage());
            e.printStackTrace();
        }
        
        return recommendations;
    }
}