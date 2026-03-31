<%@ page import="com.mycompany.assignment2.model.User" %>
<%@ page import="com.mycompany.assignment2.model.Category" %>
<%@ page import="com.mycompany.assignment2.dao.CategoryDAO" %>
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

    // Fetch categories
    CategoryDAO categoryDAO = new CategoryDAO();
    List<Category> categories = categoryDAO.getAllCategories();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Product</title>
</head>
<body>
    <h2>Add New Product</h2>

   <form action="AddProductServlet" method="post">

    Product Name:<br>
    <input type="text" name="name" required><br><br>

    Price:<br>
    <input type="number" step="0.01" name="price" required><br><br>

    Unit:<br>
    <input type="text" name="unit"><br><br>

    Discount:<br>
    <input type="number" step="0.01" name="discount"><br><br>

    Image File Name:<br>
    <input type="text" name="image" placeholder="example.jpg"><br><br>

    Category:<br>
    <select name="categoryId" required>
        <%
            if (categories.isEmpty()) {
        %>
                <option value="">No categories found</option>
        <%
            } else {
                for (Category c : categories) {
        %>
                    <option value="<%= c.getCategoryId() %>">
                        <%= c.getCategoryName() %>
                    </option>
        <%
                }
            }
        %>
    </select><br><br>

    Stock:<br>
    <input type="number" name="stock" required><br><br>

    <button type="submit">Add Product</button>
</form>
</body>
</html>