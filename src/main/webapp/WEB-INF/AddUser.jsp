<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-grid.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/patients.css" />
<script src="${pageContext.request.contextPath}/js/user.js"></script>

<title>Add User</title>
</head>
<body>
	
	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>

	<div class="main-container">
			
		<!-- Side navigation -->
		<div class="sidenav main-font">
			<script id="replace_with_sidenav" src="${pageContext.request.contextPath}/js/adminsidenav.js"></script>
		</div>
		
		<!-- Main content -->
		<div class="main-grid-container-side-nav main-font">
			<h2>Adding a patient or non-patient?</h2>
			<button id="nonpatientButton"></button><button id="patientButton"></button>
			

			<form class="content-padding" action="/AddUserServlet" method="post">
				<h3>Username will be automatically generated based on the following inputs! </h3>	
				<label>User Email Address: </label>
				<div><input type="text" id="userEmailAddress" name="userEmailAddress" /></div>
				<label>User Enabled: </label>
				<div>
					<select type="text" id="userEnabled" name="userEnabled">
						<option>True</option>
						<option>False</option>
					</select>	
				</div>
				<label>Current Facility ID (optional): </label>
				<div><input type="text" id="userCurrentFacilityId" name="userCurrentFacilityId" /></div>
				
				<!-- Patient section -->	
				<div id="patientSection">
					<h3>PATIENT SECTION</h3>
				</div>
				
				<!-- Non-patient section -->
				<div id="nonpatientSection">
					<h3>NONPATIENT SECTION</h3>	
				</div>
				
				<label>Role: </label>
				<div>
					<select id="roleDropdown" name="roleDropdown">
						<c:forEach items="${roleList}" var="userRole">
							<option><c:out value="${userRole.getRole()}" /></option>
						</c:forEach>
					</select>
				</div>
				<div><input type="submit" /><input type="reset" name="Reset" /></div>
			</form>
		</div>
	</div>
</body>
</html>