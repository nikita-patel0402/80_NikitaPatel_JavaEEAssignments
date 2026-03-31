/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

/**
 *
 * @author root 
 */
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userCaptcha = request.getParameter("captchaInput");
        String sessionCaptcha = (String) request.getSession().getAttribute("captcha");

        if (sessionCaptcha == null || !userCaptcha.equals(sessionCaptcha)) {
            out.println("<h3>Invalid CAPTCHA!</h3>");
            out.println("<a href='register.jsp'>Try Again</a>");
            return;
        }

        String username = request.getParameter("username");
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");   // ✅ NEW LINE

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shopDB", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO user_master(username, login_id, password, password_question, password_answer, email, phone, address, dob) VALUES (?,?,?,?,?,?,?,?,?)"
            );

            ps.setString(1, username);
            ps.setString(2, loginId);
            ps.setString(3, password);
            ps.setString(4, question);
            ps.setString(5, answer);
            ps.setString(6, email);
            ps.setString(7, phone);
            ps.setString(8, address);
            ps.setDate(9, Date.valueOf(dob));   // ✅ STORE DATE

            ps.executeUpdate();

            out.println("<h3>Registration Successful!</h3>");
            out.println("<a href='login.jsp'>Login Now</a>");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        }
    }
}