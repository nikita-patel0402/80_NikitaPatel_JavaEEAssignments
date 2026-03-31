/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shopDB?useSSL=false&serverTimezone=UTC",
                "root",
                "root"
            );

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM user_master WHERE login_id=? AND password=?"
            );

            ps.setString(1, loginId);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                // LOGIN SUCCESS
                HttpSession session = request.getSession();
                session.setAttribute("userId", rs.getInt("user_id"));
                session.setAttribute("username", rs.getString("username"));

                response.sendRedirect("home.jsp");
            } else {
                // LOGIN FAILED
                out.println("<h3>Invalid Login ID or Password</h3>");
                out.println("<a href='login.jsp'>Try Again</a>");
            }

            con.close();
        } catch(Exception e) {
            out.println(e);
        }
    }
}
