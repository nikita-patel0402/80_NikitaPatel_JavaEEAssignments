<%-- 
    Document   : bill
    Created on : 26-Feb-2026, 11:32:46 am
    Author     : root
--%>

<%@ page import="java.sql.*" %>
<%
int orderId = Integer.parseInt(request.getParameter("orderId"));
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/shopDB","root","root");

PreparedStatement ps = con.prepareStatement(
    "SELECT * FROM order_master WHERE order_id=?");
ps.setInt(1, orderId);
ResultSet rs = ps.executeQuery();
rs.next();
%>

<html>
<head>
<title>Bill</title>
<style>
body{font-family:Arial;}
.bill-box{width:600px;margin:auto;border:1px solid #ccc;padding:20px;}
</style>
</head>
<body>

<div class="bill-box">
<h2>Invoice</h2>

<p><b>Bill No:</b> <%= rs.getString("bill_no") %></p>
<p><b>Date:</b> <%= rs.getString("order_datetime") %></p>
<p><b>Total:</b> ? <%= rs.getDouble("total_amount") %></p>
<p><b>Payment Status:</b> <%= rs.getString("payment_status") %></p>

<hr>

<h3>Items:</h3>

<%
PreparedStatement ps2 = con.prepareStatement(
"SELECT od.*, p.product_name FROM order_details od JOIN product_master p ON od.product_id=p.product_id WHERE od.order_id=?");
ps2.setInt(1, orderId);
ResultSet rs2 = ps2.executeQuery();

while(rs2.next()){
%>

<p>
<%= rs2.getString("product_name") %> 
- Qty: <%= rs2.getInt("quantity") %> 
- ? <%= rs2.getDouble("product_price") %>
</p>

<% } %>

<hr>
<h3>Grand Total: ? <%= rs.getDouble("total_amount") %></h3>
</div>
<form action="PaymentServlet" method="post">
<input type="hidden" name="orderId" value="<%= orderId %>">
<button type="submit">Pay Now</button>
</form>
</body>
</html>