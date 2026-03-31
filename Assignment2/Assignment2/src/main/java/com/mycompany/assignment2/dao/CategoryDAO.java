package com.mycompany.assignment2.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.assignment2.model.Category;

public class CategoryDAO {

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/fashion_store", "root", "root"
        );
    }

    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM category_master";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category c = new Category();
                c.setCategoryId(rs.getInt("category_id"));
                c.setCategoryName(rs.getString("category_name"));
                c.setParentCategoryId(rs.getInt("parent_category_id"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 🔥 ADD THIS METHOD
    public Category getCategoryById(int id) {

        Category category = null;
        String sql = "SELECT * FROM category_master WHERE category_id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                category = new Category();
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));
                category.setParentCategoryId(rs.getInt("parent_category_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return category;
    }
}