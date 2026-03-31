<%-- 
    Document   : cart
    Created on : 4 Mar 2026, 9:59:05 pm
    Author     : riya vesuwala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Shopping Cart</h2>
        
        <table border="2">
        <tr>
            <th>Book</th>
            <th>Price</th>
            <th>Qty</th>
            <th>Total</th>
        </tr>

        <c:set var="grandTotal" value="0"/>

        <c:forEach var="entry" items="${sessionScope.cart}">
        <tr>
            <td>${entry.key.bookName}</td>
            <td>${entry.key.price}</td>
            <td>${entry.value}</td>

            <td>${entry.key.price * entry.value}</td>

            <c:set var="grandTotal"
                   value="${grandTotal +
                   (entry.key.price * entry.value)}"/>
        </tr>
        </c:forEach>
        </table>

        <h3>Total Bill : ${grandTotal}</h3>

        <form action="CustomerServlet" method="post">
            <input type="submit" value="Place Order"/>
        </form>
        <a href="BookServlet">Add Books</a>
    </body>
</html>
