<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.assignment2.model.Product" %>

<%
List<Product> products = (List<Product>) request.getAttribute("products");
%>

<html>
<head>
<title>Products</title>
</head>
<body>

<h2>Available Products</h2>

<a href="ViewCart.jsp">View Cart</a>

<table border="1">

<tr>
<th>Image</th>
<th>Name</th>
<th>Price</th>
<th>Discount</th>
<th>Stock</th>
<th>Action</th>
</tr>

<% if(products != null){
for(Product p : products){ %>

<tr>

<td>
<img src="images/<%= p.getImage() %>" width="80">
</td>

<td><%= p.getProductName() %></td>

<td>? <%= p.getPrice() %></td>

<td><%= p.getDiscount() %>%</td>

<td><%= p.getStock() %></td>

<td>

<form action="${pageContext.request.contextPath}/AddToCartServlet" method="post">

<input type="hidden" name="productId" value="<%= p.getProductId() %>">

<input type="submit" value="Add to Cart">

</form>

</td>

</tr>

<% }} %>

</table>

</body>
</html>