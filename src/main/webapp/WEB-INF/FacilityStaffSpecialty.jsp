<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Facility Staff Specialty</title>


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

<div class="topnav">
	<a class="active" href="<c:url value="/FacilitiesServlet" />">Back to facilities</a>
</div>

<div class="sidenav">
	<a href="<c:url value="/FacilityServlet">
		<c:param name="facId" value="${param.facId}"></c:param>
	</c:url>">Overview</a>
	<a href="<c:url value="/FacilityWardServlet">
		<c:param name="facId" value="${param.facId}"></c:param>	
		</c:url>">Wards</a>
	<a href="<c:url value="/FacilityPositionServlet">
		<c:param name="facId" value="${param.facId}"></c:param>
	</c:url>">Staff Positions</a>
</div>

<div class="main">

</div>

</body>
</html>