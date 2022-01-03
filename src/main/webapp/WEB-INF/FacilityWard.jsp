<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Facility Wards</title>

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
	<a href="<c:url value="/FacilityServlet"></c:url>">Overview</a>
	<a href="">Wards</a>
	<a href="">Staff Positions</a>
	<a href="">Staff Specialties</a>
</div>

	<h2>Facility Wards</h2>
	<table>
		<tr>
		<c:if test="${empty facilityWardList}" >
			<td>No wards added yet!</td>
		</c:if>
		</tr>
		<c:forEach items="${facilityWardList}" var="facWard">
			<tr>
				<td>ID: <c:out value="${facWard.getWardId()}" /></td>	
			</tr>
			<tr>
				<td>Name: <c:out value="${facWard.getName()}" /></td>
			</tr>
			<tr>
				<td>Location: <c:out value="${facWard.getLocation()}" /></td>
			</tr>	
		</c:forEach>
	</table>
	<div><input id="showFacWardFormButton" type="button" value="Add Ward" onclick="showAddForm('showFacWardFormButton', 'addFacWardForm')" /></div>
	<form id="addFacWardForm" name="wardForm" action="AddFacilityWardServlet" method="post" onsubmit="return validateAddWardForm()">
	<div class="facilityBox">
		<div><input type="hidden" name="facId" value="${param.facId}" /></div>
		<div>Name*: </div>				
		<div><input id="facWardAddName" type="text" name="facilityWardName" /></div>
		<div>Location: </div>
		<div><input type="text" name="facilityWardLocation"  /></div>
		<div><input type="submit" value="Submit" ></input>
			 <input class="cancelAddButton" type="button" value="Cancel" 
				onclick="cancelAddForm('showFacWardFormButton', 'addFacWardForm')"></input></div>
	</div>
	</form>
</body>
</html>