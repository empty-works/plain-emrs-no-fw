<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
	<form class="sectopnav-ul">
	<button formaction="<c:url value="/AdminServlet" />" class="sectopnav-button sectopnav-active" name="adminUpdatesBtn" onclick="">Updates</button>		
	<button formaction="<c:url value="/AdminSetupServlet" />" class="sectopnav-button" name="adminSetupBtn" onclick="">Setup</button>		
	<button class="sectopnav-button" name="adminUsersBtn" onclick="">Users</button>		
	<button class="sectopnav-button" name="adminPatientsBtn" onclick="">Patients</button>		
	<button class="sectopnav-button" name="adminSettingsBtn" onclick="">Settings</button>		
	</form>
</div>

</body>
</html>