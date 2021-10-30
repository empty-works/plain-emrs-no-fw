<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/facility.css" />
<title><c:out value="" /></title>
</head>
<body>
	<h2>Facility: <c:out value="${param.facNam}" /></h2>
	<br><br>
	<table>
	<tr>
	<td>Facility ID: </td>
	<td><c:out value="${param.facId}" /></td>
	</tr>	
	<tr>
	<td>Street Address: </td>
	<td><c:out value="${param.facStreet}" /></td>
	</tr>	
	<tr>
	<td>City: </td>
	<td><c:out value="${param.facCity}" /></td>
	</tr>	
	<tr>
	<td>State: </td>
	<td><c:out value="${param.facState}" /></td>
	</tr>	
	<tr>
	<td>Country: </td>
	<td><c:out value="${param.facCountry}" /></td>
	</tr>	
	<tr>
	<td>Zip code: </td>
	<td><c:out value="${param.facZipCode}" /></td>
	</tr>	
	<tr>
	<td>Number of beds: </td>
	<td><c:out value="${param.facNumBeds}" /></td>
	</tr>	
	<tr>
	<td>Description: </td>
	<td><c:out value="${param.facDescription}" /></td>
	</tr>	
	</table>
	
	<br><br>
	
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
	<form id="addFacilityForm" action="AddFacilityWardServlet" method="post">
	<div class="facilityBox">
		<div>Name: </div>				
		<div><input type="text" name="facilityName" /></div>
		<div>Location: </div>
		<div><input type="text" name="facilityLocation" /></div>
	</div>
	</form>
</body>
</html>