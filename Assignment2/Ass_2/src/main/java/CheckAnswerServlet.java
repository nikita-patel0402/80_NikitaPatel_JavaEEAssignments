/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/CheckAnswerServlet")
public class CheckAnswerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loginId = request.getParameter("loginId");
        String answer = request.getParameter("answer");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shopDB", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                "SELECT password FROM user_master WHERE login_id=? AND password_answer=?");
            ps.setString(1, loginId);
            ps.setString(2, answer);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                request.setAttribute("password", rs.getString("password"));
                request.getRequestDispatcher("showPassword.jsp")
                       .forward(request, response);
            } else {
                request.setAttribute("error", "Wrong Answer");
                request.getRequestDispatcher("forgotPassword.jsp")
                       .forward(request, response);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

