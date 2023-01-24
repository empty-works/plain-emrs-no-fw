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
			<script id="replace_with_sidenav" src="${pageContext.request.contextPath}/js/patientssidenav.js"></script>
		</div>
		
		<div class="main-grid-container">
			<div class="main-grid">
			<div><a href="<c:url value="/EditUserPatientServlet" />">Edit Patient</a></div>
			<div>
				<fieldset>
					<legend>Patient Overview</legend>
					<div id="patient-overview-grid-1">
						<div>
							<div>Patient Picture</div>
						</div>
						<div>
							<div>PATIENT ID: ${userPatientId}</div>
							<div>${userPatientFirstName} ${userPatientMiddleInitial} ${userPatientLastName}</div>
							<div>${patientPhoneNumber}</div>
							<div>${userEmailAddress}</div>
							<div>${patientStreetAddress}</div>
						</div>
						<div>
							<div>userDateOfBirth</div>
							<div>Height</div>
							<div>Weight</div>
							<div>${patientType}</div>
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend>Emergency Contact</legend>	
					<label for="ecFirstName">First Name</label>
					<div id="ecFirstName">${emergencyContactFirstName}</div>
					<label for="ecLastName">Last Name</label>
					<div id="ecLastName">${emergencyContactLastName}</div>
					<label for="ecPhone">Phone Number</label>
					<div id="ecPhone">${emergencyContactPhoneNumber}</div>
					<label for="ecEmail">Email</label>
					<div id="ecEmail">${emergencyContactEmail}</div>
				</fieldset>
				<fieldset>
					<legend>General Medical History</legend>
					<div>WWWWWWWWWWWWWWWWWWWWWWWWWWW</div>
				</fieldset>
				<fieldset>
					<legend>Basic Medical Insurance Information</legend>
					<div>ZZZZZZZZZZZZZZZZZZZZZZZZZZZ</div>
				</fieldset>
			</div>
			</div>
		</div>
	</div>
</body>
</html>