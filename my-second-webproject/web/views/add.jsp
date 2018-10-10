<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 10.10.2018
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body>
    <div>
        <%
            if (request.getAttribute("userName") != null) {
                out.println("<p>User '" + request.getAttribute("userName") + "' added!</p>");
            }
        %>
    </div>
    <div>
        <div>
            <h2>
                Add user!
            </h2>
        </div>
        <form method="post">
            <label>
                Name:
                <input type="text" name="name"><br />
            </label>

            <label>Password:
                <input type="text" name="pass"><br />
            </label>

            <button type="submit">Submit</button>
        </form>
    </div>
    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</body>
</html>
