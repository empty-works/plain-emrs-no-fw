<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/facility.css" />
<script src="${pageContext.request.contextPath}/js/facility.js"></script>
<meta charset="UTF-8">
<title><c:out value="" /></title>
</head>
<body>
	
	<h3><a href="<c:url value="/FacilitiesServlet" />">Back to facilities</a></h3>

	<h2>Facility: <c:out value="${facilityDb.getName()}" /></h2>
	<div class="facility-grid-wrapper">
		<div class="facility-label">Facility ID: </div>
		<div class="facility-data"><c:out value="${facilityDb.getId()}" /></div>
		<div class="facility-label">Street Address: </div>
		<div class="facility-data"><c:out value="${facilityDb.getStreetAddress()}" /></div>
		<div class="facility-label">City: </div>
		<div class="facility-data"><c:out value="${facilityDb.getCity()}" /></div>
		<div class="facility-label">State: </div>
		<div class="facility-data"><c:out value="${facilityDb.getState()}" /></div>
		<div class="facility-label">Country: </div>
		<div class="facility-data"><c:out value="${facilityDb.getCountry()}" /></div>
		<div class="facility-label">Zip code: </div>
		<div class="facility-data"><c:out value="${facilityDb.getZipCode()}" /></div>
		<div class="facility-label">Number of beds: </div>
		<div class="facility-data"><c:out value="${facilityDb.getNumberOfBeds()}" /></div>
		<div class="facility-label">Description: </div>
		<div class="facility-data"><c:out value="${facilityDb.getDescription()}" /></div>
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
	<div><input id="showFacWardFormButton" type="button" value="Add Ward" onclick="showAddForm('showFacWardFormButton', 'addFacWardForm')" /></div>
	<form id="addFacWardForm" name="wardForm" action="AddFacilityWardServlet" method="post" onsubmit="return validateAddWardForm()">
	<div class="facilityBox">
		<div><input type="hidden" name="setFacId" value="${param.facId}" /></div>
		<div>Name*: </div>				
		<div><input id="facWardAddName" type="text" name="facilityWardName" /></div>
		<div>Location: </div>
		<div><input type="text" name="facilityWardLocation"  /></div>
		<div><input type="submit" value="Submit" ></input>
			 <input id="cancelAddWardButton" type="button" value="Cancel" 
				onclick="cancelAddForm('showFacWardFormButton', 'addFacWardForm')"></input></div>
	</div>
	</form>
	
	<h2>Facility Staff Positions</h2>	
	<table>
		<tr>
		<c:if test="${empty positionsList}">
			<td>No staff positions added yet!</td>
		</c:if>
		</tr>
		<c:forEach items="${positionsList}" var="position">
			<tr>
				<td>ID: <c:out value="${position.getId()}" /></td>		
			</tr>			
			<tr>
				<td>Name: <c:out value="${position.getName()}" /></td>
			</tr>
			<tr>
				<td>Description: <c:out value="${position.getDescription()}" /></td>
			</tr>
		</c:forEach>
	</table>	
	<div><input id="showFacPosition" type="button" value="Add Staff Position" onclick="showAddForm()" /></div>
</body>
</html>