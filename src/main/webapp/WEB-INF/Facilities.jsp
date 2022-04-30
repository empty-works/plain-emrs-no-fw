<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-setup.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-grid.css" />
<title>Facilities</title>
</head>

<body>
	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>

	<div class="main-container">
		<!-- Side navigation -->
		<div class="sidenav main-font">	
			<div><a href="<c:url value="/FacilitiesServlet" />">Overview</a></div>
			<div><a href="<c:url value="" />">Settings</a></div>
		</div>

		<!-- Main content --> 
		<div class="main-grid-container-side-nav main-font">
			
			<!--  <h3><a href="<c:url value="/LoginServlet" />">Back to admin</a></h3>-->
			<h2>Facility List</h2>	
			<table>
			<c:choose>
			<c:when test="${fn:length(facilitiesList) > 1}">
				<c:forEach items="${facilitiesList}" var="facility">
					<tr>
					<td>--------------------------------------------------------------
						<br><br>	
					</td>
					</tr>
					<tr>
						<td>ID: <c:out value="${facility.getId()}" /></td>	
					</tr>
					<tr>
						<td>Name: <a href="<c:url value="/FacilityServlet" > 
							<c:param name="facId" value="${facility.getId()}" />		
							<c:param name="facNam" value="${facility.getName()}" />		
							<c:param name="facCity" value="${facility.getCity()}" />		
							<c:param name="facCountry" value="${facility.getCountry()}" />		
						</c:url>"> <c:out value="${facility.getName()}" /></a>
					</td>
					</tr>
					<tr>
						<td>City: <c:out value="${facility.getCity()}" /></td>
					</tr>
					<tr>
						<td>Country: <c:out value="${facility.getCountry()}" /></td>
					</tr>	
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div>NO FACILITIES!</div>
			</c:otherwise>
			</c:choose>
			</table>
			
			<h2><a href="<c:url value="/AddFacilityServlet" />">Add Facility</a></h2>
		</div>
	</div>
</body>
</html>