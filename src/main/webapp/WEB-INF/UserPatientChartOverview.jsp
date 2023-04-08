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
			<div class="sidenav-active">Chart Overview</div>
			<div><a href="${pageContext.request.contextPath}/UserPatientPersonalServlet?userPatientId=${userPatientId}">Personal Details</a></div>
			<div><a href="<c:url value="/" />">Timeline</a></div>
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
								<div>Patient Picture</div>
							</div>
							<div>
								<div>${userPatientId}</div>
								<div>${userPatientFirstName} ${userPatientMiddleInitial} ${userPatientLastName}</div>
								<div>${patientPhoneNumber}</div>
								<div>${userEmailAddress}</div>
								<div>${patientStreetAddress}</div>
							</div>
							<div>
								<div>${userDateOfBirth}</div>
								<div>Height: ${medRecordVitals.getHeight()}</div>
								<div>Weight: ${medRecordVitals.getWeight()}</div>
								<div>${patientType}</div>
								<div>${patientLanguagePreference}</div>
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend class="patient-header">Critical Overview</legend>							
						<div id="patient-overview-grid-1" class="patient-data">
							<div>
								<h4>Allergies: </h4>
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
							<div>
								<h4>Medication: </h4>	
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
							<div>
								<h4>Vitals ${medRecordVitals.getDateTaken()}: </h4>	
								<div>Calculated BMI: ${medRecordVitals.getCalculatedBmi()}</div>
								<div>Temperature: ${medRecordVitals.getTemperature()}</div>
								<div>Pulse: ${medRecordVitals.getPulse()}</div>
								<div>Respiratory rate: ${medRecordVitals.getRespiratoryRate()}</div>
								<div>Blood pressure systolic / diastolic: ${medRecordVitals.getBloodPressureSystolic()} / ${medRecordVitals.getBloodPressureDiastolic()}</div>
								<div>Arterial blood oxygen saturation: ${medRecordVitals.getArterialBloodOxygenSaturation()}</div>
							</div>
						</div>
					</fieldset>
					<button class="med-record-accordion">Chief complaints</button>
					<div class="med-record-panel">
						<p>TESTING</p>
					</div>

					<button class="med-record-accordion">Nurse notes</button>
					<div class="med-record-panel">
						<p>TESTING</p>
					</div>

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

					<div class="dynamic-grid">
						<div id="chartAdmission">Admissions GOES INTO TIMELINE</div>
						<div id="chartBloodRelatives">Blood relatives GOES INTO PERSONAL DETAILS</div>
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