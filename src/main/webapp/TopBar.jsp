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
<div class="topnav main-font">
	<div class="topnav-grid">
	<span class="topnav-brand">Plain EMRS</span>
	<button class="topnav-menu-btn">
		<span class="menu-text">Updates</span>
	</button>
	<button class="topnav-menu-btn">
		<span class="menu-text">Setup</span>
	</button>
	<button class="topnav-menu-btn">
		<span class="menu-text">Users</span>
	</button>
	<button class="topnav-menu-btn">
		<span class="menu-text">Patients</span>
	</button>
	<button class="topnav-menu-btn">
		<span class="menu-text">Settings</span>
	</button>
	<form class="topnav-user">
		<a><%=session.getAttribute("username") %></a>	
	</form>
	</div>
</div>
</body>