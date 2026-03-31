<%-- 
    Document   : book
    Created on : 4 Mar 2026, 8:56:43 pm
    Author     : riya vesuwala
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Books</h1><br><br>
        <c:forEach var="b" items="${bookList}">
            <table border="2px">
                <tr>
                    <th>Book Name</th>
                    <th>Price</th>
                </tr>
                <tr>
                    <td>${b.bookName}</td>
                    <td>${b.price}</td>
                    <td><a href="CustomerServlet?action=add&bookId=${b.bookId}">Add To Cart</a></td>
                </tr>
            </table>
        </c:forEach>
    </body>
</html>
