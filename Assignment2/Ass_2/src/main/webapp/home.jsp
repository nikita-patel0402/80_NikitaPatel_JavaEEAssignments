<%-- 
    Document   : home.
    Created on : 04-Feb-2026, 8:22:42 am
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<header>
    <a href="shop.jsp">Shop</a>
    <a href="cart.jsp">Cart</a>
    <a href="admin.jsp">Admin</a>
    <a href="LogoutServlet">Logout</a>
</header>

<div class="container">
    <h2>Welcome, <%= session.getAttribute("username") %></h2>
</div>

</body>
</html>

