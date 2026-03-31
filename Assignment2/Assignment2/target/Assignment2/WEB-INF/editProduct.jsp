<%@ page import="com.mycompany.assignment2.model.Product" %>
<%
    Product p = (Product) request.getAttribute("product");
%>
<form action="EditProductServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="<%= p.getProductId() %>">

    Name: <input type="text" name="name" value="<%= p.getProductName() %>"><br><br>
    Price: <input type="number" step="0.01" name="price" value="<%= p.getPrice() %>"><br><br>
    Stock: <input type="number" name="stock" value="<%= p.getStock() %>"><br><br>
    Unit: <input type="text" name="unit" value="<%= p.getUnit() %>"><br><br>
    Discount: <input type="number" step="0.01" name="discount" value="<%= p.getDiscount() %>"><br><br>
    Category ID: <input type="number" name="categoryId" value="<%= p.getCategoryId() %>"><br><br>
    Image: <input type="file" name="image"><br><br>

    <button type="submit">Update Product</button>
</form>