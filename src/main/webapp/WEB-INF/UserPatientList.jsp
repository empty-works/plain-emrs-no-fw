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

		<div class="main-grid-container">
			<h4>PATIENT LIST</h4>

			<!-- Can only add patient if an admin -->
			<c:if test = "${sessionScope.rolePair.getRoleDb() == 'ROLE_ADMIN'}">
				<fieldset>
					<legend>Admin only</legend>
					<div><a href="<c:url value="/AddUserPatientServlet" />">Add Patient</a></div>
				</fieldset>
			</c:if>

			<form class="content-padding" action="UserPatientServlet" method="post" enctype="multipart/form-data">
			<table> <!-- Global table styling handled in general -->
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>M.I.</th>
					<th>Last Name</th>
					<th>Date of Birth</th>
					<th>Type</th>
					<th>Birth Gender</th>
					<th>Language Preference</th>
				</tr>
				<c:forEach items="${patientSublist}" var="patient" >
					<tr id="list-link">
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getUserId()}</a></td>
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getFirstName()}</a></td>
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getMiddleInitial()}</a></td>
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getLastName()}</a></td>
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getDateOfBirth()}</a></td>
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getType()}</a></td>
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getGenderAtBirth()}</a></td>	
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getLanguagePreference()}</a></td>	
					</tr>
				</c:forEach>
			</table>
			</form>
			<div id="patient-list-grid-con">
			</div>
		</div>
	</div>
</body>
</html>