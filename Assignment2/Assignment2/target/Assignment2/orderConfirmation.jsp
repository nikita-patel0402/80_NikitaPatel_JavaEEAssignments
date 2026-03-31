<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.assignment2.model.Product" %>

<%
    List<Product> cart = (List<Product>) request.getAttribute("cart");
%>

<html>
<head>
    <title>Order Confirmation</title>
</head>
<body>
<h2>Order Placed Successfully!</h2>

<p>Thank you for your order.</p>

<table border="1">
<tr>
    <th>Product Name</th>
    <th>Price</th>
    <th>Discount</th>
</tr>
<% if(cart != null) {
       for(Product p : cart) { %>
<tr>
    <td><%= p.getProductName() %></td>
    <td><%= p.getPrice() %></td>
    <td><%= p.getDiscount() %></td>
</tr>
<%   }
   } %>
</table>

<a href="UserProductServlet">Continue Shopping</a>

</body>
</html>