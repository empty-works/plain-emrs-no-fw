<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome! Please log in.</title>
</head>
<body>
	<form action="loginServlet" method="post">
	<table>
	<tr>
		<td>Username:</td>
		<td><input type="text" name="userName"/></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" name="password"/></td>
	</tr>	
	<tr>
		<td></td>
		<td><input type="submit" /></input><input type="reset" value="Reset"></input></td>
	</tr>
	</table>
	</form>	
</body>
</html>