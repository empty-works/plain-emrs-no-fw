<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
			<div><a href="${pageContext.request.contextPath}/MedicalRecordLatestChiefComplaintServlet?userPatientId=${userPatientId}">Latest Chief Complaint</a></div>
			<div><a href="${pageContext.request.contextPath}/MedicalRecordPersonalServlet?userPatientId=${userPatientId}">Personal Details</a></div>
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
			<form id="addChiefComplaintForm" name="addChiefComplaintForm" class="content-padding" action="MedicalRecordAddChiefComplaintServlet" method="post">
				<fieldset>
					<legend>New Chief Complaint</legend>
					<textarea id="chiefComplaintInput" name="chiefComplaintInput"></textarea>
				</fieldset>					
				<fieldset>
					<legend>Vitals</legend>	
					<div class="dynamic-grid">
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
					</div>
				</fieldset>
				<fieldset>
					<legend>Review of Systems</legend>	
					<div class="dynamic-grid">
					<label for="rosConstitutionalSymptoms">Constitutional symptoms: </label>
					<div><textarea id="rosConstitutionalSymptoms" name="rosConstitutionalSymptoms"></textarea></div>
					<label for="rosEyes">Eyes: </label>
					<div><textarea id="rosEyes" name="rosEyes"></textarea></div>
					<label for="rosEarsNoseThroat">Ears nose throat: </label>
					<div><textarea id="rosEarsNoseThroat" name="rosEarsNoseThroat"></textarea></div>
					<label for="rosCardiovascular">Cardiovascular: </label>
					<div><textarea id="rosCardiovascular" name="rosCardiovascular"></textarea></div>
					<label for="rosRespiratory">Respiratory: </label>
					<div><textarea id="rosRespiratory" name="rosRespiratory"></textarea></div>
					<label for="rosGastrointestinal">Gastrointestinal: </label>
					<div><textarea id="rosGastrointestinal" name="rosGastrointestinal"></textarea></div>
					<label for="rosGenitournary">Genitournary: </label>
					<div><textarea id="rosGenitournary" name="rosGenitournary"></textarea></div>
					<label for="rosMusculoskeletal">Musculoskeletal: </label>
					<div><textarea id="rosMusculoskeletal" name="rosMusculoskeletal"></textarea></div>
					<label for="rosIntegumentary">Integumentary: </label>
					<div><textarea id="rosIntegumentary" name="rosIntegumentary"></textarea></div>
					<label for="rosNeurological">Neurological: </label>
					<div><textarea id="rosNeurological" name="rosNeurological"></textarea></div>
					<label for="rosPsychiatric">Psychiatric: </label>
					<div><textarea id="rosPsychiatric" name="rosPsychiatric"></textarea></div>
					<label for="rosEndocrine">Endocrine: </label>
					<div><textarea id="rosEndocrine" name="rosEndocrine"></textarea></div>
					<label for="rosHematologicLymphatic">Hematologic lymphatic: </label>
					<div><textarea id="rosHematologicLymphatic" name="rosHematologicLymphatic"></textarea></div>
					<label for="rosAllergicImmunologic">Allergic immunologic: </label>
					<div><textarea id="rosAllergicImmunologic" name="rosAllergicImmunologic"></textarea></div>
					</div>
				</fieldset>
				<div><input id="patientFormSubmitButton" type="submit" value="Submit"/><input type="reset" name="Reset" /></div>
			</form>
		</div>
	</div>
</body>
</html>