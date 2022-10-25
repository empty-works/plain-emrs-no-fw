<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
</head>
<body>
	<!-- Side navigation -->
	<div><a href="<c:url value="/PatientSearchServlet" />">Search</a></div>
	<div><a href="<c:url value="/TrackedPatientsServlet" />">Tracked Patients</a></div>

	<!-- Can only add patient if an admin -->
	<c:if test = "${sessionScope.rolePair.getRoleDb() == 'ROLE_ADMIN'}">
		<fieldset>
			<legend>Admin only</legend>
			<div><a href="<c:url value="/AddUserPatientServlet" />">Add Patient</a></div>
		</fieldset>
	</c:if>
</body>
</html>