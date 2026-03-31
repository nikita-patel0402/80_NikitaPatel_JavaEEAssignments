<%-- 
    Document   : viewProduct
    Created on : 03-Feb-2026, 12:12:15 pm
    Author     : root
--%>

<%@ page import="java.sql.*" %>
<html>
<link rel="stylesheet" href="CSS/style.css">

<body>
    <div class="container">
<h2>Product List</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Stock</th>
    <th>Action</th>
</tr>

<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/shopDB","root","root");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM product_master");

    while(rs.next()){
%>
<tr>
    <td><%= rs.getInt("product_id") %></td>
    <td><%= rs.getString("product_name") %></td>
    <td><%= rs.getDouble("price") %></td>
    <td><%= rs.getInt("stock") %></td>
    <td>
        <a href="ProductServlet?id=<%= rs.getInt("product_id") %>">Delete</a>
    </td>
</tr>
<% } con.close(); %>

</table>

<a href="addProduct.jsp">Add Product</a>
    </div>
</body>
</html>
