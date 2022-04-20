<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-setup.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-general.css" />

<title>Add Facility</title>
</head>

<body>

	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>

	<div class="main-container">
		<!-- Side navigation -->
		<div class="sidenav main-font">	
			<div><a href="<c:url value="/FacilitiesServlet" />">← Back to Facilities</a></div>
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