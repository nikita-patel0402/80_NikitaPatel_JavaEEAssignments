<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.assignment2.model.Product" %>

<%
    List<Product> cart = (List<Product>) session.getAttribute("cart");
    if(cart == null || cart.isEmpty()) {
        response.sendRedirect("viewCart.jsp");
        return;
    }

    double subtotal = 0;
    double taxPercent = 0.05;
    for(Product p : cart) {
        subtotal += (p.getPrice() - p.getDiscount());
    }
    double tax = subtotal * taxPercent;
    double total = subtotal + tax;
%>

<html>
<head>
    <title>Checkout</title>
</head>
<body>
<h2>Checkout</h2>

<table border="1">
<tr>
    <th>Product Name</th>
    <th>Price</th>
    <th>Discount</th>
</tr>
<% for(Product p : cart) { %>
<tr>
    <td><%= p.getProductName() %></td>
    <td><%= p.getPrice() %></td>
    <td><%= p.getDiscount() %></td>
</tr>
<% } %>
</table>

<p>Subtotal: <%= subtotal %></p>
<p>Tax (5%): <%= tax %></p>
<p><b>Total: <%= total %></b></p>

<br>

<form action="<%=request.getContextPath()%>/CheckoutServlet" method="post">
    Name: <input type="text" name="name" required><br><br>
    Address: <textarea name="address" required></textarea><br><br>
    Payment Mode:
    <select name="payment" required>
        <option value="Credit Card">Credit Card</option>
        <option value="Debit Card">Debit Card</option>
        <option value="Cash on Delivery">Cash on Delivery</option>
    </select><br><br>

    <input type="submit" value="Place Order">
</form>

<br>
<a href="viewCart.jsp">Back to Cart</a>

</body>
</html>