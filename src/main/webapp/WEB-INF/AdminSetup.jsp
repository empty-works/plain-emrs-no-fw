<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-setup.css" />

<title>Admin Setup</title>
</head>

<body>
	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>

	<div class="main-container">
		<!-- Side navigation -->
		<div class="sidenav main-font">	
			<div><a href="<c:url value="/FacilitiesServlet" />">Facilities</a></div>
			<div><a href="<c:url value="/RolesServlet" />">Roles</a></div>
			<div><a href="<c:url value="/WEB-INF/AddNonPatient.jsp" />">Add Non-Patient</a></div>
		</div>

		<!-- Main content --> 
		<div class="main main-font">
			<h2>Setup</h2>
			<div class="main-grid">
			</div>
		</div>
	</div>
</body>
</html>