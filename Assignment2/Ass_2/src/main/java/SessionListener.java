/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author root
 */
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.annotation.WebListener;
import java.sql.*;
import java.time.LocalDateTime;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        String sessionId = se.getSession().getId();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shopDB?useSSL=false&serverTimezone=UTC",
                "root",
                "root"
            );

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO session_log(session_id, visit_time) VALUES (?, ?)"
            );

            ps.setString(1, sessionId);
            ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Optional: you can log logout time here
    }
}
