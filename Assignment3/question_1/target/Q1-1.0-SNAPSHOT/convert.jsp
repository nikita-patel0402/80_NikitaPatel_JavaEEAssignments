<%-- 
    Document   : convert
    Created on : 2 Mar 2026, 5:21:17 pm
    Author     : riya vesuwala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ConvertServlet" method="post">
            From: <select name="from">
                <option>USD</option>
                <option>INR</option>
                <option>EUR</option>
            </select>
            To: <select name="to">
                <option>INR</option>
                <option>USD</option>
                <option>EUR</option>
            </select>
            
            Amount: <input type="text" name="amount"/>
            <input type="submit" value="convert"/>
        </form>
        
        <h2>
            Converted Amount : ${result}
        </h2>
    </body>
</html>
