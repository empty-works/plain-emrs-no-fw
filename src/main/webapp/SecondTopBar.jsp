<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/secondtopnav.css" />
</head>
<body>

<div class="sectopnav main-font">
	<div class="sectopnav-ul">
		<button class="sectopnav-button sectopnav-active" name="adminUpdatesBtn" type="button" onclick="">Updates</button>		
		<button class="sectopnav-button" name="adminSetupBtn" type="button" onclick="">Setup</button>		
		<button class="sectopnav-button" name="adminUsersBtn" type="button" onclick="">Users</button>		
		<button class="sectopnav-button" name="adminPatientsBtn" type="button" onclick="">Patients</button>		
		<button class="sectopnav-button" name="adminSettingsBtn" type="button" onclick="">Settings</button>		
	</div>
</div>

</body>
</html>