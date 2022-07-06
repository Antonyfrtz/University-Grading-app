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
<script type="text/javascript">
function populateCustomerId(){
    var selectBox = document.getElementById('courses');
    var selectedCourseName= selectBox.options[selectBox.selectedIndex].value;
    document.getElementById('selectedCourse').innerHTML = selectedCourseName;
    return selectedCourseName;
}
</script>
<meta charset="UTF-8">
<title>Grading</title>
<link rel="stylesheet" href="../../css/commons.css">
<link rel="stylesheet" href="../../css/grading.css">
</head>
<body>
<div class="vertical-menu">
  <a href="../../index.html">Home</a>
  <a href="#">User Profile</a>
  <a href="grading.jsp" class="active">Grading</a>
  <a href="showCourses.jsp">Grade list by course</a>
  <a href="../contact.jsp">Contact</a>
</div>
<br>
<br>
<div style="margin-left:200px;" >
<h2 style="  text-align: center;">Assign Grade to students</h2>
<form method="post" action="../ProfessorServlet" >
  <label for="courses">Choose one of your courses:</label>
  <select name="courses" id="courses" onchange="populateCustomerId();">
  
  <% out.println(ProfessorDB.getCourses("cchristophled"));%>
  </select>
  <h1 id="selectedCourse"></h1>
  </form>
  </div>
  <br><br>
</body>
</html>