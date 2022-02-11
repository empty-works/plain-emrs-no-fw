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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/secondtopnav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-updates.css" />

<title>Insert title here</title>
</head>
<body>
	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>

	<!-- Top navigation -->
	<!--  <script id="replace_with_secondtopbar" src="${pageContext.request.contextPath}/js/secondtopbar.js"></script> -->
	
	<div class="sectopnav main-font">
		<form class="sectopnav-ul">
		<button formaction="<c:url value="/AdminServlet" />" class="sectopnav-button" name="adminUpdatesBtn">Updates</button>		
		<button formaction="<c:url value="/AdminSetupServlet" />" class="sectopnav-button sectopnav-active" name="adminSetupBtn">Setup</button>		
		<button class="sectopnav-button" name="adminUsersBtn" onclick="">Users</button>		
		<button class="sectopnav-button" name="adminPatientsBtn" onclick="">Patients</button>		
		<button class="sectopnav-button" name="adminSettingsBtn" onclick="">Settings</button>		
		</form>
	</div>

	<!-- Side navigation -->
	<div class="sidenav main-font">	
		
		<div class="sidenav-active">Overview</div>
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
</body>
</html>