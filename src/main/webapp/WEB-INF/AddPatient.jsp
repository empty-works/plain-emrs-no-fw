<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-grid.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/patients.css" />
<title>Plain EMRS - Add Patient</title>
</head>
<body>

	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>
	
	<div class="main-container">
			
		<!-- Side navigation -->
		<div class="sidenav main-font">
			<script id="replace_with_sidenav" src="${pageContext.request.contextPath}/js/patientssidenav.js"></script>
		</div>
		
		<!-- Main content --> 
		<div class="main-grid-container-side-nav main-font">
			<form class="content-padding" action="AddPatientServlet" method="post">
				<label>Given Name: </label>	
				<div><input type="text" id="patientGivenName" name="patientGivenName" /></div>
				<label>Middle Initial: </label>
				<div><input type="text" id="patientMiddleInitial" name="patientMiddleInitial" /></div>
				<label>Last Name: </label>
				<div><input type="text" id="patientLastName" name="patientLastName" /></div>
				<label>Date of Birth: </label>
				<div><input type="date" id="patientDateOfBirth" name="patientDateOfBirth" /></div>
				<label>Gender: </label>
				<div><input type="text" id="patientGender" name="patientGender" /></div>
				<label>Type: </label>
				<div><input type="text" id="patientType" name="patientType" /></div>
				<label>Race: </label>
				<div><input type="text" id="patientRace" name="patientRace" /></div>
				<label>Ethnicity: </label>
				<div><input type="text" id="patientEthnicity" name="patientEthnicity" /></div>
				<label>Email Address: </label>
				<div><input type="text" id="patientEmailAddress" name="patientEmailAddress" /></div>
				<label>Street Address: </label>
				<div><input type="text" id="patientStreetAddress" name="patientStreetAddress" /></div>
				<label>City: </label>
				<div><input type="text" id="patientCity" name="patientCity" /></div>
				<label>State: </label>
				<div><input type="text" id="patientCountry" name="patientCountry" /></div>
				<label>Phone Number: </label>
				<div><input type="text" id="patientPhoneNumber" name="patientPhoneNumber" /></div>
				<label>Provider: </label>
				<div><input type="text" id="patientProvider" name="patientProvider" /></div>
				<label>Provider ID: </label>
				<div><input type="number" id="patientProviderId" name="patientProviderId" /></div>
				<label>Facility ID: </label>
				<div><input type="text" id="patientFacilityId" name="patientFacilityId" /></div>
				<label>Room: </label>
				<div><input type="text" id="patientRoom" name="patientRoom" /></div>
				<label>Language Preference: </label>
				<div><input type="text" id="patientLanguagePreference" name="patientLanguagePreference" /></div>
				<div><input type="submit" /><input type="reset" name="Reset" /></div>
			</form>
		</div>
	</div>

	<form action="AddPatientServlet" method="post">
	
	</form>
</body>
</html>