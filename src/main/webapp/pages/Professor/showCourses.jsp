<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.ProfessorDB" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="servletpackage.ProfessorServlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grade list by Course</title>
<link rel="stylesheet" href="../../css/commons.css">
<link rel="stylesheet" href="../../css/showCourses.css">
</head>
<body>
<div class="vertical-menu">
  <a href="../../index.html">Home</a>
  <a href="#">User Profile</a>
  <a href="grading.jsp" class="active">Grading</a>
  <a href="showCourses.jsp">Grade list by course</a>
  <a href="../contact.jsp">Contact</a>
</div>
<div style="margin-left:5%;">
		<h2 style="  text-align: center;"> Grades list</h2>
		<div style="margin-left:5%;">
		<% out.println(ProfessorDB.getGradesTable("cchristophled"));%>
</div>

	
</div>

</body>
</html>