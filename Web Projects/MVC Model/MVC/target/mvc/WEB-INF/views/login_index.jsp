<%--
  Created by IntelliJ IDEA.
  User: Navod Madusanka
  Date: 7/30/2023
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <h1>Login....</h1>
    <form method="post" action="login">
    <table>
        <tr>
            <th>Username:</th>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <th>Password:</th>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="login"></td>
        </tr>
    </table>
    </form>
</body>
</html>
