package com.mycompany.assignment2.servlet;

import com.mycompany.assignment2.dao.ProductDAO;
import com.mycompany.assignment2.model.Product;
import com.mycompany.assignment2.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Admin check
        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("loggedUser") : null;

        if (user == null || !"ADMIN".equalsIgnoreCase(user.getRole())) {
            response.sendRedirect("login.jsp");
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));

        ProductDAO dao = new ProductDAO();
        Product product = dao.getProductById(id);

        request.setAttribute("product", product);
        request.getRequestDispatcher("WEB-INF/editProduct.jsp").forward(request, response);
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    double price = Double.parseDouble(request.getParameter("price"));
    String unit = request.getParameter("unit");
    double discount = Double.parseDouble(request.getParameter("discount"));
    String image = request.getParameter("image");   
    int categoryId = Integer.parseInt(request.getParameter("categoryId"));
    int stock = Integer.parseInt(request.getParameter("stock"));

    Product p = new Product();
    p.setProductId(id);
    p.setProductName(name);
    p.setPrice(price);
    p.setUnit(unit);
    p.setDiscount(discount);
    p.setImage(image);              
    p.setCategoryId(categoryId);
    p.setStock(stock);

    ProductDAO dao = new ProductDAO();
    dao.updateProduct(p);

    response.sendRedirect("ViewProductServlet");
    }
}