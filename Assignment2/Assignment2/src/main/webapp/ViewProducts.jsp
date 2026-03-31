<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.assignment2.model.Product" %>
<%@ page import="com.mycompany.assignment2.dao.ProductDAO" %>
<%@ page import="com.mycompany.assignment2.dao.CategoryDAO" %>
<%@ page import="com.mycompany.assignment2.model.Category" %>
<%@ page import="com.mycompany.assignment2.model.User" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // ===============================
    // ADMIN SESSION CHECK
    // ===============================
    User user = (User) session.getAttribute("loggedUser");
    if (user == null || !"ADMIN".equalsIgnoreCase(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    ProductDAO productDAO = new ProductDAO();
    CategoryDAO categoryDAO = new CategoryDAO();

    List<Product> products = productDAO.getAllProducts();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Products</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        h2 {
            margin-bottom: 15px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #000;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        img {
            max-width: 80px;
            max-height: 80px;
        }

        a {
            text-decoration: none;
            margin: 0 5px;
        }

        .top-links {
            margin-bottom: 15px;
        }

        .btn {
            padding: 6px 10px;
            background-color: #007bff;
            color: white;
            border-radius: 4px;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .delete {
            color: red;
        }
    </style>
</head>

<body>

<h2>All Products</h2>

<div class="top-links">
    <a href="addProduct.jsp" class="btn">+ Add New Product</a>
    <a href="adminDashboard.jsp" class="btn">Back to Dashboard</a>
</div>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Unit</th>
        <th>Discount</th>
        <th>Stock</th>
        <th>Category</th>
        <th>Image</th>
        <th>Actions</th>
    </tr>

    <%
        for (Product p : products) {

            // Get category name
            Category cat = categoryDAO.getCategoryById(p.getCategoryId());
    %>

    <tr>
        <td><%= p.getProductId() %></td>
        <td><%= p.getProductName() %></td>
        <td>₹ <%= p.getPrice() %></td>
        <td><%= p.getUnit() %></td>
        <td><%= p.getDiscount() %> %</td>
        <td><%= p.getStock() %></td>

        <td>
            <%= (cat != null) ? cat.getCategoryName() : "N/A" %>
        </td>

        <td>
            <% if (p.getImage() != null && !p.getImage().isEmpty()) { %>
                <img src="uploads/<%= p.getImage() %>" 
                     alt="<%= p.getProductName() %>">
            <% } else { %>
                No Image
            <% } %>
        </td>

        <td>
            <a href="EditProductServlet?id=<%= p.getProductId() %>">Edit</a> |

            <a href="DeleteProductServlet?id=<%= p.getProductId() %>"
               class="delete"
               onclick="return confirm('Are you sure you want to delete this product?');">
               Delete
            </a>
        </td>
    </tr>

    <%
        }
    %>

</table>

<br><br>
<a href="LogoutServlet">Logout</a>

</body>
</html>