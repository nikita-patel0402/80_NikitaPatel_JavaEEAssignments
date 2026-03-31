<%-- 
    Document   : addProduct
    Created on : 03-Feb-2026, 12:09:53 pm
    Author     : root
--%>

<html>
<head>
<link rel="stylesheet" href="CSS/form.css">
</head>
<body>

<div class="container">
<h2>Add Product</h2>

<form action="ProductServlet" method="post">

<label>Product Name</label>
<input type="text" name="productName" required>

<label>Price</label>
<input type="number" name="price" required>

<label>Discount</label>
<input type="number" name="discount">

<label>Stock</label>
<input type="number" name="stock">

<label>Category ID</label>
<input type="number" name="categoryId">

<button type="submit">Save Product</button>
</form>

<a href="admin.jsp">Back</a>
</div>

</body>
</html>
