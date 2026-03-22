package DAO;

import DAL.DBContext;
import Model.target_category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOTargetCategory extends DBContext {

    // Lấy danh sách category (có hỗ trợ tìm kiếm theo tên)
    public List<target_category> getList(String searchName) {
        List<target_category> list = new ArrayList<>();
        String sql = "SELECT * FROM target_category WHERE category_name LIKE ?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, "%" + (searchName == null ? "" : searchName) + "%");
            
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new target_category(
                    rs.getInt("id"),
                    rs.getString("category_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm mới category
    public int insert(target_category t) {
        String sql = "INSERT INTO target_category (category_name) VALUES (?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, t.getCategory_name());
            
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Cập nhật category theo ID
    public int update(int id, String categoryName) {
        String sql = "UPDATE target_category SET category_name = ? WHERE id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, categoryName);
            pre.setInt(2, id);
            
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}