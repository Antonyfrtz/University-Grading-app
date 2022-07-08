<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact</title>
<link rel="icon" href="../resources/favicon.jpg">
<link rel="stylesheet" href="../css/commons.css">
<link rel="stylesheet" href="../css/courseProf.css">
<%if(session.getAttribute("username")==null){response.sendRedirect("../login.jsp");}%>
</head>
<body>
<div class="vertical-menu">
  <a href="../index.jsp">Home</a>
  <a href="login.jsp">Login</a>
  <a href="register.jsp" >Registration</a>
  <a href="contact.jsp" class="active">Contact</a>
        <%if(session.getAttribute("username")!=null){%>
  <form id="logout" action="../LogoutServlet" method="POST">
  	<a href="#" onclick="document.getElementById('logout').submit();" class="logout"> Logout </a>
  </form>
  <%}%>
</div>
<br><br>

<h2 align="center"> Contact Info </h2>

<div style="margin-left:5%;">
<table class="center">
<tr>
    <th>Professors</th>
  </tr>
  <tr>
    <th>Fullname</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Office Number</th>
  </tr>
  <tr>
    <th>Claudia Christophle</th>
    <th>claudia@gmail.com</th>
    <th>6980796856</th>
    <th>304</th>
  </tr>
  <tr>
    <th>Concordia Docharty</th>
    <th>concordia@gmail.com</th>
    <th>6956789043</th>
    <th>405</th>
  </tr>
  <tr>
    <th>Chaunce Gerty</th>
    <th>chaunce@gmail.com</th>
    <th>2103456786</th>
    <th>566</th>
  </tr>
  <tr>
    <th>Clay Vanner</th>
    <th>clay@gmail.com</th>
    <th>2107634521</th>
    <th>301</th>
  </tr>
  <tr>
    <th>Grenville Fidell</th>
    <th>grenville@gmail.com</th>
    <th>2106789543</th>
    <th>240</th>
  </tr>
  <tr>
    <th>Kiel Whitby</th>
    <th>kiel@gmail.com</th>
    <th>6987509342</th>
    <th>323</th>
  </tr>
  <tr>
    <th>Sandy Justis</th>
    <th>sandy@gmail.com</th>
    <th>2108790654</th>
    <th>402</th>
  </tr>
  <tr>
    <th>Tait Clardge</th>
    <th>tait@gmail.com</th>
    <th>6908769345</th>
    <th>309</th>
  </tr>
</table>



<table class="center">
<tr>
    <th>Secretaries</th>
  </tr>
  <tr>
    <th>Department</th>
    <th>Email</th>
    <th>Phone</th>
  </tr>
    <tr>
    <th>Informatics</th>
    <th>csuni@gmail.com</th>
    <th>2107890567</th>
  </tr>
    <tr>
    <th>          </th>
    <th>informatics@gmail.com</th>
    <th>2108790654</th>
  </tr>
    <tr>
    <th>          </th>
    <th>uniuni@gmail.com</th>
    <th>2105678903</th>
  </tr>
    <tr>
    <th>          </th>
    <th>css@gmail.com</th>
    <th>2103456987</th>
  </tr>
</table>
</div>
<br><br><br><br><br><br>

</body>
</html>