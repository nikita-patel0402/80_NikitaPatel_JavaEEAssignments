<%@ page import="com.mycompany.assignment2.model.Product" %>
<%@ page import="com.mycompany.assignment2.model.User" %>
<%@ page import="com.mycompany.assignment2.dao.CategoryDAO" %>
<%@ page import="com.mycompany.assignment2.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>

<%
    // Admin-only check
    User user = (User) session.getAttribute("loggedUser");
    if (user == null || !"ADMIN".equalsIgnoreCase(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    Product product = (Product) request.getAttribute("product");
    if (product == null) {
        response.getWriter().println("Product not found!");
        return;
    }

    // Fetch categories
    CategoryDAO categoryDAO = new CategoryDAO();
    List<Category> categories = categoryDAO.getAllCategories();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
</head>
<body>
<h1 style="color:red;">NEW EDIT PAGE</h1>
<h2>Edit Product</h2>

<form action="EditProductServlet" method="post">

    <input type="hidden" name="id" value="<%= product.getProductId() %>">

    Product Name:<br>
    <input type="text" name="name"
           value="<%= product.getProductName() %>" required><br><br>

    Price:<br>
    <input type="number" step="0.01" name="price"
           value="<%= product.getPrice() %>" required><br><br>

    Unit:<br>
    <input type="text" name="unit"
           value="<%= product.getUnit() %>"><br><br>

    Discount:<br>
    <input type="number" step="0.01" name="discount"
           value="<%= product.getDiscount() %>"><br><br>
    
        Image File Name:<br>
        <input type="text" name="image"
       value="<%= product.getImage() %>"><br><br>

    Category:<br>
    <select name="categoryId" required>
        <% for (Category c : categories) { %>
            <option value="<%= c.getCategoryId() %>"
                <%= (c.getCategoryId() == product.getCategoryId()) ? "selected" : "" %>>
                <%= c.getCategoryName() %>
            </option>
        <% } %>
    </select><br><br>

    Stock:<br>
    <input type="number" name="stock"
           value="<%= product.getStock() %>" required><br><br>

    <button type="submit">Update Product</button>

</form>

</body>
</html>