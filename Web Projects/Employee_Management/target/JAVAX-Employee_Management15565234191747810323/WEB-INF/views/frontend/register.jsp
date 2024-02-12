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
<p>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>
</p>
<p>
    <label for="position">Position:</label>
    <input type="text" id="position" name="position" required>
</p>
<p>
    <label for="department">Department:</label>
    <input type="text" id="department" name="department" required>
</p>
<p>
    <label for="hireDate">Hire Date:</label>
    <input type="date" id="hireDate" name="hireDate" required>
</p>
<p>
    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" required>
</p>
<p>
    <input type="submit" value="Submit">
</p>
<script src="js/script.js"></script>
</body>
</html>
