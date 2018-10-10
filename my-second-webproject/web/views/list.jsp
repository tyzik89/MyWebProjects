<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 10.10.2018
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body>
    <div>
        <div>
            <h2>Users</h2>
        </div>
        <%
            List<String> names = (List<String>) request.getAttribute("userNames");
            if (names != null && !names.isEmpty()) {
                out.println("<ui>");
                for (String s : names) {
                    out.println("<li>" + s + "</li>");
                }
                out.println("</ui>");
            } else
                out.println("<p>There are no users yet!</p>");
        %>
    </div>
</body>
</html>
