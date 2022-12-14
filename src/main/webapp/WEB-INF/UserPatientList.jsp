<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/topnav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-setup.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-grid.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/patients.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />

<title>Patient List</title>
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
			<h4>PATIENT LIST</h4>
			<table> <!-- Global table styling handled in general -->
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>M.I.</th>
					<th>Last Name</th>
					<th>Date of Birth</th>
					<th>Type</th>
					<th>Birth Gender</th>
				</tr>
				<c:forEach items="${patientSublist}" var="patient" >
					<tr>
						<td>${patient.getUserId()}</td>
						<td>${patient.getFirstName()}</td>
						<td>${patient.getMiddleInitial()}</td>
						<td>${patient.getLastName()}</td>
						<td>${patient.getDateOfBirth()}</td>
						<td>${patient.getType()}</td>
						<td>${patient.getGenderAtBirth()}</td>	
					</tr>
				</c:forEach>
			</table>
			<div id="patient-list-grid-con">
			</div>
		</div>
	</div>
</body>
</html>