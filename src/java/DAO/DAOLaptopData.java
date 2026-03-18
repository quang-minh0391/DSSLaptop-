package DAO;

import DAL.DBContext;
import Model.laptop_data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOLaptopData extends DBContext {

    // Lấy danh sách laptop (có tìm kiếm theo tên laptop và thương hiệu)
    public List<laptop_data> getList(String laptopName, String brand) {
        List<laptop_data> list = new ArrayList<>();
        String sql = "SELECT * FROM laptop_data WHERE laptop_name LIKE ? AND brand LIKE ?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, "%" + (laptopName == null ? "" : laptopName) + "%");
            pre.setString(2, "%" + (brand == null ? "" : brand) + "%");

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new laptop_data(
                    rs.getInt("id"),
                    rs.getString("laptop_name"),
                    rs.getString("brand"),
                    rs.getLong("price_vnd"),
                    rs.getString("price_segment"),
                    rs.getString("cpu_class"),
                    rs.getString("cpu_technology"),
                    rs.getString("gpu_type"),
                    rs.getString("screen_size"),
                    rs.getString("refresh_rate"),
                    rs.getString("os"),
                    rs.getString("target_category"),
                    rs.getInt("cpu_score"),
                    rs.getInt("ram_gb"),
                    rs.getInt("gpu_encoded"),
                    rs.getInt("storage_gb"),
                    rs.getDouble("screen_size_num"),
                    rs.getDouble("battery_wh"),
                    rs.getInt("refresh_rate_score"),
                    rs.getInt("os_encoded"),
                    rs.getInt("performance_score"),
                    rs.getString("future_compatibility_level"),
                    rs.getDouble("value_score"),
                    rs.getString("market_popularity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm mới laptop
    public int insert(laptop_data l) {
        String sql = "INSERT INTO laptop_data (laptop_name, brand, price_vnd, price_segment, cpu_class, "
                   + "cpu_technology, gpu_type, screen_size, refresh_rate, os, target_category, "
                   + "cpu_score, ram_gb, gpu_encoded, storage_gb, screen_size_num, battery_wh, "
                   + "refresh_rate_score, os_encoded, performance_score, future_compatibility_level, "
                   + "value_score, market_popularity) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, l.getLaptop_name());
            pre.setString(2, l.getBrand());
            pre.setLong(3, l.getPrice_vnd());
            pre.setString(4, l.getPrice_segment());
            pre.setString(5, l.getCpu_class());
            pre.setString(6, l.getCpu_technology());
            pre.setString(7, l.getGpu_type());
            pre.setString(8, l.getScreen_size());
            pre.setString(9, l.getRefresh_rate());
            pre.setString(10, l.getOs());
            pre.setString(11, l.getTarget_category());
            pre.setInt(12, l.getCpu_score());
            pre.setInt(13, l.getRam_gb());
            pre.setInt(14, l.getGpu_encoded());
            pre.setInt(15, l.getStorage_gb());
            pre.setDouble(16, l.getScreen_size_num());
            pre.setDouble(17, l.getBattery_wh());
            pre.setInt(18, l.getRefresh_rate_score());
            pre.setInt(19, l.getOs_encoded());
            pre.setInt(20, l.getPerformance_score());
            pre.setString(21, l.getFuture_compatibility_level());
            pre.setDouble(22, l.getValue_score());
            pre.setString(23, l.getMarket_popularity());

            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Cập nhật thông tin laptop (Cập nhật toàn bộ các trường dựa theo ID)
    public int update(laptop_data l) {
        String sql = "UPDATE laptop_data SET laptop_name = ?, brand = ?, price_vnd = ?, price_segment = ?, "
                   + "cpu_class = ?, cpu_technology = ?, gpu_type = ?, screen_size = ?, refresh_rate = ?, "
                   + "os = ?, target_category = ?, cpu_score = ?, ram_gb = ?, gpu_encoded = ?, storage_gb = ?, "
                   + "screen_size_num = ?, battery_wh = ?, refresh_rate_score = ?, os_encoded = ?, "
                   + "performance_score = ?, future_compatibility_level = ?, value_score = ?, market_popularity = ? "
                   + "WHERE id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, l.getLaptop_name());
            pre.setString(2, l.getBrand());
            pre.setLong(3, l.getPrice_vnd());
            pre.setString(4, l.getPrice_segment());
            pre.setString(5, l.getCpu_class());
            pre.setString(6, l.getCpu_technology());
            pre.setString(7, l.getGpu_type());
            pre.setString(8, l.getScreen_size());
            pre.setString(9, l.getRefresh_rate());
            pre.setString(10, l.getOs());
            pre.setString(11, l.getTarget_category());
            pre.setInt(12, l.getCpu_score());
            pre.setInt(13, l.getRam_gb());
            pre.setInt(14, l.getGpu_encoded());
            pre.setInt(15, l.getStorage_gb());
            pre.setDouble(16, l.getScreen_size_num());
            pre.setDouble(17, l.getBattery_wh());
            pre.setInt(18, l.getRefresh_rate_score());
            pre.setInt(19, l.getOs_encoded());
            pre.setInt(20, l.getPerformance_score());
            pre.setString(21, l.getFuture_compatibility_level());
            pre.setDouble(22, l.getValue_score());
            pre.setString(23, l.getMarket_popularity());
            
            // Tham số WHERE ID
            pre.setInt(24, l.getId());

            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    // Trong class DAOLaptopData.java

public List<laptop_data> getTop5RecommendedLaptops(String predictedCategory, long userBudget) {
    List<laptop_data> list = new ArrayList<>();
    
    // Câu truy vấn SQL lọc theo Target_Category và nhỏ hơn hoặc bằng User_Budget
    // Sắp xếp theo Performance_Score để lấy máy hiệu năng cao nhất [cite: 404]
    String sql = "SELECT * FROM laptop_data "
               + "WHERE target_category = ? AND price_vnd <= ? "
               + "ORDER BY performance_score DESC LIMIT 5";

    try {
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1, predictedCategory);
        pre.setLong(2, userBudget);

        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            list.add(new laptop_data(
                // ... map các trường giống hàm getList() cũ
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
}