<%-- 
    Document   : register
    Created on : 22-Jan-2026, 12:19:11 pm
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.Random" %>
<%
    // Generate CAPTCHA
    String chars = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
    String captcha = "";
    Random r = new Random();
    for(int i=0; i<5; i++){
        captcha += chars.charAt(r.nextInt(chars.length()));
    }
    session.setAttribute("captcha", captcha);
%>

<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" href="CSS/form.css">
</head>
<body>
    <div class="container">
<h2>User Registration</h2>

<form action="RegisterServlet" method="post">

<label>Username</label>
<input type="text" name="username" required>

<label>Login ID</label>
<input type="text" name="loginId" required>

<label>Password</label>
<input type="password" name="password" required>

<label>Security Question</label>
<select name="question">
    <option>What is your pet name?</option>
    <option>What is your birth city?</option>
</select>

<label>Answer</label>
<input type="text" name="answer" required>

<label>Email</label>
<input type="email" name="email">

<label>Phone</label>
<input type="text" name="phone">
<label> Date of Birth:</label>
<input type="date" name="dob" required>
<label>Address</label>
<textarea name="address"></textarea>

    <!-- CAPTCHA -->
    <b>CAPTCHA: <%= captcha %></b><br>
    <label> Enter CAPTCHA: </label>
    <input type="text" name="captchaInput" required><br><br>

    <input type="submit" value="Register">
    </form>
<a href="login.jsp">Back to Login</a>

</div>
</body>
</html>

