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
	
	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>
	 	
	<div class="main-container">
		<!-- Side main menu -->
		<div class="side-main-menu">
			<script id="replace_with_sidemainmenu" src="${pageContext.request.contextPath}/js/adminsidemainmenu.js"></script>	
		</div>
		<!-- Side navigation -->
		<div class="sidenav main-font">
			<div><a href="${pageContext.request.contextPath}/UserPatientChartOverviewServlet?userPatientId=${userPatientId}">Chart Overview</a></div>
			<div class="sidenav-active">Personal Details</div>
			<div><a href="<c:url value="/" />">Timeline</a></div>
		</div>
		
		<div class="main-grid-container">
			<div class="main-grid">
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
					<legend></legend>	
				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>