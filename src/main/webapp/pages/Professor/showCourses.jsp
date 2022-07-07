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
<%if(session.getAttribute("username")==null){response.sendRedirect("../login.jsp");}%>
</head>
<body>
<div class="vertical-menu">
  <a href="../../index.jsp">Home</a>
  <a href="#">User Profile</a>
  <a href="grading.jsp">Grading</a>
  <a href="showCourses.jsp" class="active">Grade list by course</a>
  <a href="../contact.jsp">Contact</a>
      <%if(session.getAttribute("username")!=null){%>
  <form id="logout" action="../../LogoutServlet" method="POST">
  	<a href="#" onclick="document.getElementById('logout').submit();" class="logout"> Logout </a>
  </form>
  <%}%>
</div>
<br>
<div style="margin-left:5%;">
		<h2 style="  text-align: center;"> Grades list</h2>
		<div style="margin-left:5%;">
		<%out.println(ProfessorDB.getGradesTable(session.getAttribute("username").toString()));%>
</div>

	
</div>

</body>
</html>