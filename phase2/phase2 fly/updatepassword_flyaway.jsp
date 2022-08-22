<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<Body  style="background-color:black;"> 
<font color='white'>
<center><h3>Update Password Page</h3></center>
</font>
<div align="center">
<table border="2px" bgcolor="powderblue" width="230px" height="300px">
<form action="Updatepassword_flyaway" method="post">
	<tr><td>
		<label>Username</label>
		<input type="text" placeholder="Enter Username" name="username"><br><br>
		<label>Old PassWord</label>
		<input type="password" placeholder="Enter Your Old Password" name="password"><br><br>
		<label>New Password</label>
		<input type="password" placeholder="Enter Your New Password" name="newpassword"><br><br>
		
		<center><input type="submit" value="Submit"></center>
	</td></tr>
</form>
</table>
</div>
</body>
</html>