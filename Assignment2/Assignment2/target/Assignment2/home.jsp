<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if (session.getAttribute("loggedUser") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<html>
<body>

<h2>Welcome to Fashion Store</h2>

<a href="LogoutServlet">Logout</a>
</body>
</html>