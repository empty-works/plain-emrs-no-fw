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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-grid.css" />

</head>
<body>

	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>

	<div class="main-container">
		<!-- Side navigation -->
		<div class="sidenav main-font">
			<script id="replace_with_sidenav" src="${pageContext.request.contextPath}/js/patientssidenav.js"></script>
		</div>

		<!-- Main content --> 
		<div class="main-grid-container main-font">
			<div id="admin-main-grid">
				<div class="content-container" id="admin-grid-item-updates">
					<div class="content-label">Updates</div>	
					<div class="content-box"></div>
				</div>
				<div class="content-container" id="admin-grid-item-update-patient">
					<div class="content-label">Last Updated Patient</div>	
					<div class="content-box"></div>
				</div>
				<div class="content-container" id="admin-grid-item-add-patient">
					<div class="content-label">Last Added Patient</div>	
					<div class="content-box"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>