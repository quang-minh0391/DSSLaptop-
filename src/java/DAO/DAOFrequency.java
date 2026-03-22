package DAO;

import DAL.DBContext;
import Model.Frequency;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOFrequency extends DBContext {
    public List<Frequency> getAll() {
        List<Frequency> list = new ArrayList<>();
        String sql = "SELECT * FROM frequencies";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Frequency(rs.getInt("id"), rs.getString("freq_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}