<%-- 
    Document   : cart
    Created on : 03-Feb-2026, 11:41:26 am
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.CartItem" %>

<html>
<head>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<div class="container">
<h2>Your Cart</h2>

<table>
<tr>
<th>Product</th><th>Price</th><th>Qty</th><th>Total</th><th>Action</th>
</tr>

<%
ArrayList<CartItem> cart =
    (ArrayList<CartItem>) session.getAttribute("cart");
double total = 0;

if(cart != null){
    for(CartItem item : cart){
        total += item.getTotal();
%>
<tr>
<td><%= item.getProductName() %></td>
<td><%= item.getPrice() %></td>
<td><%= item.getQuantity() %></td>
<td><%= item.getTotal() %></td>
<td>
<a href="RemoveFromCartServlet?productId=<%= item.getProductId() %>">Remove</a>
</td>
</tr>
<% }} %>

<tr>
<td colspan="3"><b>Grand Total</b></td>
<td colspan="2"><b><%= total %></b></td>
</tr>
</table>

<br>
<a href="CheckoutServlet"><button>Checkout</button></a>
</div>

</body>
</html>
