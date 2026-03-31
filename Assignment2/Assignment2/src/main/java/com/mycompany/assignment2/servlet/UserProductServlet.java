package com.mycompany.assignment2.servlet;

import com.mycompany.assignment2.dao.ProductDAO;
import com.mycompany.assignment2.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/UserProductServlet")
public class UserProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductDAO dao = new ProductDAO();

        List<Product> products = dao.getAllProducts();

        request.setAttribute("products", products);

        request.getRequestDispatcher("userProducts.jsp").forward(request, response);
    }
}