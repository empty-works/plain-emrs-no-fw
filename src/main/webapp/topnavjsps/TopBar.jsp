<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/topnav.css" />
<!-- Load icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
</head>
<body>
<!-- Top bar -->
<div class="topnav main-font">
	<div class="topnav-grid">
		<span class="topnav-brand">Plain EMRS</span>
		
		<!-- Patient search bar -->
		<form class="search-container" action="">
			<input type="text" placeholder="Patient search.." name="search">
			<button type="submit"><i class="fa fa-search"></i></button>	
		</form>	
	<!-- 
		<button formaction="<c:url value="/AdminServlet" />" class="topnav-menu-btn topnav-menu-btn-first"> 
			<span class="menu-text">Admin</span>
		</button>
		<button formaction="<c:url value="/PatientServlet" />" class="topnav-menu-btn">
			<span class="menu-text">Patients</span>
		</button>
		<button class="topnav-menu-btn">
			<span class="menu-text">Non-patients</span>
		</button>
		<button class="topnav-menu-btn topnav-menu-btn-last">
			<span class="menu-text">Settings</span>
		</button>
	-->
		<a class="topnav-user"><%=session.getAttribute("userId") %></a>	
	</div>
</div>
</body>