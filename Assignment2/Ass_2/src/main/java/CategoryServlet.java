/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("categoryName");
        int parentId = Integer.parseInt(request.getParameter("parentCategoryId"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shopDB", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO category_master(category_name, parent_category_id) VALUES (?, ?)");

            ps.setString(1, name);
            ps.setInt(2, parentId);
            ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("viewCategory.jsp");
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
                "DELETE FROM category_master WHERE category_id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("viewCategory.jsp");
    }
}
