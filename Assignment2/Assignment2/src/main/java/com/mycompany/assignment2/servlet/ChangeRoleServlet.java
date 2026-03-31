package com.mycompany.assignment2.servlet;

import com.mycompany.assignment2.dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/ChangeRoleServlet")
public class ChangeRoleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));
        String role = request.getParameter("role");

        UserDAO dao = new UserDAO();
        dao.updateUserRole(userId, role);

        response.sendRedirect("adminHome.jsp");
    }
}