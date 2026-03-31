/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;

@WebServlet("/BirthdayEmailServlet")
public class BirthdayEmailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shopDB", "root", "root");

            // Today's date (MM-DD)
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT email, username FROM user_master " +
                "WHERE DATE_FORMAT(dob,'%m-%d') = DATE_FORMAT(CURDATE(),'%m-%d')");

            while (rs.next()) {
                String email = rs.getString("email");
                String name = rs.getString("username");

                sendEmail(email, name);
            }

            con.close();

            response.getWriter().println("Birthday Emails Sent!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendEmail(String toEmail, String name)
            throws Exception {

        final String fromEmail = "jayvekariya.clg@gmail.com";
        final String password = "tduu mhdi fktn dnvw";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new jakarta.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(toEmail));

        message.setSubject("🎂 Happy Birthday from Fashion Store!");
        message.setText("Dear " + name +
                ",\n\nWishing you a very Happy Birthday! 🎉\n\nEnjoy special discounts today!");

        Transport.send(message);
    }
}