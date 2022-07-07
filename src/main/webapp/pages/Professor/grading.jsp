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
<title>Grading</title>
<link rel="stylesheet" href="../../css/commons.css">
<link rel="stylesheet" href="../../css/grading.css">
<link rel="stylesheet" href="../../css/courseProf.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<script type="text/javascript" src="../../js/chooseOption.js"></script>
<%if(session.getAttribute("username")==null){response.sendRedirect("../login.jsp");}%> 
</head>
<body>
<div class="vertical-menu">
  <a href="../../index.jsp">Home</a>
  <a href="#">User Profile</a>
  <a href="grading.jsp" class="active">Grading</a>
  <a href="showCourses.jsp">Grade list by course</a>
  <a href="../contact.jsp">Contact</a>
    <%if(session.getAttribute("username")!=null){%>
  <form id="logout" action="../../LogoutServlet" method="POST">
  	<a href="#" onclick="document.getElementById('logout').submit();" class="logout"> Logout </a>
  </form>
  <%}%>
</div>
<br>
<br>
<div style="margin-left:200px;" >
  <h3 style="text-align: center;">Assign Grade to students</h3>
  <form id="selectionform" class="selectionform" method="post" action="../../ProfessorServlet" >
	  <label for="courses">Choose one of your courses:</label>
	  <select name="courses" id="courses" onchange="getSelectedCourse();">
	  <%out.println(ProfessorDB.getCourses(session.getAttribute("username").toString()));%>
	  </select>
	  <h1 id="selectedCourse"></h1>
  </form>
  <%if(request.getParameter("vassiliki") != null){%>
  <div>
  	<form id="gradingform" method="post" action="../../ProfessorGradingServlet">
  		
		<table>
		  	<tr>
		    	<th>Student Id</th>
		    	<th>Name</th>
		   		<th>Surname</th>
		    	<th>Grade</th>
		   </tr>
		  	<%
		  		String c=request.getParameter("vassiliki");
		  		c=c.replace("%20"," ");
		  		out.println(ProfessorDB.getCourseStud(c));
		  		out.println("<input type=\"text\" name=\"courseInput\" id=\"courseInput\" style=\"display:none;\" value=\""+c+"\">");
		  	%>
	  	</table>
	  	<br>
	  	<input class="submit" type="submit" value="Submit">
	  	<% }%>
  	</form>
  	<%if(request.getParameter("postback")==null){%><br>
  	<%}else if((request.getParameter("postback")).equals("true")){%>
  		<br>
		<div class="info" style="min-height: 50px; height: 50px;width:60%;background-color:#08a68c;color:white;">
		<i class="fa fa-check" style="font-size:38px;color:white;margin:5px;float:left;"></i><label style="display:inline-block;float: left;margin-top:16px;margin-left:5px;">Successful Grade Assignments!</label>
		</div>
	<%}else if((request.getParameter("postback")).equals("false")){ %>
		  <%--Database Error--%>
	  	<br>
		<div class="info" style="min-height: 50px; height: 50px;background-color:#cc2d2d;color:white;">
	    <i class="fa fa-close" style="font-size:38px;color:#f2dcdc;margin:5px;float:left;"></i><label style="display:inline-block;float: left;margin-top:16px;margin-left:5px;color:white">An error occured! Please try later:)</label>
	    </div>
	<%} %>
  </div>
</div>
<br><br>
</body>
</html>