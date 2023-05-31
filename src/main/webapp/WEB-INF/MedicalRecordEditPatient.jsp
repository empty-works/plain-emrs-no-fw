<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/topnav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-setup.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-grid.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/patients.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/medical-record.css" />
<script src="${pageContext.request.contextPath}/js/user.js"></script>
<title>Edit patient record</title>
</head>

<body>
	<div class="main-container">
		<div class="main-grid-container">
		<form id="editPatientForm" name="editPatientForm" class="content-padding" action="MedicalRecordEditPatientServlet" method="post">
			<div class="main-grid">
				<div>
					<div><a href="${pageContext.request.contextPath}/MedicalRecordLatestChiefComplaintServlet?userPatientId=${userPatientId}">Cancel</a></div>
					<fieldset>
						<legend class="patient-header">Personal Overview</legend>
						<div id="patient-overview-grid-1" class="patient-data">
							<div>
								<div>${userPatientId}</div>
								<div>${patientType}</div>
							</div>
							<div>
								<div>${userPatientFirstName} ${userPatientMiddleInitial} ${userPatientLastName}</div>
								<div>${patientLanguagePreference}</div>
							</div>
							<div>
								<div>${userDateOfBirth}</div>
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend class="patient-header">Medical Record Overview</legend>	
						<div id="patient-overview-grid-1" class="patient-data">
							<div>
								<label for="medRecordId">Medical Record ID:</label>
								<div id="medRecordId">${medicalRecordId}</div>	
								<label for="medRecordCond">Medical Record Condition:</label>
								<div id="medRecordCond">${medRecordPatientCondition}</div>
								<label for="medRecordCreated">Medical Record Created:</label>
							</div>	
							<div>
								<div id="medRecordCreated">${medRecordCreated}</div>
								<label for="medRecordActive">Medical Record Active:</label>
								<div id="medRecordActive">${medRecordIsActive}</div>
								<label for="medRecordBloodTransfusion">Blood Transfusion Status:</label>
								<div id="medRecordBloodTransfusion">${medRecordBloodTransfusionStatus}</div>
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend class="patient-header">Chief complaint</legend>	
						<div id="patient-overview-grid-1" class="patient-data">
							<div>
								<input type="text" id="chiefComplaintStatementInput" name="chiefComplaintStatementInput" 
								value="${medRecordChiefComplaintsLatest.getStatement()}">	
							</div>	
						</div>
					</fieldset>
					<fieldset>
						<legend class="patient-header">Vitals ${medRecordVitals.getDateTaken()}</legend>							
						<!-- Vitals edit modal -->
						<div id="vitalsEditModal" class="med-rec-modal">
							<div class="vitals-edit-modal-content">
								<span id="vitalsEditSpan" class="close-med-rec-modal">&times;</span>
								<p>Vitals modal...</p>
							</div>	
						</div>
						<div id="patient-overview-grid-1" class="patient-data">
							<div>
								<label for="vitalsHeightInput">Height: </label><br />
								<input type="number" pattern="[0-9]*" id="vitalsHeightInput" name="vitalsHeightInput" value="${medRecordVitals.getHeight()}"><br />
								<label for="vitalsTempInput">Temperature: </label><br />
								<input type="number" pattern="[0-9]*" id="vitalsTempInput" name="vitalsTempInput" value="${medRecordVitals.getTemperature()}"><br /> 
								<label for="vitalsSystolicInput">Blood pressure systolic: </label><br />
								<input type="number" pattern="[0-9]*" id="vitalsSystolicInput" name="vitalsSystolicInput" value="${medRecordVitals.getBloodPressureSystolic()}"><br />
								<label for="vitalsDiastolicInput">Blood pressure diastolic: </label><br />
								<input type="number" pattern="[0-9]*" id="vitalsDiastolicInput" name="vitalsDiastolicInput" value="${medRecordVitals.getBloodPressureDiastolic()}"><br />
							</div>
							<div>
								<label for="vitalsWeightInput">Weight: </label><br />
								<input type="number" pattern="[0-9]*" id="vitalsWeightInput" name="vitalsWeightInput" value="${medRecordVitals.getWeight()}"><br />
								<label for="vitalsPulseInput">Pulse: </label><br />
								<input type="number" pattern="[0-9]*" id="vitalsPulseInput" name="vitalsPulseInput" value="${medRecordVitals.getPulse()}"><br />
								<label for="vitalsOxySatInput">Arterial blood oxygen saturation: </label><br />
								<input type="number" pattern="[0-9]*" id="vitalsOxySatInput" name="vitalsOxySatInput" value="${medRecordVitals.getArterialBloodOxygenSaturation()}"><br />
							</div>
							<div>
								<label for="vitalsCalcBmiInput">Calculated BMI: </label><br />
								<input type="number" id="vitalsCalcBmiInput" name="vitalsCalcBmiInput" value="${medRecordVitals.getCalculatedBmi()}"><br />
								<label for="vitalsRespRateInput">Respiratory rate: </label><br />
								<input type="number" id="vitalsRespRateInput" name="vitalsRespRateInput" value="${medRecordVitals.getRespiratoryRate()}"><br />
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend class="patient-header">Allergies</legend>							
						<div id="patient-overview-grid-1" class="patient-data">
							<p>
							<c:choose>
							<c:when test="empty ${medRecordAllergiesList}">
								No allergies
							</c:when>
							<c:otherwise>
								<c:forEach items="${medRecordAllergiesList}" var="allergy">
									<input type="text" id="allergy${allergy.getAllergyName()}" name="allergyText" value="${allergy.getAllergyName()}"><button>X</button><br /> 
								</c:forEach>	
							</c:otherwise>
							</c:choose>
							</p>
						</div>
						<div id="allergiesProbContainer"></div>
						<button type="button" id="allergiesAddButton" onclick='allergiesMed.addNode(allergiesProbContainer, true)'>Add</button><div id="addLimitReached"></div>
						<div id="genMedLimitMsg"></div>
					</fieldset>
					<fieldset>
						<legend class="patient-header">Medication</legend>							
						<div id="patient-overview-grid-1" class="patient-data">
							<p>
							<c:choose>
								<c:when test="${empty medRecordMedicationList}">
									No medication
								</c:when>
								<c:otherwise>
									<c:forEach items="${medRecordMedicationList}" var="medication">
										${medication.getMedicationName()}, 
									</c:forEach>
								</c:otherwise>
							</c:choose>
							</p>
						</div>
					</fieldset>
					<button class="med-record-accordion">Illnesses</button>
					<div class="med-record-panel">
						<p>
						<c:choose>
						<c:when test="${empty medRecordIllnessesList}">
							No illnesses
						</c:when>
						<c:otherwise>
							<c:forEach items="${medRecordIllnessesList}" var="illness">
								${illness.getIllness()}, 		
							</c:forEach>
						</c:otherwise>
						</c:choose>
						</p>
					</div>
					<button class="med-record-accordion">Diseases</button>
					<div class="med-record-panel">
						<p>
						<c:choose>
						<c:when test="${empty medRecordDiseasesList}">
							No diseases	
						</c:when>	
						<c:otherwise>
							<c:forEach items="${medRecordDiseasesList}" var="disease">
								${disease.getDisease()}, 
							</c:forEach>	
						</c:otherwise>
						</c:choose>
						</p>
					</div>
					<button class="med-record-accordion">Surgery-related problems</button>
					<div class="med-record-panel">
						<p>
						<c:choose>
						<c:when test="${empty medRecordSurgicalProblemsList}">
							No surgical history	
						</c:when>	
						<c:otherwise>
							<c:forEach items="${medRecordSurgicalProblemsList}" var="surgery">
								<div>
									Problem: ${surgery.getSurgicalRelatedProblem()}<br /> 
									Problem area: ${surgery.getProblemArea()}<br />
									Procedure: ${surgery.getSurgicalProcedure()}<br />
									Procedure year: ${surgery.getSurgicalProcedure()}<br />
								</div>
							</c:forEach>	
						</c:otherwise>
						</c:choose>	
						</p>
					</div>
					<button class="med-record-accordion">Review of systems</button>
					<div class="med-record-panel">
						<p>
						<c:choose>
						<c:when test="${empty medRecordRosLatest}">
							No review of systems
						</c:when>
						<c:otherwise>
							<div>
								Date recorded: ${medRecordRosLatest.getDate()}<br />
								Constitutional symptoms: ${medRecordRosLatest.getConstitutionalSymptoms()}<br />
								Eyes: ${medRecordRosLatest.getEyes()}<br />
								Ears, nose, throat: ${medRecordRosLatest.getEarsNoseThroat()}<br />
								Cardiovascular: ${medRecordRosLatest.getCardiovascular()}<br />
								Respiratory: ${medRecordRosLatest.getRespiratory()}<br />
								Gastrointestinal: ${medRecordRosLatest.getGastrointestinal()}<br />
								Genitournary: ${medRecordRosLatest.getGenitournary()}<br />
								Musculoskeletal: ${medRecordRosLatest.getMusculoskeletal()}<br />
								Integumentary: ${medRecordRosLatest.getIntegumentary()}<br />
								Neurological: ${medRecordRosLatest.getNeurological()}<br />
								Psychiatric: ${medRecordRosLatest.getPsychiatric()}<br />
								Endocrine: ${medRecordRosLatest.getEndocrine()}<br />
								Hematologic lymphatic: ${medRecordRosLatest.getHematologicLymphatic()}<br />
								Allergic immunologic: ${medRecordRosLatest.getAllergicImmunologic()}<br />
							</div>
						</c:otherwise>
						</c:choose>
						</p>
					</div>
					<button class="med-record-accordion">Nurse notes</button>
					<div class="med-record-panel">
						<p>
						<c:choose>
						<c:when test="${empty medRecordNurseNotesList}">
							No nurse notes
						</c:when>	
						<c:otherwise>
							<c:forEach items="${medRecordNurseNotesList}" var="nurseNote">
								<div>- ${nurseNote.getText()}</div>	
							</c:forEach>	
						</c:otherwise>
						</c:choose>
						</p>
					</div>
				</div>
			</div>
			<div><a href="${pageContext.request.contextPath}/MedicalRecordLatestChiefComplaintServlet?userPatientId=${userPatientId}">Cancel</a></div>
		</form>
		</div>
	</div>

	<!-- Script taken from w3schools HowTO - Collapsibles/Accordion -->
	<script>
		var acc = document.getElementsByClassName("med-record-accordion");
		var i;

		for (i = 0; i < acc.length; i++) {
		  acc[i].addEventListener("click", function() {
			this.classList.toggle("active");
			var panel = this.nextElementSibling;
			if (panel.style.maxHeight) {
			  panel.style.maxHeight = null;
			} else {
			  panel.style.maxHeight = panel.scrollHeight + "px";
			} 
		  });
		}
	</script>
</body>
</html>