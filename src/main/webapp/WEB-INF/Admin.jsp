<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" />
<title>Admin Page</title>

<% 	// If Admin session is not set, redirect to the default page
	if((request.getSession(false).getAttribute("Admin") == null)) {
%>
	<jsp:forward page="/default.jsp"></jsp:forward>
<%} %>

</head>
<body>

<div class="sidenav">	
	<div><a href="<c:url value="/FacilitiesServlet" />">Facilities</a></div>
	<div><a href="<c:url value="/RolesServlet" />">Roles</a></div>
	<div><a href="<c:url value="/WEB-INF/AddNonPatient.jsp" />">Add Non-Patient</a></div>
</div>

<div class="main">
	<h2>Admin's Home</h2>
	<h3>Welcome <%=session.getAttribute("username") %></h3>
</div>
</body>
</html>