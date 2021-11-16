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
		
		<div>Name: </div>
		<div><input type="text" name="facilityName" /></div>
		<div>Street address: </div>
		<div><input type="text" name="facilityStreetAddress" /></div>
		<div>City: </div>
		<div><input type="text" name="facilityCity" /></div>
		<div>State: </div>
		<div><input type="text" name="facilityState" /></div>
		<div>Country: </div>
		<div><input type="text" name="facilityCountry" /></div>
		<div>ZIP code: </div>
		<div><input type="text" name="facilityZipCode" /></div>
		<div>Number of beds: </div>
		<div><input type="number" name="facilityNumBeds" min="3" max="100000" /></div>
		<div>Description: </div>
		<div><input type="text" name="facilityDescription" /></div>
		<div><input type="submit" /><input type="reset" name="Reset" /></div>
	</form>
</body>
</html>