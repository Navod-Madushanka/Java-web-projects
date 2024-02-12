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
<div>
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
</div>
<div>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>
</div>
<div>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
</div>
<button type="button" id="register-button">Register</button>
<script src="js/script.js"></script>
</body>
</html>
