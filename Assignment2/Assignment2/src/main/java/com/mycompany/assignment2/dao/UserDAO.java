package com.mycompany.assignment2.dao;

import com.mycompany.assignment2.model.User;
import com.mycompany.assignment2.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;   // ADD THIS IMPORT
import java.util.List;
import java.util.ArrayList;

public class UserDAO {

    // ================= REGISTER METHOD =================
    public boolean registerUser(User user) {

        boolean status = false;

        String sql = "INSERT INTO user_master "
                + "(username, login_id, password, password_question, password_answer, "
                + "email, phone, address, city, state, country, pin, dob, role) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getLoginId());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPasswordQuestion());
            ps.setString(5, user.getPasswordAnswer());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getPhone());
            ps.setString(8, user.getAddress());
            ps.setString(9, user.getCity());
            ps.setString(10, user.getState());
            ps.setString(11, user.getCountry());
            ps.setString(12, user.getPin());
            ps.setDate(13, user.getDob());
            ps.setString(14, "USER");

            int row = ps.executeUpdate();

            if (row > 0) {
                status = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    // ================= LOGIN METHOD =================
    public User loginUser(String loginId, String password) {

        User user = null;

        String sql = "SELECT * FROM user_master WHERE login_id=? AND password=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, loginId);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setLoginId(rs.getString("login_id"));
                user.setRole(rs.getString("role"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    // ================= GET ALL USERS =================
public List<User> getAllUsers() {

    List<User> list = new ArrayList<>();

    String sql = "SELECT * FROM user_master";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setLoginId(rs.getString("login_id"));
            user.setEmail(rs.getString("email"));
            user.setRole(rs.getString("role"));

            list.add(user);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

// ================= DELETE USER =================
public boolean deleteUser(int userId) {

    boolean status = false;

    String sql = "DELETE FROM user_master WHERE user_id=?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, userId);

        int row = ps.executeUpdate();

        if (row > 0) {
            status = true;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return status;
}

// ================= UPDATE ROLE =================
public boolean updateUserRole(int userId, String role) {

    boolean status = false;

    String sql = "UPDATE user_master SET role=? WHERE user_id=?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, role);
        ps.setInt(2, userId);

        int row = ps.executeUpdate();

        if (row > 0) {
            status = true;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return status;
}
}