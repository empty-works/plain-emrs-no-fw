<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>

<% 	// If Admin session is not set, redirect to the default page
	if((request.getSession(false).getAttribute("Admin") == null)) {
%>
	<jsp:forward page="/default.jsp"></jsp:forward>
<%} %>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/secondtopnav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-updates.css" />

</head>
<body>

<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>

<!-- Top navigation -->
<!-- <script id="replace_with_secondtopbar" src="${pageContext.request.contextPath}/js/secondtopbar.js"></script> -->

<div class="sectopnav main-font">
	<form class="sectopnav-ul">
	<button formaction="<c:url value="/AdminServlet" />" class="sectopnav-button sectopnav-active" name="adminUpdatesBtn">Updates</button>		
	<button formaction="<c:url value="/AdminSetupServlet" />" class="sectopnav-button" name="adminSetupBtn">Setup</button>		
	<button class="sectopnav-button" name="adminUsersBtn" onclick="">Users</button>		
	<button class="sectopnav-button" name="adminPatientsBtn" onclick="">Patients</button>		
	<button class="sectopnav-button" name="adminSettingsBtn" onclick="">Settings</button>		
	</form>
</div>

<!-- Main content --> 
<div class="main main-font">
	<div class="main-grid">
		<div class="grid-item-users-logged-in">Logged-in Users</div>
		<div class="grid-item-updates">Updates</div>
		<div class="grid-item-update-patient">Last Updated Patient</div>
		<div class="grid-item-add-patient">Last Added Patient</div>
	</div>
</div>

</body>
</html>