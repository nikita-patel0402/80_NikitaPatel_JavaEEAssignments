<%-- 
    Document   : viewCategory
    Created on : 03-Feb-2026, 11:54:31 am
    Author     : root
--%>

<%@ page import="java.sql.*" %>
<html>
<link rel="stylesheet" href="CSS/style.css">
<body>
<div class="container">
<h2>Category List</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Parent</th>
    <th>Action</th>
</tr>

<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/shopDB","root","root");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM category_master");

    while(rs.next()){
%>
<tr>
    <td><%= rs.getInt("category_id") %></td>
    <td><%= rs.getString("category_name") %></td>
    <td><%= rs.getInt("parent_category_id") %></td>
    <td>
        <a href="CategoryServlet?id=<%= rs.getInt("category_id") %>">Delete</a>
    </td>
</tr>
<% } con.close(); %>

</table>

<a href="addCategory.jsp">Add New Category</a>
</div>
</body>
</html>
