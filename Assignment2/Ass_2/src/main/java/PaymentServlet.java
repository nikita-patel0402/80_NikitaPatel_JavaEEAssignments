/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author root
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int orderId = Integer.parseInt(request.getParameter("orderId"));

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shopDB","root","root");

            PreparedStatement ps = con.prepareStatement(
                "UPDATE order_master SET payment_status='PAID', payment_date=NOW() WHERE order_id=?");

            ps.setInt(1, orderId);
            ps.executeUpdate();

            response.sendRedirect("bill.jsp?orderId=" + orderId);

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}