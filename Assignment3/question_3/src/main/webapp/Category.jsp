<%-- 
    Document   : Category
    Created on : 2 Mar 2026, 9:16:07 pm
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
        <form action="CategoryServlet" method="post">
            <input type="hidden"
                name="categoryId"
                value="${category.categoryId}" /><br><br>
            Category Name :
            <input type="text"
                   name="categoryName"
                   value="${category.categoryName}" />

            <br/><br/>

            <input type="submit"
                   name="action"
                   value="${category == null ? 'add' : 'edit'}"/>
                </form>
                <hr>
            <table
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="c" items="${categoryList}">
                    <tr>
                        <td>${c.categoryId}</td>
                        <td>${c.categoryName}</td>
                        <td><a href="CategoryServlet?action=update&categoryId=${c.categoryId}">Update</a></td>
                        <td><a href="CategoryServlet?action=delete&categoryId=${c.categoryId}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        <a href="ProductServlet">Manage Products</a>
    </body>
</html>
