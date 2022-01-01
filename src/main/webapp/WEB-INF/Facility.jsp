<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!-- Required meta tags for Bootstrap -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/facility.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<script src="${pageContext.request.contextPath}/js/facility.js"></script>
<title><c:out value="" /></title>
</head>
<body>

<h3><a href="<c:url value="/FacilitiesServlet" />">Back to facilities</a></h3>

<div class="sidenav">
	<a href="">Overview</a>
	<a href="">Wards</a>
	<a href="">Staff Positions</a>
	<a href="">Staff Specialties</a>
</div>

<div class="main">

	<h2>Facility: <c:out value="${facilityDb.getName()}" /></h2>
	<div id="facility-data" class="facility-grid-wrapper">
		<div class="facility-label">Facility ID: </div>
		<div class="facility-data"><c:out value="${facilityDb.getId()}" /></div>
		<div class="facility-label">Street Address: </div>
		<div id="fac-address" class="facility-data"><c:out value="${facilityDb.getStreetAddress()}" /></div>
		<div class="facility-label">City: </div>
		<div id="fac-city" class="facility-data"><c:out value="${facilityDb.getCity()}" /></div>
		<div class="facility-label">State: </div>
		<div id="fac-state" class="facility-data"><c:out value="${facilityDb.getState()}" /></div>
		<div class="facility-label">Country: </div>
		<div id="fac-country" class="facility-data"><c:out value="${facilityDb.getCountry()}" /></div>
		<div class="facility-label">Zip code: </div>
		<div id="fac-zip" class="facility-data"><c:out value="${facilityDb.getZipCode()}" /></div>
		<div class="facility-label">Number of beds: </div>
		<div id="fac-num-beds" class="facility-data"><c:out value="${facilityDb.getNumberOfBeds()}" /></div>
		<div class="facility-label">Description: </div>
		<div id="fac-desc" class="facility-data"><c:out value="${facilityDb.getDescription()}" /></div>
		<div><input id="fac-edit-button" type="button" value="Edit" onclick="makeFormEditable()" /></div>
	</div>
	
	<form id="edit-facility-form" name="editFacilityForm" action="EditFacilityServlet" method="post">

		<div><input type="hidden" name="facId" value="${facilityDb.getId()}" /></div>
		<div>Name: </div>
		<div><input type="text" name="facilityName" value="${facilityDb.getName()}" /></div>
		<div>Street address: </div>
		<div><input type="text" name="facilityStreetAddress" value="${facilityDb.getStreetAddress()}" /></div>
		<div>City: </div>
		<div><input type="text" name="facilityCity" value="${facilityDb.getCity()}"/></div>
		<div>State: </div>
		<div><input type="text" name="facilityState" value="${facilityDb.getState()}"/></div>
		<div>Country: </div>
		<div><input type="text" name="facilityCountry" value="${facilityDb.getCountry()}"/></div>
		<div>ZIP code: </div>
		<div><input type="text" name="facilityZipCode" value="${facilityDb.getZipCode()}"/></div>
		<div>Number of beds: </div>
		<div><input type="number" name="facilityNumBeds" min="3" max="100000" value="${facilityDb.getNumberOfBeds()}"/></div>
		<div>Description: </div>
		<div><input type="text" name="facilityDescription" value="${facilityDb.getDescription()}"/></div>
		<div id="fac-save-cancel">
			<input id="fac-save-button" type="submit" value="Save" /><input id="fac-cancel-button" type="button" value="Cancel" onclick="makeFormNotEditable()" />
		</div>
	</form>
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
	
	<!-- Bootstrap bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>