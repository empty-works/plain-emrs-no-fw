<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/secondtopnav.css" />
<script src="${pageContext.request.contextPath}/js/secondtopbarbuttons.js"></script>

</head>
<body>

<div class="sectopnav main-font">
	<form class="sectopnav-ul">
	<button class="sectopnav-button sectopnav-active" id="adminUpdatesBtn" onclick="testYellow(this.id)">Updates</button>		
	<button class="sectopnav-button" id="adminSetupBtn" onclick="testYellow(this.id)">Setup</button>		
	<button class="sectopnav-button" id="adminUsersBtn" onclick="">Users</button>		
	<button class="sectopnav-button" id="adminPatientsBtn" onclick="">Patients</button>		
	<button class="sectopnav-button" id="adminSettingsBtn" onclick="">Settings</button>		
	</form>
</div>

</body>
</html>