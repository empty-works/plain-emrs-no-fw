<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-grid.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-setup.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css" />

<title>Add Chief Complaint</title>
</head>
<body>
	
	<div class="main-container">
		<!-- Side navigation -->
		<div class="sidenav main-font">
			<div><a href="${pageContext.request.contextPath}/UserPatientChartOverviewServlet?userPatientId=${userPatientId}">Latest Chief Complaint</a></div>
			<div><a href="${pageContext.request.contextPath}/UserPatientPersonalServlet?userPatientId=${userPatientId}">Personal Details</a></div>
			<div><a>Timeline</a></div>
			<div class="sidenav-active">Add Chief Complaint</div>
			<br />
			<br />
			<br />
			<!-- Prompt user if they really want to return to the patient list -->
			<div><a href="<c:url value="/UserPatientListServlet" />"><-- Return to patient list</a></div>
		</div>

		<!-- Main content -->
		<div class="main-grid-container form-font form-dimensions">
			<h2 id="patientTitle">Add Chief Complaint Form</h2>
			<form id="addChiefComplaintForm" name="addChiefComplaintForm" class="content-padding" action="AddChiefComplaintServlet" method="post">
				<fieldset>
					<legend>New Chief Complaint</legend>
					<textarea id="chiefComplaintInput" name="chiefComplaintInput"></textarea>
				</fieldset>					
				<fieldset>
					<legend>Vitals</legend>	
					<label for="vitalsHeightCm">Height: </label>
					<input type="number" id="vitalsHeightCm" name="vitalsHeightCm" min="50" max="255">
					<label for="vitalsWeightKg">Weight: </label>
					<input type="number" id="vitalsWeightKg" name="vitalsWeightKg">
					<label for="vitalsBmi">Calculated BMI:</label>
					<input type="number" id="vitalsBmi" name="vitalsBmi">	
					<label for="vitalsTemperature">Temperature:</label>
					<input type="number" id="vitalsTemperature" name="vitalsTemperature">
					<label for="vitalsPulse">Pulse rate:</label>
					<input type="number" id="vitalsPulse" name="vitalsPulse">
					<label for="vitalsRespiratoryRate">Respiratory rate:</label>
					<input type="number" id="vitalsRespiratoryRate" name="vitalsRespiratoryRate">
					<label for="vitalsBPSystolic">Blood pressure systolic:</label>
					<input type="number" id="vitalsBPSystolic" name="vitalsBPSystolic">
					<label for="vitalsBPDiastolic">Blood pressure diastolic:</label>
					<input type="number" id="vitalsBPDiastolic" name="vitalsBPDiastolic">
					<label for="vitalsBloodO2Saturation">Arterial blood oxygen saturation:</label>
					<input type="number" id="vitalsBloodO2Saturation" name="vitalsBloodO2Saturation">
				</fieldset>
				<fieldset>
					<legend>Review of Systems</legend>	
					
				</fieldset>
				<div><input id="patientFormSubmitButton" type="submit" value="Submit"/><input type="reset" name="Reset" /></div>
			</form>
		</div>
	</div>
</body>
</html>