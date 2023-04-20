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

<title>Patient Profile</title>
</head>
<body onload="setPatientId(${userPatientId})">
	
	<div class="main-container">
		<!-- Side navigation -->
		<div class="sidenav main-font">
			<div class="sidenav-active">Latest Chief Complaint</div>
			<div><a href="${pageContext.request.contextPath}/UserPatientPersonalServlet?userPatientId=${userPatientId}">Personal Details</a></div>
			<div><a>Timeline</a></div>
			<div><a href="${pageContext.request.contextPath}/MedicalRecordAddChiefComplaintServlet?userPatientId=${userPatientId}">Add Chief Complaint</a></div>
			<br />
			<br />
			<br />
			<!-- Prompt user if they really want to return to the patient list -->
			<div><a href="<c:url value="/UserPatientListServlet" />"><-- Return to patient list</a></div>
		</div>
		
		<div class="main-grid-container">
			<div class="main-grid">
				<div>
					<a href="<c:url value="/EditUserPatientServlet" />">Edit Patient</a>
					<a class="topnav-user"><%=session.getAttribute("userId") %></a>	
				</div>
				<div>
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
						<legend class="patient-header">Overview</legend>	
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
								<div>TESTING</div>	
							</div>	
						</div>
					</fieldset>
					<fieldset>
						<legend class="patient-header">Vitals ${medRecordVitals.getDateTaken()}</legend>							
						<div id="patient-overview-grid-1" class="patient-data">
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
						<div id="patient-overview-grid-1" class="patient-data">
							<div>
								<c:choose>
								<c:when test="">
									<div>No allergies</div>	
								</c:when>
								<c:otherwise>
									<c:forEach items="${medRecordAllergiesList}" var="allergy">
										${allergy.getAllergyName()}, 
									</c:forEach>	
								</c:otherwise>
								</c:choose>
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend class="patient-header">Medication</legend>							
						<div id="patient-overview-grid-1" class="patient-data">
							<div>
								<c:choose>
									<c:when test="${empty medRecordMedicationList}">
										<div>No medication</div>
									</c:when>
									<c:otherwise>
										<c:forEach items="${medRecordMedicationList}" var="medication">
											${medication.getMedicationName()}, 
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</fieldset>
					<button class="med-record-accordion">Illnesses</button>
					<div class="med-record-panel">
						<p>TESTING</p>
					</div>
					<button class="med-record-accordion">Diseases</button>
					<div class="med-record-panel">
						<p>TESTING</p>
					</div>
					<button class="med-record-accordion">Surgery-related problems</button>
					<div class="med-record-panel">
						<p>TESTING</p>
					</div>
					<button class="med-record-accordion">Nurse notes</button>
					<div class="med-record-panel">
						<p>TESTING</p>
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