<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.Connection" %>
<%@ page import="com.SecretaryDB" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses and Professors</title>
<link rel="stylesheet" href="../../css/commons.css">
<link rel="stylesheet" href="../../css/courseProf.css">
</head>
<body>
<div class="vertical-menu">
  <a href="../../index.html">Home</a>
  <a href="#">User Profile</a>
  <a href="allcourses.jsp">Courses</a>
  <a href="courseProf.jsp" class="active">Teaching staff per course</a>
  <a href="assignment.jsp">Course and Professor Management</a>
  <a href="../contact.jsp">Contact</a>
</div>
<br>
<h2>Courses and Professor in charge per course</h2>
<br>
<div style="margin-left:5%;">
<table class="center">
  <tr>
    <th>Course Code</th>
    <th>Name</th>
    <th>Year</th>
    <th>Semester</th>
    <th>Professor in charge</th>
  </tr>
    <% out.println(SecretaryDB.coursesProfTable());%>
</table>
</div>
</body>
</html>