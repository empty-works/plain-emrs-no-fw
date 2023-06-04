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
<script src="${pageContext.request.contextPath}/js/medicalrecord.js"></script>

<title>Patient Profile</title>
</head>
<body>
	
	<div class="main-container">
		<!-- Side navigation -->
		<div class="sidenav main-font">
			<div class="sidenav-active">Latest Chief Complaint </div>
			<div><a href="${pageContext.request.contextPath}/MedicalRecordPersonalServlet?userPatientId=${userPatientId}">Personal Details</a></div>
			<div><a>Timeline</a></div>
			<br />
			<br />
			<!-- Prompt user if they really want to return to the patient list -->
			<div><a href="<c:url value="/UserPatientListServlet" />"><-- Return to patient list</a></div>

			<br />
			<br />
			<br />
			<!-- Can only add patient if an admin -->
			<div>
			<c:if test = "${sessionScope.rolePair.getRoleDb() == 'ROLE_ADMIN'}">
				<div>[Only authorized personnel]</div>
				<div><a href="${pageContext.request.contextPath}/MedicalRecordAddChiefComplaintServlet?userPatientId=${userPatientId}">Add Chief Complaint</a></div>
				<div><a href="${pageContext.request.contextPath}/MedicalRecordEditChiefComplaintServlet?userPatientId=${userPatientId}">Edit chief complaints</a></div>
			</c:if>
			</div>
		</div>
		
		<div class="main-grid-container">
			<div class="main-grid">
				<div>
					<a href="<c:url value="/MedicalRecordEditPatientServlet" />">Edit Patient</a>
					<a class="topnav-user"><%=session.getAttribute("userId") %></a>	
				</div>
				<div>
					<fieldset>
						<legend class="patient-header">Personal Overview</legend>
						<div id="medRecPersonalOverview" class="patient-data">
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
						<div id="medRecOverview" class="patient-data">
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
						<div id="medRecChiefComplaint" class="patient-data">
							<button onclick="openMedRecordModal('medRecChiefComplaint')">Edit</button>
							<div>
								<div>${medRecordChiefComplaintsLatest.getStatement()}</div>	
							</div>	
						</div>
					</fieldset>
					<fieldset>
						<legend class="patient-header">Vitals ${medRecordVitals.getDateTaken()}</legend>							
						<!-- Vitals edit link -->
						<button id="vitalsEditButton" class="edit-link">Edit</button>
						<!-- Vitals edit modal -->
						<div id="vitalsEditModal" class="med-rec-modal">
							<div class="vitals-edit-modal-content">
								<span id="vitalsEditSpan" class="close-med-rec-modal">&times;</span>
								<p>Vitals modal...</p>
							</div>	
						</div>
						<div id="medRecVitals" class="patient-data">
							<div>
								<div>Height: ${medRecordVitals.getHeight()}</div>
								<div>Temperature: ${medRecordVitals.getTemperature()}</div>
								<div>Blood pressure systolic / diastolic: ${medRecordVitals.getBloodPressureSystolic()} / ${medRecordVitals.getBloodPressureDiastolic()}</div>
							</div>
							<div>
								<div>Weight: ${medRecordVitals.getWeight()}</div>
								<div>Pulse: ${medRecordVitals.getPulse()}</div>
								<div>Arterial blood oxygen saturation: ${medRecordVitals.getArterialBloodOxygenSaturation()}</div>
							</div>
							<div>
								<div>Calculated BMI: ${medRecordVitals.getCalculatedBmi()}</div>
								<div>Respiratory rate: ${medRecordVitals.getRespiratoryRate()}</div>
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend class="patient-header">Allergies</legend>							
						<div id="medRecAllergies" class="patient-data">
							<p>
							<c:choose>
							<c:when test="empty ${medRecordAllergiesList}">
								No allergies
							</c:when>
							<c:otherwise>
								<c:forEach items="${medRecordAllergiesList}" var="allergy">
									${allergy.getAllergyName()}, 
								</c:forEach>	
							</c:otherwise>
							</c:choose>
							</p>
						</div>
					</fieldset>
					<fieldset>
						<legend class="patient-header">Medication</legend>							
						<div id="medRecMedication" class="patient-data">
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
					<div id="medRecIllnesses" class="med-record-panel">
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
					<div id="medRecDiseases" class="med-record-panel">
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
					<div id="medRecSurgProbs" class="med-record-panel">
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
					<div id="medRecRos" class="med-record-panel">
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
					<div id="medRecNurseNotes" class="med-record-panel">
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
					
					<!-- Modal -->
					<div id="medRecModal" class="modal">
					  <div class="modal-content">
						<span class="close" onclick="closeModal()">&times;</span>
						<div id="medRecModalData"></div>
					  </div>
					</div>
					
				</div>
			</div>
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