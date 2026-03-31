<%-- 
    Document   : login
    Created on : 27-Jan-2026, 11:26:05 am
    Author     : root
--%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/form.css">
</head>
<body>
<%
String msg = (String) request.getAttribute("msg");
if (msg != null) {
%>
<p style="color:green;"><%= msg %></p>
<%
}
%>
<div class="container">
<h2>Login</h2>

<form action="LoginServlet" method="post">
    <label>Login ID</label>
    <input type="text" name="loginId" required>

    <label>Password</label>
    <input type="password" name="password" required>

    <button type="submit">Login</button>
</form>

<a href="register.jsp">New User? Register</a>
<a href="forgotPassword.jsp">Forgot Password?</a>

</div>

</body>
</html>
