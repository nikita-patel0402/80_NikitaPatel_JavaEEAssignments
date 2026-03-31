/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loginId = request.getParameter("loginId");
        String answer = request.getParameter("answer");
        String newPassword = request.getParameter("newPassword");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shopDB", "root", "root");

            // validate answer
            PreparedStatement ps = con.prepareStatement(
                "SELECT user_id FROM user_master WHERE login_id=? AND password_answer=?");
            ps.setString(1, loginId);
            ps.setString(2, answer);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // update password
                PreparedStatement ps2 = con.prepareStatement(
                    "UPDATE user_master SET password=? WHERE login_id=?");
                ps2.setString(1, newPassword);
                ps2.setString(2, loginId);
                ps2.executeUpdate();

                request.setAttribute("msg", "Password updated successfully");
                request.getRequestDispatcher("login.jsp")
                       .forward(request, response);
            } else {
                request.setAttribute("error", "Wrong security answer");
                request.getRequestDispatcher("forgotPassword.jsp")
                       .forward(request, response);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}