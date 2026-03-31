<%-- 
    Document   : addCategory
    Created on : 03-Feb-2026, 11:53:01 am
    Author     : root
--%>

<html>
<head>
<link rel="stylesheet" href="CSS/form.css">
</head>
<body>

<div class="container">
<h2>Add Category</h2>

<form action="CategoryServlet" method="post">
    <label>Category Name</label>
    <input type="text" name="categoryName" required>

    <button type="submit">Save Category</button>
</form>

<a href="admin.jsp">Back</a>
</div>

</body>
</html>
