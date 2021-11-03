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
	<div class="facilityGridWrapper">
		<div class="facilityLabel">Facility ID: </div>
		<div class="facilityData"><c:out value="${param.facId}" /></div>
		<div class="facilityLabel">Street Address: </div>
		<div class="facilityData"><c:out value="${param.facStreet}" /></div>
		<div class="facilityLabel">City: </div>
		<div class="facilityData"><c:out value="${param.facCity}" /></div>
		<div class="facilityLabel">State: </div>
		<div class="facilityData"><c:out value="${param.facState}" /></div>
		<div class="facilityLabel">Country: </div>
		<div class="facilityData"><c:out value="${param.facCountry}" /></div>
		<div class="facilityLabel">Zip code: </div>
		<div class="facilityData"><c:out value="${param.facZipCode}" /></div>
		<div class="facilityLabel">Number of beds: </div>
		<div class="facilityData"><c:out value="${param.facNumBeds}" /></div>
		<div class="facilityLabel">Description: </div>
		<div class="facilityData"><c:out value="${param.facDescription}" /></div>
	</div>
	
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