<%-- 
    Document   : Product
    Created on : 3 Mar 2026, 7:30:54 pm
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
        <form action="ProductServlet" method="post">
            <input type="hidden" name="productId" value="${product.productId}" /><br><br>
            Product Name : <input type="text" name="productName" value="${product.productName}" /><br><br>
            Price : <input type="number" name="price" value="${product.price}" /><br><br>
            Stock : <input type="number" name="stock" value="${product.stock}" /><br><br>
            Category : <select name="categoryId">
                <c:forEach var="c" items="${categoryList}">
                    <option value="${c.categoryId}"
                        <c:if test="${not empty product 
                            and product.categoryId.categoryId eq c.categoryId}">
                            selected
                        </c:if>>
                        ${c.categoryName}
                    </option>
                </c:forEach>
            </select>
            <input type="submit" name="action" value="${product==null? 'add' : 'edit'}" />
            <hr>
        </form> 
            <table border="2">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Category</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="p" items="${productList}">
                    <tr>
                        <td>${p.productId}</td>
                        <td>${p.productName}</td>
                        <td>${p.price}</td>
                        <td>${p.stock}</td>
                        <td>${p.categoryId.categoryName}</td>
                        <td><a href="ProductServlet?action=update&productId=${p.productId}">Update</a></td>
                        <td><a href="ProductServlet?action=delete&productId=${p.productId}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="Category.jsp">Manage Categories</a>
    </body>
</html>
