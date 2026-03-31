<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.assignment2.dao.UserDAO" %>
<%@ page import="com.mycompany.assignment2.model.User" %>

<%
    UserDAO dao = new UserDAO();
    List<User> users = dao.getAllUsers();
%>

<h2>Admin Dashboard</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Login ID</th>
        <th>Email</th>
        <th>Role</th>
        <th>Action</th>
    </tr>

    <%
        for(User u : users){
    %>
    <tr>
        <td><%= u.getUserId() %></td>
        <td><%= u.getUsername() %></td>
        <td><%= u.getLoginId() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getRole() %></td>

        <td>

            <% if (!"ADMIN".equalsIgnoreCase(u.getRole())) { %>

                <a href="DeleteUserServlet?id=<%= u.getUserId() %>"
                   onclick="return confirm('Are you sure?')">
                   Delete
                </a>

                |
                <a href="ChangeRoleServlet?id=<%= u.getUserId() %>&role=ADMIN">
                   Make Admin
                </a>

            <% } else { %>

                <a href="ChangeRoleServlet?id=<%= u.getUserId() %>&role=USER">
                   Make User
                </a>

            <% } %>

        </td>

    </tr>
    <%
        }
    %>
</table>

<br>
<a href="ViewProducts.jsp">View Product</a>
<a href="LogoutServlet">Logout</a>
