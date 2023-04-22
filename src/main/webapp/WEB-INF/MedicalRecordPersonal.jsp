<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-setup.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-grid.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/patients.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />

<title>Patient Medical Record</title>
</head>
<body>
	
	<div class="main-container">
		<!-- Side navigation -->
		<div class="sidenav main-font">
			<div><a href="${pageContext.request.contextPath}/MedicalRecordLatestChiefComplaintServlet?userPatientId=${userPatientId}">Latest Chief Complaint</a></div>
			<div class="sidenav-active">Personal Details</div>
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
				<fieldset>
					<legend class="patient-header">Patient Overview</legend>
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
							<div>Height</div>
							<div>Weight</div>
							<div>${patientType}</div>
							<div>${patientLanguagePreference}</div>
						</div>
					</div>
				</fieldset>

				<fieldset>
					<legend class="patient-header">Emergency contact</legend>	
					<div class="patient-data">
						<div>${emergencyContactFirstName} ${emergencyContactLastName}</div>
						<div>${emergencyContactPhoneNumber}</div>
						<div>${emergencyContactEmail}</div>
					</div>
				</fieldset>
				<fieldset>
					<legend class="patient-header">Personal details</legend>		
					<div class="patient-data">
						<label for="patientProvider">Patient provider:</label>
						<div id="patientProvider">${patientProvider} | ${patientProviderId}</div>
						<label for="genderAtBirth">Gender at birth:</label>
						<div id="genderAtBirth">${patientBirthGender}</div>
						<label for="patientCurrentGender">Current gender:</label>
						<div id="patientCurrentGender">${patientCurrentGender}</div>	
						<label for="patientRace">Race(s) and ethnicities:</label>
						<c:forEach items="${patientRaceList}" var="patientRace">
							<div>${patientRace}</div>			
						</c:forEach>
						<label for="patientSexOrientation">Sexual orientation:</label>
						<div id="patientSexOrientation">${patientSexualOrientation}</div>
						<label for="patientMaritalStatus">Marital status:</label>
						<div id="patientMaritalStatus">${patientMaritalStatus}</div>
						<label for="patientLiving">Living arrangement:</label>
						<div id="patientLiving">${patientLivingArrangement}</div>
						<label for="patientAdopted">Adopted:</label>
						<div id="patientAdopted">${patientAdopted}</div>
					</div>
				</fieldset>
				<fieldset>
					<legend class="patient-header">Blood relatives</legend>	
					<div class="dynamic-grid">
						<div id="patientBloodRelatives" class="content-container">Father status: ${medRecordBloodRelatives.getFatherStatus()}</div>
						<div>
							<c:choose>
							<c:when test="${medRecordBloodRelatives.getFatherStatus() != 'alive'}">
								<div id="patientBloodRelatives" class="content-container">Father deceased age: ${medRecordBloodRelatives.getFathDecAge()}</div>
							</c:when>	
							</c:choose>	
						</div>
						<div id="patientBloodRelatives" class="content-container">Mother status: ${medRecordBloodRelatives.getMotherStatus()}</div>
						<div>
							<c:choose>
							<c:when test="${medRecordBloodRelatives.getMotherStatus() != 'alive'}">
								<div id="patientBloodRelatives" class="content-container">Mother deceased age: ${medRecordBloodRelatives.getMothDecAge()}</div>
							</c:when>	
							</c:choose>	
						</div>
						<div id="patientBloodRelatives" class="content-container">Number of brothers: ${medRecordBloodRelatives.getNumBrothers()}</div>
						<div id="patientBloodRelatives" class="content-container">Number of sisters: ${medRecordBloodRelatives.getNumSisters()}</div>
						<div id="patientBloodRelatives" class="content-container">Number of sons: ${medRecordBloodRelatives.getNumSons()}</div>
						<div id="patientBloodRelatives" class="content-container">Number of daughters: ${medRecordBloodRelatives.getNumDaughters()}</div>
					</div>
				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>