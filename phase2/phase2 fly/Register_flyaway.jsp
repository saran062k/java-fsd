<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	if(request.getParameter("flight_num")!=null)
	{
		out.println("\nfight number retrieved "+request.getParameter("flight_num"));
	}
%>

<div align="center">
<table border="2px" bgcolor="powderblue" width="330px" height="300px">
<form action="Register_flyaway" method="post" >
	<tr><td>
		<label>Full Name</label><br>
		<input type="text" placeholder="Enter Full Name" name="fullname"><br>
		<label>Address</label><br>
		<input type="text" placeholder="Enter Address" name="address"><br><br>
		<label>Age</label><br>
		<input type="text" placeholder="Enter Age" name="age"><br><br>
		<label>Mobile No</label><br>
		<input type="text" placeholder="Enter Mobile" name="mobile"><br><br>
		<label>Username</label><br>
		<input type="text" placeholder="Enter Username" name="username"><br><br>
		<label>Choose a Personal Id from this list:
		<input list="personal_id" name="myPersonal" /></label>
		<datalist id="personal_id">
		<option value="Aadhaar Card">
  		<option value="SSN">
  		<option value="Passport Number">
  		<option value="Voter ID">
  		<option value="Driving License">
		</datalist>
		<input type="text" placeholder="Enter your Personal ID Number" name="per_id"><br><br>
		<label>Country</label><br>
		<input type="text" placeholder="Enter Country" name="country"><br><br>
		<center><input type="submit" value="Submit"></center>
	</td></tr>
</form>
</table>
</div>
</body>
</html>