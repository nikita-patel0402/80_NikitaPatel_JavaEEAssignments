<%-- 
    Document   : shop
    Created on : 27-Jan-2026, 11:31:43 am
    Author     : root
--%>

<%@ page import="java.sql.*" %>
<html>
<head>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<header>
    <a href="cart.jsp">View Cart</a>
    <a href="LogoutServlet">Logout</a>
</header>

<div class="container">
<h2>Shop</h2>

<%
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/shopDB","root","root");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM product_master");

while(rs.next()){
%>

<div class="card">
    <h3><%= rs.getString("product_name") %></h3>
    <p>Rs. <%= rs.getDouble("price") %></p>

    <form action="AddToCartServlet" method="post">
        <input type="hidden" name="productId" value="<%= rs.getInt("product_id") %>">
        <input type="hidden" name="productName" value="<%= rs.getString("product_name") %>">
        <input type="hidden" name="price" value="<%= rs.getDouble("price") %>">
        <input type="hidden" name="discount" value="<%= rs.getDouble("discount") %>">
        <input type="submit" value="Add to Cart">
    </form>
</div>

<% } con.close(); %>

</div>
</body>
</html>
