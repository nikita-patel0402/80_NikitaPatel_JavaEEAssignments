<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.assignment2.model.Product" %>

<%
    List<Product> cart = (List<Product>) session.getAttribute("cart");
%>

<html>
<head>
    <title>Your Cart</title>
</head>
<body>
<h2>Your Cart</h2>

<a href="UserProductServlet">Continue Shopping</a>

<table border="1">
<tr>
    <th>Name</th>
    <th>Price</th>
    <th>Discount</th>
</tr>

<% if(cart != null && !cart.isEmpty()) {
       for(Product p : cart) { %>
<tr>
    <td><%= p.getProductName() %></td>
    <td><%= p.getPrice() %></td>
    <td><%= p.getDiscount() %></td>
</tr>
<%   } %>
</table>

<br>
<form action="<%=request.getContextPath()%>/CheckoutServlet" method="get">
    <input type="submit" value="Proceed to Checkout">
</form>

<% } else { %>
<tr>
    <td colspan="3">Cart is empty</td>
</tr>
</table>
<% } %>

</body>
</html>