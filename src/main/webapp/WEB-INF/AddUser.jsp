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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user.css" />
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
			<button id="patientButton" onclick="showPatientForm()">Add Patient</button>
			<button id="nonpatientButton" onclick="showNonpatientForm()">Add Non-patient</button>
			
			<!-- Title of form depends on which button the user selects above -->
			<h2 id="patientTitle">Patient Form</h2>
			<h2 id="nonpatientTitle">Non-patient Form</h2>

			<form id="addUserForm" class="content-padding" action="/AddUserServlet" method="post">
				<!--  User ID will be generated based on the following inputs! -->	
				<label>First Name: </label>
				<div><input type="text" id="userFirstName" name="userFirstName" /></div>
				<label>Middle Initial: </label>
				<div><input type="text" id="userMiddleInitial" name="userMiddleInitial" /></div>
				<label>Last Name: </label>
				<div><input type="text" id="userLastName" name="userLastName" /></div>
				<label>Date of Birth: </label>
				<div><input type="date" id="patientDateOfBirth" name="patientDateOfBirth" /></div>
				<label>Current Facility ID (optional): </label>
				<div><input type="text" id="userCurrentFacilityId" name="userCurrentFacilityId" /></div>
				<label>User Email Address: </label>
				<div><input type="text" id="userEmailAddress" name="userEmailAddress" /></div>
				
				<input type="hidden" id="userEnabled" name="userEnabled" value="true">	

				<!-- Patient section -->	
				<div id="patientSection">

					<input type="hidden" id="userType" name="userType" value="patient">

					<label>Race: </label>
					<div>
						<!-- Race drop-down -->
						<select id="userRaceDropdown" name="userRaceDropdown">
							<c:forEach items="${raceList}" var="race">
								<option><c:out value="${race}" /></option>	
							</c:forEach>			
						</select>	
					</div>
					<label>Relationship status: </label>
					<div>
						<!-- Relationship status drop-down -->
						<select id="relationshipStatusDropdown" name="relationshipStatusDropdown">
							<c:forEach items="${relationshipStatusList}" var="relationshipStatus">
								<option><c:out value="${relationshipStatus}" /></option>	
							</c:forEach>	
						</select>
					</div>
					<label>Living arrangement: </label>
					<div>
						<!-- Living arrangement drop-down -->
						<select id="livingArrangmentDropdown" name="livingArrangmentDropdown">
							<c:forEach items="${livingArrangementList}" var="arrangement">
								<option><c:out value="${arrangement}" /></option>	
							</c:forEach>	
						</select>
					</div>
					<label>Current gender: </label>
					<div>
						<!-- Current gender drop-down -->
						<select id="userCurrentGenderDropdown" name="userCurrentGenderDropdown">
							<c:forEach items="${currentGenderList}" var="currentGender">
								<option><c:out value="${currentGender}" /></option>
							</c:forEach>
						</select>
					</div>
					<label>Sex assigned at birth: </label>
					<div>
						<!-- Gender at birth drop-down -->
						<select id="userBirthSex" name="userBirthSex">
							<option>Male</option>	
							<option>Female</option>	
							<option>Choose not to disclose</option>	
						</select>	
					</div>
					<label>Sexual orientation: </label>
					<div>
						<!-- Sexual orientation drop-down -->
						<select id="sexualOrientationDropdown" name="sexualOrientationDropdown">
							<c:forEach items="${sexualOrientationList}" var="sexualOrientation">
								<option><c:out value="${sexualOrientation}" /></option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<!-- Non-patient section -->
				<div id="nonpatientSection">
					<input type="hidden" id="userType" name="userType" value="nonpatient">
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