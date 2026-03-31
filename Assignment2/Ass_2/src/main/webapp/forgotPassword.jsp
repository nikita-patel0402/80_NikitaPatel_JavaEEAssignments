<%-- 
    Document   : forgotPassword
    Created on : 04-Feb-2026, 9:12:57 am
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Forgot Password</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<div class="container">
    <h2>Forgot Password</h2>

    <form action="ForgotPasswordServlet" method="post">
        <label>Login ID</label>
        <input type="text" name="loginId" required>

        <button type="submit">Next</button>
    </form>

    <a href="login.jsp">Back to Login</a>
</div>

</body>
</html>

