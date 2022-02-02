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

<!-- Required meta tags for Bootstrap -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-general.css" />

</head>
<body>

<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>

<!-- Top navigation -->
<script id="replace_with_secondtopbar" src="${pageContext.request.contextPath}/js/secondtopbar.js"></script>

<div class="sidemain-container">
<!-- Side navigation -->
<div class="sidenav main-font">	
	<div><a href="<c:url value="/FacilitiesServlet" />">Facilities</a></div>
	<div><a href="<c:url value="/RolesServlet" />">Roles</a></div>
	<div><a href="<c:url value="/WEB-INF/AddNonPatient.jsp" />">Add Non-Patient</a></div>
</div>

<!-- Main content --> 
<div class="main main-font">
	<h2>Admin's Home</h2>
	<h3>Welcome <%=session.getAttribute("username") %></h3>
</div>
</div>

</body>
</html>