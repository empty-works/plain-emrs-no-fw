<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Facility Setup</title>
</head>
<body>
	<h2>Facility Setup</h2>	
	<br><br>	
	<form action="FacilitySetupServlet" method="post">
	<table>
		<tr>
		<td>Name: </td>
		<td><input type="text" name="facilityName" /></td>
		</tr>
		<tr>
		<td>Street address: </td>
		<td><input type="text" name="facilityStreetAddress" /></td>
		</tr>
		<tr>
		<td>City: </td>
		<td><input type="text" name="facilityCity" /></td>
		</tr>
		<tr>
		<td>State: </td>
		<td><input type="text" name="facilityState" /></td>
		</tr>
		<tr>
		<td>Country: </td>
		<td><input type="text" name="facilityCountry" /></td>
		</tr>
		<tr>
		<td>Zip code: </td>
		<td><input type="text" name="facilityZipCode" /></td>
		</tr>
		<tr>
		<td>Number of beds: </td>
		<td><input type="number" name="facilityNumBeds" min="3" max="100000" /></td>
		</tr>
		<tr>
		<td>Description: </td>
		<td><input type="text" name="facilityDescription" /></td>
		</tr>
		<tr>
		<td><input type="submit" /><input type="reset" name="Reset" /></td>
		</tr>
	</table>	
	</form>
</body>
</html>