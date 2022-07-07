<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
<link rel="icon" href="../resources/favicon.jpg">
<link rel="stylesheet" href="../css/commons.css">
<link rel="stylesheet" href="../css/register.css">
</head>

<div class="vertical-menu">
  <a href="../index.jsp">Home</a>
  <a href="login.jsp">Login</a>
  <a href="register.jsp" class="active">Registration</a>
  <a href="contact.jsp">Contact</a>
</div>
<br>

<div style="margin-left:200px;">

<h2 align="center"> Registration Form </h2>
<form align="center" name="form1" form action="../RegisterServlet" method="post">

<div style="margin-left:1%;">    <!--title of form-->
  <h1 style="color:#4D8BAB;">Sign up today.</h1>
  <p> Already have an account? Click <a style="color:#3EB2D8;text-decoration: none; " href="../pages/login.jsp">here</a>!</p>
  <hr style="border-radius: 5px;border: 1px solid black;">
   <div class="imgcontainer">
    <img src="../resources/avatar.png" class="avatar">
  </div>
</div>

<table>

<tr height="55">
<th align="right">Username:</th>
<th><input type="text" name="username" size="35" maxlength="33" style="height:33px;" ></th>
</tr>

<tr height="55">
<th align="right">Password:</th>
<th><input type="password" name="password" size="35" maxlength="33" style="height:33px;"></th>
</tr>

<tr height="55">
<th align="right">Name:</th>
<th><input type="text" name="name" size="35" maxlength="33" style="height:33px;" ></th>
</tr>

<tr height="55">
<th align="right">Surname:</th>
<th><input type="text" name="surname" size="35" maxlength="33" style="height:33px;" ></th>
</tr>

<tr height="55">
<th align="right">Email:</th>
<th><input type="text" name="username" size="35" maxlength="33" style="height:33px;" ></th>
</tr>

<tr height="55">
<th align="right">Registration Num:</th>
<th><input type="text" name="regnum" size="35" maxlength="33" style="height:33px;"></th>
</tr>
</table>
<label for="role">Role:</label>
  <select name="role" id="role">
<option>Student</option>
<option>Professor</option>
<option>Secretary</option>
  </select>
  <br>
<input type="Reset" class="resetbtn" name="Reset" value="Clean"/>
<input type="Submit" class="submitbtn" name="Submit" value="Register"/>
<br><br>
</form></div>
</body>
</html>