<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<link rel="icon" href="../resources/favicon.jpg">
<link rel="stylesheet" href="../css/commons.css">
<link rel="stylesheet" href="../css/login.css">
</head>

<body>
<div class="vertical-menu">
  <a href="#">Home</a>
  <a href="login.jsp" class="active">Login</a>
  <a href="register.jsp">Registration</a>
  <a href="contact.jsp">Contact</a>
</div>


<div style="margin-left:200px;">
<br><br><br>
<form action="../LoginServlet"method="post">
	<br>
	<div class="imgcontainer">
    	<img src="../resources/logo.jpg" style="max-width:200px;max-height:200px;" alt="unipi" class="unipi"> 
  	</div>
	<div class="container">
 		<b> Welcome to the User Authentication Platform </b><i>VKAD</i>
 		<br><br>
 	    <div class="input_container">
    		<svg aria-hidden="true" focusable="false" width="14px" height="13px" viewBox="0 0 32 26" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:sketch="http://www.bohemiancoding.com/sketch/ns" style="width: 12px;height: 14px;top: auto;bottom: 14px;left: 12px;position: absolute;font-size: 12px;"><g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" sketch:type="MSPage"><g id="32px" sketch:type="MSLayerGroup" transform="translate(-2155.000000, -2317.000000)" fill="#373A39"><g id="Group-856" transform="translate(1.000000, 1.000000)" sketch:type="MSShapeGroup"><path id="Fill-419" d="M2184,2339 C2184,2339.55 2183.55,2340 2183,2340 L2157,2340 C2156.45,2340 2156,2339.55 2156,2339 L2156,2319 C2156,2318.45 2156.45,2318 2157,2318 L2183,2318 C2183.55,2318 2184,2318.45 2184,2319 L2184,2339 L2184,2339 Z M2184,2316 L2156,2316 C2154.89,2316 2154,2316.89 2154,2318 L2154,2340 C2154,2341.1 2154.89,2342 2156,2342 L2184,2342 C2185.1,2342 2186,2341.1 2186,2340 L2186,2318 C2186,2316.89 2185.1,2316 2184,2316 L2184,2316 Z M2176,2322 L2180,2322 L2180,2326 L2176,2326 L2176,2322 Z M2174,2328 L2182,2328 L2182,2320 L2174,2320 L2174,2328 Z M2158,2332 L2172,2332 L2172,2330 L2158,2330 L2158,2332 Z M2158,2336 L2172,2336 L2172,2334 L2158,2334 L2158,2336 Z"></path></g></g></g></svg>
    		<input type="text" name="username" style="outline:none;margin:0;left:18px;height: 40px;font-size: 13px;width: 90%;border-radius: 0 2px 2px 0;box-sizing: border-box;position: relative;" autocomplete="off" autocapitalize="off" value="" aria-label="Password" aria-invalid="false" placeholder="Enter Username">
   		</div>
   		<br>
    	<div class="input_container">
    		<svg aria-hidden="true" focusable="false" width="11px" height="14px" viewBox="0 0 13 16" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style="width: 12px;height: 14px;top: auto;bottom: 14px;left: 12px;position: absolute;font-size: 12px;"><g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"><g transform="translate(-288.000000, -1508.000000)" fill="#888888"><path d="M299,1523.998 L290,1523.998 C288.896,1523.998 288,1523.102 288,1521.999 L288,1515.999 C288,1514.895 288.896,1513.998 290,1513.998 L290,1513.998 L290,1512.499 C290,1510.015 292.015,1507.999 294.5,1507.999 C296.985,1507.999 299,1510.015 299,1512.499 L299,1513.999 C300.104,1513.999 301,1514.895 301,1515.999 L301,1521.999 C301,1523.103 300.104,1523.998 299,1523.998 L299,1523.998 Z M298,1512.499 C298,1510.566 296.433,1508.999 294.5,1508.999 C292.567,1508.999 291,1510.566 291,1512.499 L291,1513.998 L298,1513.998 L298,1512.499 L298,1512.499 Z M300,1515.999 C300,1515.446 299.552,1514.998 299,1514.998 L290,1514.998 C289.447,1514.998 289,1515.446 289,1515.999 L289,1521.999 C289,1522.551 289.447,1522.998 290,1522.998 L299,1522.998 C299.552,1522.998 300,1522.551 300,1521.999 L300,1515.999 L300,1515.999 Z M294.5,1520.998 C294.224,1520.998 294,1520.774 294,1520.498 L294,1517.498 C294,1517.223 294.224,1516.999 294.5,1516.999 C294.776,1516.999 295,1517.223 295,1517.498 L295,1520.498 C295,1520.774 294.776,1520.998 294.5,1520.998 L294.5,1520.998 Z"></path></g></g></svg>
    		<input type="password" name="password" style="outline:none;margin:0;left:18px;height: 40px;font-size: 13px;width: 90%;border-radius: 0 2px 2px 0;box-sizing: border-box;position: relative;" autocomplete="off" autocapitalize="off" value="" aria-label="Password" aria-invalid="false" placeholder="Enter Password">
   		</div>
		<br>
    	<button type="submit">Login</button>
    	<%if(request.getParameter("nologin") != null){%>
    		<br><br>
    		<p style="color:red;margin:0;">Invalid login details, please try again.</p>
    	<%}else{%>
    	<br>
    	<%} %>
    	<label><br><input type="checkbox" checked="checked" name="remember"> Remember me</label>
		<br>
  </div>
  <div class="container" style="background-color:#f1f1f1">
    <button class="cancelbtn" type="reset">Cancel</button>&nbsp;&nbsp;&nbsp;&nbsp;
    <span class="psw">Forgot <a style="color:#3EB2D8;text-decoration: none;" href="#">password</a>?</span>
  </div>
</form>
</div>

</body>
</html>