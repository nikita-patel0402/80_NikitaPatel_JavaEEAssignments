<%-- 
    Document   : answerQuestion
    Created on : 04-Feb-2026, 9:13:47 am
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Security Question</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<div class="container">
    <h2>Security Question</h2>

    <form action="ResetPasswordServlet" method="post">

    <input type="hidden" name="loginId"
           value="<%= request.getAttribute("loginId") %>">

    <label><%= request.getAttribute("question") %></label>
    <input type="text" name="answer" required>

    <label>New Password</label>
    <input type="password" name="newPassword" required>

    <button type="submit">Update Password</button>
</form>

</div>

</body>
</html>
