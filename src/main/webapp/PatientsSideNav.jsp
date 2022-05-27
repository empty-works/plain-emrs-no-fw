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
	<div><a href="<c:url value="/AddPatientServlet" />">Add Patient</a></div>
</body>
</html>