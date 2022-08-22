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
<center><h3>Search Page</h3></center>
</font>
<div align="center">
<table border="2px" bgcolor="powderblue" width="230px" height="300px">
<form action="Flight_flyaway" method="post">
	<tr><td>
		<label>Date of Travel</label>
		<input type="text" placeholder="yyyy-mm-dd"  name="date_of_travel"><br><br>
		<label>Source City</label>
		<input type="text" placeholder="Enter Source City" name="source_city"><br><br>
		<label>Destination City</label>
		<input type="text" placeholder="Enter Destination City" name="destination_city"><br><br>
		<label>No of Persons</label>
		<input type="text" placeholder="Enter no of persons" name="no_of_person"><br><br>
		
		<center><input type="submit" value="Search"></center>
	</td></tr>
</form>
</table>
</div>
</body>
</html>