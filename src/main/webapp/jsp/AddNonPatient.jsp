<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plain EMRS - Add Non-Patient</title>
</head>
<body>
	<form action="AddNonPatientServlet" method="post">
	<table>
		<tr>
		<td>Given Name: </td>
		<td><input type="text" name="givenName" /></td>
		</tr>	
		<tr>
		<td>Middle Name: </td>
		<td><input type="text" name="middleName" /></td>
		</tr>
		<tr>
		<td>Last Name: </td>
		<td><input type="text" name="lastName" /></td>
		</tr>
		<tr>
		<td>Email: </td>
		<td><input type="email" name="emailAddress" /></td>
		</tr>
		<tr>
		<td>Date of Birth: </td>
		<td><input type="date" name="dateOfBirth" /></td>
		</tr>
		<tr>
		<td>Organization: </td>
		<td><input type="text" name="organization" /></td>
		</tr>
		<tr>
		<td>Description: </td>
		<td><input type="text" name="description" /></td>
		</tr>
		<tr>
		<td><input type="submit" /></input><input type="reset" value="Reset"></input></td>	
		</tr>	
	</table>		
	</form>
</body>
</html>