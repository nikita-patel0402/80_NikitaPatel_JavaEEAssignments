package com.mycompany.assignment2.servlet;

import com.mycompany.assignment2.dao.ProductDAO;
import com.mycompany.assignment2.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Admin-only check
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("loggedUser");
        if (user == null || !"ADMIN".equalsIgnoreCase(user.getRole())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO dao = new ProductDAO();
        if (dao.deleteProduct(id)) {
            response.sendRedirect(request.getContextPath() + "/ViewProducts.jsp");
        } else {
            response.getWriter().println("Error deleting product");
        }
    }
}