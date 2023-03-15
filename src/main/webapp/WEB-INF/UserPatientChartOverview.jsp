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

<title>Patient Profile</title>
</head>
<body onload="setPatientId(${userPatientId})">
	
	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>
	
	<div class="main-container">
		<!-- Side main menu -->
		<div class="side-main-menu">
			<script id="replace_with_sidemainmenu" src="${pageContext.request.contextPath}/js/adminsidemainmenu.js"></script>	
		</div>
		<!-- Side navigation -->
		<div class="sidenav main-font">
			<div class="sidenav-active">Chart Overview</div>
			<div><a href="${pageContext.request.contextPath}/UserPatientPersonalServlet?userPatientId=${userPatientId}">Personal Details</a></div>
			<div><a href="<c:url value="/" />">Timeline</a></div>
		</div>
		
		<div class="main-grid-container">
			<div class="main-grid">
				<div><a href="<c:url value="/EditUserPatientServlet" />">Edit Patient</a></div>
				<div>
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
					<div class="dynamic-grid">
						<div id="chartAllergies">Allergies</div>
						<div id="chartChiefComplaints">Vitals</div>
					</div>
					<div class="dynamic-grid">
						<div id="chartROS">Medication</div>
						<div id="chartROS">Chief complaints</div>
					</div>
					<div class="dynamic-grid">
						<div id="chartROS">Illnesses</div>
						<div id="chartROS">Diseases</div>
					</div>
					<div class="dynamic-grid">
						<div id="chartROS">Surgery-related problems</div>
						<div id="chartROS">Nurse notes</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>