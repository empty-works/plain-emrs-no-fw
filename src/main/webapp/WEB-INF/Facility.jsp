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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/topnav.css" />
<script src="${pageContext.request.contextPath}/js/facility.js"></script>
<title><c:out value="" /></title>
</head>
<body>

<div class="topnav">
	<a class="active" href="<c:url value="/FacilitiesServlet" />">Back to facilities</a>
</div>

<div class="sidenav">
	<a href="<c:url value="/FacilityWardServlet">
		<c:param name="facId" value="${facilityDb.getId()}"></c:param>	
		</c:url>">Wards</a>
	<a href="<c:url value="/FacilityPositionServlet">
		<c:param name="facId" value="${param.facId}"></c:param>
	</c:url>">Staff Positions</a>
	<a href="<c:url value="/FacilitySpecialtyServlet">
		<c:param name="facId" value="${param.facId}"></c:param>
		</c:url>">Staff Specialties</a>
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
	
	<h2>Roles</h2>
	<table>
		<tr>
		<c:if test="${empty rolesList}">
			<td>No roles added yet!</td>
		</c:if>
		</tr>				
		<c:forEach items="${rolesList}" var="role">
			<tr>
				<td>ID: <c:out value="${role.getId()}" /></td>
			</tr>	
			<tr>
				<td>Name: <c:out value="${role.getName()}" /></td>
			</tr>
			<tr>
				<td>Group: <c:out value="${role.getGroup()}" /></td>
			</tr>
			<tr>
				<td>Description: <c:out value="${role.getDescription()}" /></td>
			</tr>
		</c:forEach>		
	</table>	
		
	<h2>Add Role</h2>
	<form id="addRoleForm" name="roleForm" action="RoleServlet" method="post">
	<div class="facilityBox">
		<div>Name: </div>	
		<div><input id="roleAddName" type="text" name="roleName" /></div>
		<div>Group: </div>
		<div><input type="text" name="roleGroup" /></div>
		<div>Description: </div>
		<div><input type="text" name="roleDescription" /></div>
		<div><input type="submit" value="Add Role" />
			 <input class="cancelAddButton" type="button" value="Cancel" />
		</div>
	</div>	
	</form>
	</div>	
	<br><br>

	<!-- Bootstrap bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>