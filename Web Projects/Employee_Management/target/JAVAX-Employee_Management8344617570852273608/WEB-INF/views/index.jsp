<%--
  Created by IntelliJ IDEA.
  User: Navod Madusanka
  Date: 8/7/2023
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Login Page</h1>
    <p>Username: <input id="username" type="text" name="username" required></p>
    <p>Password: <input id="password" type="password" name="password" required></p>
    <p><input onclick="login();" type="submit" value="Login"></p>
    <script src="js/script.js"></script>
</body>
</html>
