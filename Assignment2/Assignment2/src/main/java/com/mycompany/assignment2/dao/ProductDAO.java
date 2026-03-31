package com.mycompany.assignment2.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.assignment2.model.Product;

public class ProductDAO {

    // ================= Database Connection =================
    private Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fashion_store",
                "root",
                "root"
        );
    }

    // ================= Add Product =================
    public boolean addProduct(Product p) {

        String sql = "INSERT INTO product_master (product_name, price, stock, unit, discount, image, category_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getProductName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getUnit());
            ps.setDouble(5, p.getDiscount());
            ps.setString(6, p.getImage());
            ps.setInt(7, p.getCategoryId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ================= Get All Products =================
    public List<Product> getAllProducts() {

        List<Product> list = new ArrayList<>();

        String sql = "SELECT * FROM product_master";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Product p = new Product();

                p.setProductId(rs.getInt("product_id"));
                p.setProductName(rs.getString("product_name"));
                p.setPrice(rs.getDouble("price"));
                p.setStock(rs.getInt("stock"));
                p.setUnit(rs.getString("unit"));
                p.setDiscount(rs.getDouble("discount"));
                p.setImage(rs.getString("image"));
                p.setCategoryId(rs.getInt("category_id"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ================= Get Product By ID =================
    public Product getProductById(int id) {

        Product p = null;

        String sql = "SELECT * FROM product_master WHERE product_id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                p = new Product();

                p.setProductId(rs.getInt("product_id"));
                p.setProductName(rs.getString("product_name"));
                p.setPrice(rs.getDouble("price"));
                p.setStock(rs.getInt("stock"));
                p.setUnit(rs.getString("unit"));
                p.setDiscount(rs.getDouble("discount"));
                p.setImage(rs.getString("image"));
                p.setCategoryId(rs.getInt("category_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    // ================= Update Product =================
    public boolean updateProduct(Product p) {

        String sql = "UPDATE product_master SET product_name=?, price=?, stock=?, unit=?, discount=?, image=?, category_id=? WHERE product_id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getProductName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getUnit());
            ps.setDouble(5, p.getDiscount());
            ps.setString(6, p.getImage());
            ps.setInt(7, p.getCategoryId());
            ps.setInt(8, p.getProductId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ================= Delete Product =================
    public boolean deleteProduct(int id) {

        String sql = "DELETE FROM product_master WHERE product_id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}