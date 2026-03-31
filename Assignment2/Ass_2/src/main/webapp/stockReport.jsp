<%-- 
    Document   : stockReport
    Created on : 26-Feb-2026, 11:02:08 am
    Author     : root
--%>

<%@ page import="java.util.*" %>
<html>
<head>
<title>Stock Report</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<div class="container">
<h2>Stock Report</h2>

<table border="1" width="100%">
<tr>
<th>Product ID</th>
<th>Product Name</th>
<th>Stock</th>
</tr>

<%
ArrayList<String[]> list =
    (ArrayList<String[]>) request.getAttribute("stockList");

if (list != null) {
    for (String[] row : list) {
%>
<tr>
<td><%= row[0] %></td>
<td><%= row[1] %></td>
<td><%= row[2] %></td>
</tr>
<%
    }
}
%>

</table>
</div>

</body>
</html>