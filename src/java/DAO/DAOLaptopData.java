package DAO;

import DAL.DBContext;
import Model.laptop_data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOLaptopData extends DBContext {

    // --- CÁC HÀM MỚI BỔ SUNG ĐỂ LẤY DỮ LIỆU ĐỘNG CHO TRANG CHỦ ---

    /**
     * Lấy danh sách các loại Môi trường sử dụng duy nhất từ Database
     */
    public List<String> getAllEnvironments() {
        List<String> list = new ArrayList<>();
        // Lưu ý: Thay đổi "usage_environment" thành tên cột chính xác trong DB của bạn
        String sql = "SELECT DISTINCT usage_environment FROM laptop_data WHERE usage_environment IS NOT NULL AND usage_environment != ''";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Lấy danh sách các Tần suất sử dụng duy nhất từ Database
     */
    public List<String> getAllFrequencies() {
        List<String> list = new ArrayList<>();
        // Lưu ý: Thay đổi "usage_frequency" thành tên cột chính xác trong DB của bạn
        String sql = "SELECT DISTINCT usage_frequency FROM laptop_data WHERE usage_frequency IS NOT NULL AND usage_frequency != ''";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Lấy danh sách các Thương hiệu duy nhất (Dùng để load động phần Thương hiệu)
     */
    public List<String> getAllBrands() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT DISTINCT Brand FROM laptop_data WHERE Brand IS NOT NULL ORDER BY Brand ASC";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // --- CÁC HÀM CŨ CỦA BẠN ---

    public List<laptop_data> getTop5RecommendedLaptops(String predictedCategory, long userBudget) {
        List<laptop_data> list = new ArrayList<>();
        String sql = "SELECT * FROM laptop_data "
                   + "WHERE target_category = ? AND price_vnd <= ? "
                   + "ORDER BY performance_score DESC LIMIT 5";

        try {
            if (conn == null || conn.isClosed()) {
                return list;
            }
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, predictedCategory);
            pre.setLong(2, userBudget);

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToLaptop(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private laptop_data mapResultSetToLaptop(ResultSet rs) throws SQLException {
        laptop_data item = new laptop_data();
        item.setId(rs.getInt("id"));
        item.setLaptop_name(rs.getString("laptop_name"));
        item.setBrand(rs.getString("brand"));
        item.setPrice_vnd(rs.getLong("price_vnd"));
        item.setPrice_segment(rs.getString("price_segment"));
        item.setCpu_class(rs.getString("cpu_class"));
        item.setCpu_technology(rs.getString("cpu_technology"));
        item.setGpu_type(rs.getString("gpu_type"));
        item.setScreen_size(rs.getString("screen_size"));
        item.setRefresh_rate(rs.getString("refresh_rate"));
        item.setOs(rs.getString("os"));
        item.setTarget_category(rs.getString("target_category"));
        item.setCpu_score(rs.getInt("cpu_score"));
        item.setRam_gb(rs.getInt("ram_gb"));
        item.setGpu_encoded(rs.getInt("gpu_encoded"));
        item.setStorage_gb(rs.getInt("storage_gb"));
        item.setScreen_size_num(rs.getDouble("screen_size_num"));
        item.setBattery_wh(rs.getDouble("battery_wh"));
        item.setRefresh_rate_score(rs.getInt("refresh_rate_score"));
        item.setOs_encoded(rs.getInt("os_encoded"));
        item.setPerformance_score(rs.getInt("performance_score"));
        item.setFuture_compatibility_level(rs.getString("future_compatibility_level"));
        item.setValue_score(rs.getDouble("value_score"));
        item.setMarket_popularity(rs.getString("market_popularity"));
        item.setSimilarity_score(0.0); 
        return item;
    }
}