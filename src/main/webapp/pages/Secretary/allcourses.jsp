<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.sql.Connection" %>
<%@ page import="com.DB" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show courses</title>
<link rel="stylesheet" href="../../css/commons.css">
<link rel="stylesheet" href="../../css/allcourses.css">
</head>
<body>

<div class="vertical-menu">
  <a href="../../index.html">Home</a>
  <a href="#">User Profile</a>
  <a href="allcourses.jsp" class="active">Courses</a>
  <a href="courseProf.jsp">Teaching staff per course</a>
  <a href="assignment.jsp">Course and Professor Management</a>
  <a href="../contact.jsp">Contact</a>
</div>
<br>
<div style="margin-left:5%;">

<%
String user=request.getParameter("username");
if(user!=null){
%>
<h2 style="  text-align: center;">Welcome <%=user %>!</h2>
<%}else{ %>
<br>
<%} %>

<h2 style="  text-align: center;">Courses</h2>

		<h2 style="  text-align: center;"> Those are all the courses</h2>
		
	    <table class="center">
        	<thead>
            	<tr>
                	<th style="  text-align: center;">Course Year</th>
                	<th style="  text-align: center;">Semester</th>
                	<th style="  text-align: center;">Course Name</th>
                	<th style="  text-align: center;">Course ID</th>
            	</tr>
        	</thead>
        	<tbody>
		<%
			Connection con=DB.con(); 
 	 		Statement st = con.createStatement();
  			ResultSet rs = st.executeQuery("SELECT * FROM java2db.courses ORDER BY courseyear");
  			while(rs.next()){
  		%>
  			<tr>
                <%
                    int courseyear = rs.getInt("courseyear");
                    int semester = rs.getInt("semester");
                    String coursename = rs.getString("coursename");
                    String courseid = rs.getString("course_id");
                %>
                <td style="  text-align: center;"><%=courseyear %></td>
                <td style="  text-align: center;"><%=semester%></td>
                <td style="  text-align: center;"><%=coursename %></td>
                <td style="  text-align: center;"><%=courseid %></td>
                
            </tr>               

            <%      
  			}
            %>

        </tbody>
    </table>

	
</div>

</body>
</html>