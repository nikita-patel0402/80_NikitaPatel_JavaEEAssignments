package com.mycompany.assignment2.servlet;

import com.mycompany.assignment2.dao.UserDAO;
import com.mycompany.assignment2.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Captcha validation
        int captchaSession = (int) session.getAttribute("captcha");
        int captchaUser = Integer.parseInt(request.getParameter("captchaAnswer"));

        if (captchaSession != captchaUser) {
            response.getWriter().println("Captcha Incorrect! Try Again.");
            return;
        }

        // Get form data
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setLoginId(request.getParameter("loginId"));
        user.setPassword(request.getParameter("password"));
        user.setPasswordQuestion(request.getParameter("passwordQuestion"));
        user.setPasswordAnswer(request.getParameter("passwordAnswer"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        user.setAddress(request.getParameter("address"));
        user.setCity(request.getParameter("city"));
        user.setState(request.getParameter("state"));
        user.setCountry(request.getParameter("country"));
        user.setPin(request.getParameter("pin"));
        user.setDob(Date.valueOf(request.getParameter("dob")));
        user.setRole("USER");

        // Save to DB
        UserDAO dao = new UserDAO();
        boolean status = dao.registerUser(user);

        if (status) {
            response.getWriter().println("Registration Successful!");
        } else {
            response.getWriter().println("Registration Failed!");
        }
    }
}