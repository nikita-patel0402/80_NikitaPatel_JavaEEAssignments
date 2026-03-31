<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>

<h2>User Registration Form</h2>

<form action="RegisterServlet" method="post">

    Name: <input type="text" name="username" required /><br><br>

    Login ID: <input type="text" name="loginId" required /><br><br>

    Password: <input type="password" name="password" required /><br><br>

    Password Question:
    <input type="text" name="passwordQuestion" required /><br><br>

    Password Answer:
    <input type="text" name="passwordAnswer" required /><br><br>

    Email: <input type="email" name="email" required /><br><br>

    Phone: <input type="text" name="phone" required /><br><br>

    Address: <input type="text" name="address" /><br><br>

    City: <input type="text" name="city" /><br><br>

    State: <input type="text" name="state" /><br><br>

    Country: <input type="text" name="country" /><br><br>

    Pin: <input type="text" name="pin" /><br><br>

    Date of Birth: <input type="date" name="dob" required /><br><br>

    <!-- Simple Captcha -->
    <%
        int num1 = (int)(Math.random() * 10);
        int num2 = (int)(Math.random() * 10);
        int sum = num1 + num2;
        session.setAttribute("captcha", sum);
    %>

    Solve: <%= num1 %> + <%= num2 %> =
    <input type="text" name="captchaAnswer" required /><br><br>

    <input type="submit" value="Register" />

</form>

</body>
</html>