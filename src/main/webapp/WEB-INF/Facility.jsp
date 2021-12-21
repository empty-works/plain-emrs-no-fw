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
		<div class="facility-label facility-edit-form">Facility ID: </div>
		<div class="facility-data facility-edit-form"><c:out value="${facilityDb.getId()}" /></div>
		<div class="facility-label facility-edit-form">Street Address: </div>
		<div class="facility-data facility-edit-form"><c:out value="${facilityDb.getStreetAddress()}" /></div>
		<div class="facility-label facility-edit-form">City: </div>
		<div class="facility-data facility-edit-form"><c:out value="${facilityDb.getCity()}" /></div>
		<div class="facility-label facility-edit-form">State: </div>
		<div class="facility-data facility-edit-form"><c:out value="${facilityDb.getState()}" /></div>
		<div class="facility-label facility-edit-form">Country: </div>
		<div class="facility-data facility-edit-form"><c:out value="${facilityDb.getCountry()}" /></div>
		<div class="facility-label facility-edit-form">Zip code: </div>
		<div class="facility-data facility-edit-form"><c:out value="${facilityDb.getZipCode()}" /></div>
		<div class="facility-label facility-edit-form">Number of beds: </div>
		<div class="facility-data facility-edit-form"><c:out value="${facilityDb.getNumberOfBeds()}" /></div>
		<div class="facility-label facility-edit-form">Description: </div>
		<div class="facility-data facility-edit-form"><c:out value="${facilityDb.getDescription()}" /></div>
		<div><input  /></div>
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
	
	<h2>Facility Staff Positions</h2>	
	<table>
		<tr>
		<c:if test="${empty facilityPositionList}">
			<td>No staff positions added yet!</td>
		</c:if>
		</tr>
		<c:forEach items="${facilityPositionList}" var="facPosition">
			<tr>
				<td>ID: <c:out value="${facPosition.getId()}" /></td>		
			</tr>			
			<tr>
				<td>Name: <c:out value="${facPosition.getName()}" /></td>
			</tr>
			<tr>
				<td>Description: <c:out value="${facPosition.getDescription()}" /></td>
			</tr>
		</c:forEach>
	</table>	
	<div><input id="showFacPositionFormButton" type="button" value="Add Staff Position" onclick="showAddForm('showFacPositionFormButton', 'addFacPositionForm')" /></div>
	<form id="addFacPositionForm" name="positionForm" action="AddFacilityPositionServlet" method="post" onsubmit="return validateAddPositionForm()">
	<div class="facilityBox">
	<div><input type="hidden" name="facId" value="${param.facId}" /></div>			
	<div>Name: </div>	
	<div><input id="facPositionAddName" type="text" name="facilityPositionName" /></div>
	<div>Description: </div>
	<div><input type="text" name="facilityPositionDescription" /></div>
	<div><input type="submit" value="Submit" ></input>
		 <input class="cancelAddButton" type="button" value="Cancel" 
			onclick="cancelAddForm('showFacPositionFormButton', 'addFacPositionForm')"></input></div>
	</div>
	</form>
	
	<h2>Facility Staff Specialties</h2>
	<table>
		<tr>
		<c:if test="${empty facilitySpecialtyList}">
			<td>No staff specialties added yet!</td>
		</c:if>
		</tr>
		<c:forEach items="${facilitySpecialtyList}" var="facSpecialty">
			<tr>
				<td>ID: <c:out value="${facSpecialty.getId()}" /></td>
			</tr>				
			<tr>
				<td>Name: <c:out value="${facSpecialty.getName()}" /></td>
			</tr>
			<tr>
				<td>Description: <c:out value="${facSpecialty.getDescription()}" /></td>
			</tr>
		</c:forEach>	
	</table>
	<div><input id="showFacSpecialtyFormButton" type="button" value="Add Staff Specialty" onclick="showAddForm('showFacSpecialtyFormButton', 'addFacSpecialtyForm')" /></div>	
	<form id="addFacSpecialtyForm" name="specialtyForm" action="AddFacilitySpecialtyServlet" method="post" onsubmit="return validateAddSpecialtyForm()">
	<div class="facilityBox">
	<div><input type="hidden" name="facId" value="${param.facId}" /></div>			
	<div>Name: </div>	
	<div><input id="facSpecialtyAddName" type="text" name="facilitySpecialtyName" /></div>
	<div>Description: </div>
	<div><input type="text" name="facilitySpecialtyDescription" /></div>
	<div><input type="submit" value="Submit" ></input>
		 <input class="cancelAddButton" type="button" value="Cancel" 
			onclick="cancelAddForm('showFacSpecialtyFormButton', 'addFacSpecialtyForm')"></input></div>
	</div>
	</form>
	
</body>
</html>