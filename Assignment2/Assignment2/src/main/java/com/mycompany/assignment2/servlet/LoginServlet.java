package com.mycompany.assignment2.servlet;

import com.mycompany.assignment2.dao.UserDAO;
import com.mycompany.assignment2.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.loginUser(loginId, password);

        if (user != null) {

            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", user);

            if ("ADMIN".equalsIgnoreCase(user.getRole())) {

                response.sendRedirect("adminHome.jsp");

            } else {

                response.sendRedirect(request.getContextPath() + "/UserProductServlet");

            }

        } else {

            response.getWriter().println("Invalid Login Credentials!");

        }
    }
}