/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loginId = request.getParameter("loginId");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shopDB", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                "SELECT password_question FROM user_master WHERE login_id=?");
            ps.setString(1, loginId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                request.setAttribute("loginId", loginId);
                request.setAttribute("question", rs.getString("password_question"));
                RequestDispatcher rd =
                        request.getRequestDispatcher("answerQuestion.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("error", "Invalid Login ID");
                request.getRequestDispatcher("forgotPassword.jsp")
                       .forward(request, response);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
