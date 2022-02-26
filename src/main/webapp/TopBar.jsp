<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/topnav.css" />
</head>
<body>
<!-- Top bar -->
<form>
<div class="topnav main-font">
	<div class="topnav-grid">
	<span class="topnav-brand">Plain EMRS</span>
	<button formaction="<c:url value="/AdminServlet" />" class="topnav-menu-btn topnav-menu-btn-first">
		<span class="menu-text">UPDATES</span>
	</button>
	<button formaction="<c:url value="/AdminSetupServlet" />" class="topnav-menu-btn">
		<span class="menu-text">SETUP</span>
	</button>
	<button class="topnav-menu-btn">
		<span class="menu-text">USERS</span>
	</button>
	<button class="topnav-menu-btn">
		<span class="menu-text">PATIENTS</span>
	</button>
	<button class="topnav-menu-btn topnav-menu-btn-last">
		<span class="menu-text">SETTINGS</span>
	</button>
	<a class="topnav-user"><%=session.getAttribute("username") %></a>	
	</div>
</div>
</form>
</body>