<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.StudentDB" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="servletpackage.StudentServlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grades by Semester</title>
<link rel="stylesheet" href="../../css/commons.css">
<link rel="stylesheet" href="../../css/showCourses.css">
<%if(session.getAttribute("username")==null){response.sendRedirect("../login.jsp");}%> 
</head>
<body>
<div class="vertical-menu">
  <a href="../../index.jsp">Home</a>
  <a href="#">User Profile</a>
  <a href="courseGrade.jsp">Course grades</a>
  <a href="semesterGrade.jsp" class="active">Semester grades</a>
  <a href="totalGrade.jsp">Total grades</a>
  <a href="../contact.jsp">Contact</a>
    <%if(session.getAttribute("username")!=null){%>
  <form id="logout" action="../../LogoutServlet" method="POST">
  	<a href="#" onclick="document.getElementById('logout').submit();" class="logout"> Logout </a>
  </form>
  <%}%>
</div>
<br>
<div style="margin-left:5%;">
		<h2 style="  text-align: center;"> Grades</h2>
		<div style="margin-left:5%;">
		<%out.println(StudentDB.getSemesterGrade(session.getAttribute("username").toString()));%>
</div>

	
</div>
</body>
</html>