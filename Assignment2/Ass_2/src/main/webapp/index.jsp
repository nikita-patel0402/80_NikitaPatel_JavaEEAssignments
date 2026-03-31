<%-- 
    Document   : home.jsp
    Created on : 22-Jan-2026, 12:14:08 pm
    Author     : root
--%>

<!DOCTYPE html>
<html>
<head>
    <title>Fashion Store</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f5f5f5;
        }

        /* HEADER */
        .header {
            background: #111;
            color: white;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header h1 {
            margin: 0;
        }

        .nav a {
            color: white;
            margin-left: 20px;
            text-decoration: none;
            font-weight: bold;
        }

        .nav a:hover {
            text-decoration: underline;
        }

        /* HERO SECTION */
        .hero {
            background: linear-gradient(to right, #ff9800, #ff5722);
            color: white;
            padding: 60px 20px;
            text-align: center;
        }

        .hero h2 {
            font-size: 36px;
            margin-bottom: 10px;
        }

        .hero button {
            padding: 12px 25px;
            font-size: 16px;
            border: none;
            background: white;
            color: #ff5722;
            cursor: pointer;
            border-radius: 5px;
        }

        /* CATEGORY SECTION */
        .section {
            padding: 40px 20px;
            text-align: center;
        }

        .categories {
            display: flex;
            justify-content: center;
            gap: 20px;
            flex-wrap: wrap;
        }

        .card {
            background: white;
            width: 200px;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .card h3 {
            margin: 10px 0;
        }

        /* FOOTER */
        .footer {
            background: #111;
            color: white;
            text-align: center;
            padding: 15px;
            margin-top: 30px;
        }
    </style>
</head>

<body>

<!-- HEADER -->
<div class="header">
    <h1>Fashion Store</h1>
    <div class="nav">
        <a href="index.jsp">Home</a>
        <a href="login.jsp">Login</a>
        <a href="register.jsp">Register</a>
        <!--<a href="forgotPassword.jsp">Forgot Password</a>-->
    </div>
</div>

<!-- HERO / SALE -->
<div class="hero">
    <h2>Big Fashion Sale ?</h2>
    <p>Up to 50% OFF on latest collections</p>
    <button onclick="location.href='login.jsp'">Shop Now</button>
</div>

<!-- CATEGORY -->
<div class="section">
    <h2>Shop by Category</h2>

    <div class="categories">
        <div class="card">
            <h3>Men</h3>
            <p>Trendy & Stylish</p>
        </div>

        <div class="card">
            <h3>Women</h3>
            <p>Latest Collections</p>
        </div>

        <div class="card">
            <h3>Kids</h3>
            <p>Comfort & Fun</p>
        </div>

        <div class="card">
            <h3>Accessories</h3>
            <p>Complete Your Look</p>
        </div>
    </div>
</div>

<!-- FOOTER -->
<div class="footer">
    © 2026 Fashion Store | All Rights Reserved
</div>

</body>
</html>
