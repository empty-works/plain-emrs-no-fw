<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-setup.css" />

<title>Add Facility</title>
</head>
<body>

	<div class="main-container">
		<!-- Side navigation -->
		<div class="sidenav main-font">	
			<div><a href="<c:url value="/FacilitiesServlet" />">Facilities</a></div>
			<div><a href="<c:url value="/RolesServlet" />">Roles</a></div>
			<div><a href="<c:url value="/WEB-INF/AddNonPatient.jsp" />">Add Non-Patient</a></div>
		</div>

		<!-- Main content --> 
		<div class="main main-font">

		<h2>Facility Setup</h2>	
		<br><br>	
		<form action="AddFacilityServlet" method="post">
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

		</div>
	</div>
</body>
</html>