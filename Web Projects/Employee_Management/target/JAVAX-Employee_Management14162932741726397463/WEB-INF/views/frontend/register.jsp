<%--
  Created by IntelliJ IDEA.
  User: Navod Madusanka
  Date: 8/19/2023
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<p>Username: <input id="username" type="text" name="username" required></p>
<p>Password: <input id="password" type="password" name="password" required></p>
<p><input onclick="login();" type="submit" value="Login"></p>
<p><button onclick="goToRegister();">Register</button></p>
<script src="js/script.js"></script>
</body>
</html>
