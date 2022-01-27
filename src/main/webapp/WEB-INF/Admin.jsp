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

<!-- Required meta tags for Bootstrap -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/facility.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/topnav.css" />
<script src="${pageContext.request.contextPath}/js/facility.js"></script>

</head>
<body>

<!-- Top bar -->
<nav class="navbar text-white" style="background-color: #334257;">
	<span class="navbar-brand h1">Plain EMRS</span>
	<form class="form-inline">
		<a class="">User</a>	
	</form>
</nav>

<!-- Top navigation -->
<div class="topnav-ul">
	<div class="topnav-li topnav-active">Hello</div>		
	<div class="topnav-li">Hello</div>		
	<div class="topnav-li">Hello</div>		
	<div class="topnav-li">Hello</div>		
</div>

<div class="sidenav">	
	<div><a href="<c:url value="/FacilitiesServlet" />">Facilities</a></div>
	<div><a href="<c:url value="/RolesServlet" />">Roles</a></div>
	<div><a href="<c:url value="/WEB-INF/AddNonPatient.jsp" />">Add Non-Patient</a></div>
</div>

<div class="main">
	<h2>Admin's Home</h2>
	<h3>Welcome <%=session.getAttribute("username") %></h3>
</div>

<!-- Bootstrap bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>