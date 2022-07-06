<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.DB" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="servletpackage.SecretaryServlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assign Professor to Course</title>
<link rel="stylesheet" href="../css/commons.css">
<link rel="stylesheet" href="../css/assignment.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>
<body>
<div class="vertical-menu">
  <a href="#">Home</a>
  <a href="#">User Profile</a>
  <a href="allcourses.jsp">Courses</a>
  <a href="courseProf.jsp">Teaching staff per course</a>
  <a href="assignment.jsp" class="active">Course and Professor Management</a>
  <a href="contact.jsp">Contact</a>
</div>
<br>
<br>
<div style="margin-left:200px;" >
<h2 style="  text-align: center;">Assign Professor to Course</h2>
<form method="post" action="../SecretaryServlet" >
  <label for="courses">Choose one of the available courses:</label>
  <select name="courses" id="courses">
  <% out.println(DB.getCourses());%>
  </select>
  <br><br>
  <label for="professors">Choose a professor to assign the previously selected course:</label>
  <select name="professors" id="professors">
  <% out.println(DB.getProfessors());%>
  </select>
  <br><br>
  <input type="submit" value="Submit" class="button">
   
</form>
</div>
<div style="margin-left:200px;">
 <%
 String param=request.getParameter("updated");
 if(param==null){
 %>
   <br>
 <%
 }else if(param.equals("true")){
 %>
<br>
	<div class="info" style="min-height: 50px; height: 50px;background-color:#08a68c;color:white;">
	<i class="fa fa-check" style="font-size:38px;color:white;margin:5px;float:left;"></i><label style="display:inline-block;float: left;margin-top:16px;margin-left:5px;">Successful Assignment!</label>
	</div>
 <%
 }else{
 %>
  <%--Database Error--%>
  <br>
	<div class="info" style="min-height: 50px; height: 50px;background-color:#cc2d2d;color:white;">
    <i class="fa fa-close" style="font-size:38px;color:#f2dcdc;margin:5px;float:left;"></i><label style="display:inline-block;float: left;margin-top:16px;margin-left:5px;color:white">An error occured! Please try later:)</label>
    </div>
 <%} %>
   </div>
</body>
</html>