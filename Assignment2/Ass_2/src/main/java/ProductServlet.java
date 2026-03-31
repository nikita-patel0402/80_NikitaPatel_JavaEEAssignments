/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shopDB", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO product_master(product_name, price, unit, discount, category_id, stock) VALUES (?, ?, ?, ?, ?, ?)");

            ps.setString(1, request.getParameter("name"));
            ps.setDouble(2, Double.parseDouble(request.getParameter("price")));
            ps.setString(3, request.getParameter("unit"));
            ps.setDouble(4, Double.parseDouble(request.getParameter("discount")));
            ps.setInt(5, Integer.parseInt(request.getParameter("categoryId")));
            ps.setInt(6, Integer.parseInt(request.getParameter("stock")));

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("viewProduct.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shopDB", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM product_master WHERE product_id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("viewProduct.jsp");
    }
}
