<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
				<fieldSet>
					<legend>General: </legend>
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
				</fieldSet>
				<input type="hidden" id="userEnabled" name="userEnabled" value="true">	

				<!-- Patient section -->	
				<div id="patientSection">

					<input type="hidden" id="userType" name="userType" value="patient">

					<fieldset>
						<legend>Patient Personal Information: </legend>	
						<label>Street Address: </label>
						<div><input type="text" id="patientStreetAddress" name="patientStreetAddress" /></div>
						<label>City: </label>
						<div><input type="text" id="patientCity" name="patientCity" /></div>
						<label>State: </label>
						<div><input type="text" id="patientState" name="patientState" /></div>
						<label>Country: </label>
						<div><input type="text" id="patientCountry" name="patientCountry" /></div>
						<label>Phone Number: </label>
						<div><input type="text" id="patientPhoneNumber" name="patientPhoneNumber" /></div>
						<label>Patient Provider: </label>
						<div><input type="text" id="patientProvider" name="patientProvider" /></div>
						<label>Patient Provider ID: </label>
						<div><input type="text" id="patientProviderId" name="patientProviderId" /></div>
					</fieldset>
					<fieldset>
						<legend>Ethnicity: </legend>
						<!-- Hispanic Origin -->
						<h3>Hispanic, Latino(a), Spanish Origin: </h3>
						<c:forEach items="${latinOptionsList}" var="latinOption">
							<div>
								<input type="checkbox" id="${latinOption.getRaceId()}" name="raceOption" value="${latinOption.getRaceId()}">
								<label for="${latinOption.getRaceId()}">${latinOption.getRaceName()}</label>	
							</div>
						</c:forEach>
						<h3>Another Hispanic, Latino/a, or Spanish Origin</h3>
							<select id="latinOthersDropdown" name="latinOthersDropdown">
								<c:forEach items="${latinOthersList}" var="latinOther">
									<option><c:out value="${latinOther.getRaceName()}" /></option>	
								</c:forEach>
							</select>	
					</fieldset>
					<fieldset>
						<legend>Relationship status: </legend>
						<!-- Relationship status drop-down -->
						<c:forEach items="${relationshipStatusList}" var="relationshipStatus">
							<div>
								<input type="checkbox" id="${relationshipStatus.getRelationshipStatusId()}" name="relationshipOption" value="${relationshipStatus.getRelationshipStatusId()}">
								<label for="${relationshipStatus.getRelationshipStatusId()}">${relationshipStatus.getRelationshipStatus()}</label>
							</div>	
						</c:forEach>
					</fieldset>
					<fieldset>
						<legend>Living arrangement: </legend>	
						<!-- Living arrangement selection -->
						<c:forEach items="${livingArrangementList}" var="living">
							<div>
								<input type="checkbox" id="${living.getArrangementId()}" name="raceOption" value="${living.getArrangementId()}">
								<label for="${living.getArrangementId()}">${living.getArrangement()}</label>	
							</div>	
						</c:forEach>
					</fieldset>
					<fieldset>
						<legend>Current gender: </legend>
						<!-- Current gender selection -->
						<c:forEach items="${currentGenderList}" var="currentGender">
							<div>
								<input type="radio" id="${currentGender.getCurrentGenderId()}" name="currentGenderRadio" value="${currentGender.getCurrentGenderId()}">
								<label for="${currentGender.getCurrentGenderId()}">${currentGender.getCurrentGender()}</label>
							</div>
						</c:forEach>
					</fieldset>
					<fieldset>
						<legend>Sex assigned at birth: </legend>
						<!-- Gender at birth selection -->
						<c:forEach items="${sexAssignedBirthList}" var="sexAssignedBirth">
							<div>
								<input type="radio" id="${sexAssignedBirth.getSexAssignedBirthId()}" name="sexAssignedBirthRadio" value="${sexAssignedBirth.getSexAssignedBirthId()}">	
								<label for="${sexAssignedBirth.getSexAssignedBirthId()}">${sexAssignedBirth.getSexAssignedBirth()}</label>
							</div>	
						</c:forEach>
					</fieldset>
					<fieldset>
						<legend>Sexual orientation: </legend>	
						<!-- Sexual orientation selection -->
						<c:forEach items="${sexualOrientationList}" var="sexualOrientation">
							<div>
								<input type="radio" id="${sexualOrientation.getSexualOrientationId()}" name="sexualOrientationRadio" value="${sexualOrientation.getSexualOrientationId()}">
								<label for="${sexualOrientation.getSexualOrientationId()}">${sexualOrientation.getSexualOrientation()}</label>
							</div>	
						</c:forEach>
					</fieldset>

					<h3>Medical History</h3>
					<fieldset>
						<!-- Received blood transfusion -->
						<legend>Blood transfusion: </legend>	
						<div>
							<input type="radio" id="bloodTransfusionYes" name="bloodTransfusionYes" value="bloodTransfusionYes">	
							<label for="bloodTransfusionYes">Yes</label>
							<input type="radio" id="bloodTransfusionNo" name="bloodTransfusionNo" value="bloodTransfusionNo">	
							<label for="bloodTransfusionNo">No</label>
							<input type="radio" id="bloodTransfusionUnknown" name="bloodTransfusionUnknown" value="bloodTransfusionUnknown">	
							<label for="bloodTransfusionUnknown">Do not know</label>
						</div>
					</fieldset>
					<fieldset>
						<!-- Immunizations/diseases -->	
						<legend>Immunizations/diseases</legend>
						<c:forEach items="${diseaseList}" var="disease">
							<div>
								<span>${disease.getDiseaseName()}: </span>
								<input type="checkbox" id="${disease.getDiseaseId()}" name="${disease.getDiseaseId()}" value="${disease.getDiseaseId()} + Yes">
								<label for="${disease.getDiseaseId()}">Had Disease</label>
								<input type="checkbox" id="${disease.getDiseaseImmunizedId()}" name="${disease.getDiseaseImmunizedId()}" value="${disease.getDiseaseImmunizedId()} + Yes">
								<label for="${disease.getDiseaseImmunizedId()}">Immunized</label>
								<input type="checkbox" id="diseaseUnknown" name="diseaseUnknown" value="${disease.getDiseaseImmunizedId()} + Unknown">
								<label for="diseaseUnknown">Do not know</label>
							</div>	
						</c:forEach>
					</fieldset>
					<fieldset>
						<legend>Medical problems and surgical procedures</legend>	
						<h4>General</h4>
						<div id="genMedProbContainer">
							<div>
								<select>
									<c:forEach items="${generalMedicalProblemListNonJson}" var="genMedProb">
										<option>${genMedProb.getProblemArea()}</option>	
									</c:forEach>
								</select>
								<input type="text" class="medProbText" name="medProbText" placeholder="Medical problem:">
								<input type="text" class="medProbText" name="medProbSurgeryText" placeholder="Surgical procedure:">
								<label for="medProbSurgeryDate">Surgical procedure date: </label>
								<input type="date" class="medProbText" name="medProbSurgeryDate">
							</div>			
						</div>
						<button type="button" id="genMedAddButton" onclick='genMed.addNode(${fn:escapeXml(generalMedicalProblemListJson)}, genMedProbContainer)'>Add</button><div id="addLimitReached"></div>
						<div id="genMedLimitMsg"></div>
						<h4>Heart-related</h4>
						<div id="heartMedProbContainer">
							<div>
								<select>
									<c:forEach items="${heartMedicalProblemListNonJson}" var="heartMedProb">
										<option>${heartMedProb.getProblemArea()}</option>	
									</c:forEach>
								</select>
								<input type="text" class="medProbText" name="medProbText" placeholder="Medical problem:">
								<input type="text" class="medProbText" name="medProbSurgeryText" placeholder="Surgical procedure:">
								<label for="medProbSurgeryDate">Surgical procedure date: </label>
								<input type="date" class="medProbText" name="medProbSurgeryDate">
							</div>			
						</div>
						<button type="button" id="heartMedAddButton" onclick='heartMed.addNode(${fn:escapeXml(heartMedicalProblemListJson)}, heartMedProbContainer)'>Add</button><div id="addLimitReached"></div>
						<div id="heartMedLimitMsg"></div>
						<h4>Reproductive-related</h4>
						<div id="reproductMedProbContainer">
							<div>
								<select>
									<c:forEach items="${reproductMedicalProblemListNonJson}" var="reproductMedProb">
										<option>${reproductMedProb.getProblemArea()}</option>	
									</c:forEach>
								</select>
								<input type="text" class="medProbText" name="medProbText" placeholder="Medical problem:">
								<input type="text" class="medProbText" name="medProbSurgeryText" placeholder="Surgical procedure:">
								<label for="medProbSurgeryDate">Surgical procedure date: </label>
								<input type="date" class="medProbText" name="medProbSurgeryDate">
							</div>			
						</div>
						<button type="button" id="reproductMedAddButton" onclick='reproductMed.addNode(${fn:escapeXml(reproductMedicalProblemListJson)}, reproductMedProbContainer)'>Add</button><div id="addLimitReached"></div>
						<div id="reproductMedLimitMsg"></div>
					</fieldset>
					<fieldset>
						<legend>Other surgical procedures not listed above</legend>
						<input type="text" class="medProbText" name="medProbAreaText" placeholder="Medical problem area:">
						<input type="text" class="medProbText" name="medProbText" placeholder="Medical problem:">
						<input type="text" class="medProbText" name="medProbSurgeryText" placeholder="Surgical procedure:">
						<label for="medProbSurgeryDate">Surgical procedure date: </label>
						<input type="date" class="medProbText" name="medProbSurgeryDate">
					</fieldset>
					<fieldset>
						<legend>Personal and family history</legend>	
						<div>Is patient adopted?</div>
						<input type="radio" id="isAdoptedNo" name="patientAdopted" value="No">
						<label for="isAdoptedNo">No</label><br>
						<input type="radio" id="isAdoptedYes" name="patientAdopted" value="Yes">
						<label for="isAdoptedYes">Yes</label><br>
						<div>Father:</div>
						<input type="radio" id="fatherNotKnow" name="patientFather" value="Do not know">
						<label for="fatherNotKnow">Do not know</label><br>
						<input type="radio" id="fatherAlive" name="patientFather" value="Father alive">
						<label for="fatherAlive">Alive</label><br>
						<input type="radio" id="fatherDec" name="patientFather" value="Father deceased">
						<label for="fatherDec">Deceased: </label>
						<select id="fatherDecAge" name="fatherDecAge">
							<option>Under 30</option>
							<option>30-40</option>
							<option>41-50</option>
							<option>51-60</option>
							<option>61-70</option>
							<option>Over 70</option>
						</select>
						<input type="text" id="fatherCauseDeath" name="fatherCauseDeath" placeholder="Cause of death">
						<div>Mother:</div>
						<input type="radio" id="motherNotKnow" name="patientMother" value="Do not know">
						<label for="motherNotKnow">Do not know</label><br>
						<input type="radio" id="motherAlive" name="patientMother" value="Mother alive">
						<label for="motherAlive">Alive</label><br>
						<input type="radio" id="motherDec" name="patientMother" value="Mother deceased">
						<label for="motherDec">Deceased: </label>
						<select id="motherDecAge" name="motherDecAge">
							<option>Under 30</option>
							<option>30-40</option>
							<option>41-50</option>
							<option>51-60</option>
							<option>61-70</option>
							<option>Over 70</option>
						</select>
						<input type="text" id="motherCauseDeath" name="motherCauseDeath" placeholder="Cause of death">
					</fieldset>
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