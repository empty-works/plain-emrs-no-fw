<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Facility Staff Position</title>

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
	<a href="<c:url value="/FacilitiesServlet"></c:url>" class="active">Back to facility</a>
</div>

<div class="sidenav">
	<a href="<c:url value="/FacilityServlet">
		<c:param name="facId" value="${param.facId}"></c:param>
	</c:url>">Overview</a>
	<a href="<c:url value="/FacilityWardServlet">
		<c:param name="facId" value="${param.facId}"></c:param>	
	</c:url>">Wards</a>
	<a href="<c:url value="/FacilitySpecialtyServlet">
		<c:param name="facId" value="${param.facId}"></c:param>
		</c:url>">Staff Specialties</a>
</div>

<div class="main">
	<h2>Facility Staff Positions</h2>	
	<table>
		<tr>
		<c:if test="${empty facilityPositionList}">
			<td>No staff positions added yet!</td>
		</c:if>
		</tr>
		<c:forEach items="${facilityPositionList}" var="facPosition">
			<tr>
				<td>ID: <c:out value="${facPosition.getStaffPositionId()}" /></td>		
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
</div>

<!-- Bootstrap bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>