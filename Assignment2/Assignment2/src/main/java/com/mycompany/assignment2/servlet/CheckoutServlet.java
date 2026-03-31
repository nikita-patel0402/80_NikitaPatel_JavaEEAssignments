package com.mycompany.assignment2.servlet;

import com.mycompany.assignment2.model.Product;
import com.mycompany.assignment2.util.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if(cart == null || cart.isEmpty()) {
            response.sendRedirect("viewCart.jsp");
            return;
        }

        String paymentMode = request.getParameter("payment");
        String sessionId = session.getId();
        double taxPercent = 0.05;
        double subtotal = 0;

        for(Product p : cart) {
            subtotal += (p.getPrice() - p.getDiscount());
        }
        double tax = subtotal * taxPercent;
        double total = subtotal + tax;

        Connection con = null;
        PreparedStatement pstMaster = null;
        PreparedStatement pstDetail = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false);

            String masterSQL = "INSERT INTO order_master (order_datetime, session_id, payment_mode, tax, total_amount, order_status) VALUES (NOW(), ?, ?, ?, ?, ?)";
            pstMaster = con.prepareStatement(masterSQL, Statement.RETURN_GENERATED_KEYS);
            pstMaster.setString(1, sessionId);
            pstMaster.setString(2, paymentMode);
            pstMaster.setDouble(3, tax);
            pstMaster.setDouble(4, total);
            pstMaster.setString(5, "Pending");

            int affectedRows = pstMaster.executeUpdate();
            if(affectedRows == 0) throw new SQLException("Creating order failed.");

            rs = pstMaster.getGeneratedKeys();
            int orderId = 0;
            if(rs.next()) orderId = rs.getInt(1);

            String detailSQL = "INSERT INTO order_detail (order_id, product_id, product_price, discount) VALUES (?, ?, ?, ?)";
            pstDetail = con.prepareStatement(detailSQL);

            for(Product p : cart) {
                pstDetail.setInt(1, orderId);
                pstDetail.setInt(2, p.getProductId());
                pstDetail.setDouble(3, p.getPrice());
                pstDetail.setDouble(4, p.getDiscount());
                pstDetail.addBatch();
            }

            pstDetail.executeBatch();
            con.commit();

            session.removeAttribute("cart");
            request.setAttribute("cart", cart);
            request.getRequestDispatcher("orderConfirmation.jsp").forward(request, response);

        } catch(SQLException e) {
            try { if(con != null) con.rollback(); } catch(Exception ex){}
            e.printStackTrace();
            request.setAttribute("message", "Error processing order: " + e.getMessage());
            request.getRequestDispatcher("viewCart.jsp").forward(request, response);
        } finally {
            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(pstDetail != null) pstDetail.close(); } catch(Exception e){}
            try { if(pstMaster != null) pstMaster.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }
}