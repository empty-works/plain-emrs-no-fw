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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-grid.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/patients.css" />
<title>Patients</title>
</head>

<body>
	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>
	
	<div class="main-container">
		<!-- Side navigation -->
		<script type="text/javascript"></script>
		<!-- 
		<div class="sidenav main-font">	
			<div><a href="<c:url value="" />">Search</a></div>
			<div><a href="<c:url value="/TrackedPatientsServlet" />">Tracked Patients</a></div>
			<div><a href="<c:url value="/AddPatientServlet" />">Add Patient</a></div>
		</div>
 		-->
		
		<!-- Main content --> 
		<div class="main-grid-container-side-nav main-font">
			<div id="patients-main-grid">
				<div class="content-container" id="patients-grid-recent">
					<div class="content-label">RECENT</div>
					<div class="content-box"></div>
				</div>	
				<div class="content-container" id="patients-grid-search">
					<div class="content-label">SEARCH</div>
					<div class="content-box"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>