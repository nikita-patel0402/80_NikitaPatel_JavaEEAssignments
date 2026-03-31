package com.mycompany.assignment2.servlet;

import com.mycompany.assignment2.dao.ProductDAO;
import com.mycompany.assignment2.model.Product;
import com.mycompany.assignment2.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Admin check
        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("loggedUser") : null;

        if (user == null || !"ADMIN".equalsIgnoreCase(user.getRole())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
            return;
        }

        Product p = new Product();

        p.setProductName(request.getParameter("name"));
        p.setPrice(Double.parseDouble(request.getParameter("price")));
        p.setUnit(request.getParameter("unit"));

        String discountStr = request.getParameter("discount");
        double discount = (discountStr == null || discountStr.isEmpty()) ? 0 : Double.parseDouble(discountStr);
        p.setDiscount(discount);

        p.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
        p.setStock(Integer.parseInt(request.getParameter("stock")));

        // image filename only
        p.setImage(request.getParameter("image"));

        ProductDAO dao = new ProductDAO();

        if (dao.addProduct(p)) {
            response.sendRedirect(request.getContextPath() + "/ViewProductServlet");
        } else {
            response.getWriter().println("Error Adding Product");
        }
    }
}