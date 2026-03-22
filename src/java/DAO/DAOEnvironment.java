package DAO;

import DAL.DBContext;
import Model.Environment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOEnvironment extends DBContext {
    public List<Environment> getAll() {
        List<Environment> list = new ArrayList<>();
        String sql = "SELECT * FROM environments";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Environment(rs.getInt("id"), rs.getString("env_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}