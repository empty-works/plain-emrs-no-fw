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
						<div><input type="text" id="patientCountry" name="patientCountry" /></div> <label>Phone Number: </label> <div><input type="text" id="patientPhoneNumber" name="patientPhoneNumber" /></div> <label>Patient Provider: </label>
						<div><input type="text" id="patientProvider" name="patientProvider" /></div>
						<label>Patient Provider ID: </label>
						<div><input type="text" id="patientProviderId" name="patientProviderId" /></div>
					</fieldset>
					<fieldset>
						<legend>Race and Ethnicity</legend>
						<c:forEach items="${raceList}" var="raceOption">
							<div>
								<input type="checkbox" id="${raceOption.getRaceId()}" name="raceCheck" value="${raceOption.getRaceName()}">
								<label for="${raceOption.getRaceId()}">${raceOption.getRaceName()}</label>	
								<c:choose>
									<c:when test="${raceOption.getRaceId() == asian}">
										<select id="asianEthnDropdown">
											<option selected="selected">Unknown</option>
											<c:forEach items="${asianEthnList}" var="asianEthn">
												<option><c:out value="${asianEthn.getRaceName()}"></c:out></option>	
											</c:forEach>
										</select>	
									</c:when>
								</c:choose>
								<c:choose>
									<c:when test="${raceOption.getRaceId() == hiLa}">
										<select id="hisLatinEthnDropdown">
											<option selected="selected">Unknown</option>
											<c:forEach items="${hisLatEthnList}" var="hisLatEthn">
												<option><c:out value="${hisLatEthn.getRaceName()}"></c:out></option>	
											</c:forEach>
										</select>	
									</c:when>
								</c:choose>
								<c:choose>
									<c:when test="${raceOption.getRaceId() == naHaPaIs}">
										<select id="pacIslEthnDropdown">
											<option selected="selected">Unknown</option>
											<c:forEach items="${pacifIslEthnList}" var="pacIslEthn">
												<option><c:out value="${pacIslEthn.getRaceName()}"></c:out></option>	
											</c:forEach>
										</select>	
									</c:when>
								</c:choose>
							</div>
						</c:forEach>	
					</fieldset>
					<fieldset>
						<legend>Marital status: </legend>
						<!-- Marital status drop-down -->
						<c:forEach items="${maritalStatusList}" var="maritalStatus">
							<div>
								<input type="radio" id="${maritalStatus.getMaritalStatusId()}" name="maritalOptionRadio" value="${maritalStatus.getMaritalStatusId()}">
								<label for="${maritalStatus.getMaritalStatusId()}">${maritalStatus.getMaritalStatus()}</label>
							</div>	
						</c:forEach>
					</fieldset>
					<fieldset>
						<legend>Living arrangement: </legend>	
						<!-- Living arrangement selection -->
						<c:forEach items="${livingArrangementList}" var="living">
							<div>
								<input type="radio" id="${living.getArrangementId()}" name="livingOptionRadio" value="${living.getArrangementId()}">
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
						<legend>Patient condition</legend>	
						<!-- Patient conditions based on HIPAA guidelines -->
						<select id="patientConditionDropdown" name="patientConditionDropdown">
							<option>Undetermined</option>	
							<option>Good</option>	
							<option>Fair</option>	
							<option>Serious</option>	
							<option>Critical</option>	
							<option>Treated and released</option>	
							<option>Confirming patient death</option>	
						</select>
					</fieldset>
					<fieldset>
						<!-- Received blood transfusion -->
						<legend>Blood transfusion: </legend>	
						<div>
							<input type="radio" id="bloodTransfusionYes" name="bloodTransfusionRadio" value="bloodTransfusionYes">	
							<label for="bloodTransfusionYes">Yes</label>
							<input type="radio" id="bloodTransfusionNo" name="bloodTransfusionRadio" value="bloodTransfusionNo">	
							<label for="bloodTransfusionNo">No</label>
							<input type="radio" id="bloodTransfusionUnknown" name="bloodTransfusionRadio" value="bloodTransfusionUnknown">	
							<label for="bloodTransfusionUnknown">Do not know</label>
						</div>
					</fieldset>
					<fieldset>
						<!-- Immunizations/diseases -->	
						<legend>Immunizations/diseases</legend>
						<c:forEach items="${diseaseList}" var="disease">
							<div>
								<span>${disease.getDiseaseName()}: </span>
								<input type="radio" id="${disease.getDiseaseId()} + NeverHad" name="${disease.getDiseaseId()} + immuDiseaseRadio" value="${disease.getDiseaseId()} + NeverHad">
								<label for="${disease.getDiseaseId()} + NeverHad">Never had disease or do not know</label>
								<input type="radio" id="${disease.getDiseaseId()} + HadNoImmun" name="${disease.getDiseaseId()} + immuDiseaseRadio" value="${disease.getDiseaseId()} + HadNoImmun">
								<label for="${disease.getDiseaseId()} + Name">Had disease but no immunization</label>
								<input type="radio" id="${disease.getDiseaseId()} + HadImmun" name="${disease.getDiseaseId()} + immuDiseaseRadio" value="${disease.getDiseaseId()} + HadImmun">
								<label for="${disease.getDiseaseId()} + Immunized">Had disease and immunized</label>
							</div>	
						</c:forEach>
					</fieldset>
					<fieldset>
						<legend>Medical problems and surgical procedures</legend>	
						<h4>General</h4>
						<div id="genMedProbContainer">
							<script type="text/javascript">window.onload=genMed.addNode(${generalMedicalProblemListJson}, genMedProbContainer, false)</script>
						</div>
						<button type="button" id="genMedAddButton" onclick='genMed.addNode(${fn:escapeXml(generalMedicalProblemListJson)}, genMedProbContainer, true)'>Add</button><div id="addLimitReached"></div>
						<div id="genMedLimitMsg"></div>
						<h4>Heart-related</h4>
						<div id="heartMedProbContainer">
							<script type="text/javascript">window.onload=heartMed.addNode(${heartMedicalProblemListJson}, heartMedProbContainer, false)</script>
						</div>
						<button type="button" id="heartMedAddButton" onclick='heartMed.addNode(${fn:escapeXml(heartMedicalProblemListJson)}, heartMedProbContainer, true)'>Add</button><div id="addLimitReached"></div>
						<div id="heartMedLimitMsg"></div>
						<h4>Reproductive-related</h4>
						<div id="reproductMedProbContainer">
							<script type="text/javascript">window.onload=reproductMed.addNode(${reproductMedicalProblemListJson}, reproductMedProbContainer, false)</script>
						</div>
						<button type="button" id="reproductMedAddButton" onclick='reproductMed.addNode(${fn:escapeXml(reproductMedicalProblemListJson)}, reproductMedProbContainer, true)'>Add</button><div id="addLimitReached"></div>
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
						<input type="radio" id="isAdoptedNo" name="patientAdopted" value="false">
						<label for="isAdoptedNo">No</label><br>
						<input type="radio" id="isAdoptedYes" name="patientAdopted" value="true">
						<label for="isAdoptedYes">Yes</label><br>
						<div>Father:</div>
						<input type="radio" id="fatherNotKnow" name="patientFather" value="unknown">
						<label for="fatherNotKnow">Do not know</label><br>
						<input type="radio" id="fatherAlive" name="patientFather" value="true">
						<label for="fatherAlive">Alive</label><br>
						<input type="radio" id="fatherDec" name="patientFather" value="false">
						<label for="fatherDec">Deceased: </label>
						<input type="hidden" name="fatherDecAge" value="not applicable">
						<select id="fatherDecAge" name="fatherDecAge">
							<option>Under 30</option>
							<option>30-40</option>
							<option>41-50</option>
							<option>51-60</option>
							<option>61-70</option>
							<option>Over 70</option>
						</select>
						<input type="hidden" name="fatherCauseDeath" value="not applicable">
						<input type="text" id="fatherCauseDeath" name="fatherCauseDeath" placeholder="Cause of death">
						<div>Mother:</div>
						<input type="radio" id="motherNotKnow" name="patientMother" value="unknown">
						<label for="motherNotKnow">Do not know</label><br>
						<input type="radio" id="motherAlive" name="patientMother" value="true">
						<label for="motherAlive">Alive</label><br>
						<input type="radio" id="motherDec" name="patientMother" value="false">
						<label for="motherDec">Deceased: </label>
						<input type="hidden" name="motherDecAge" value="not applicable">
						<select id="motherDecAge" name="motherDecAge">
							<option>Under 30</option>
							<option>30-40</option>
							<option>41-50</option>
							<option>51-60</option>
							<option>61-70</option>
							<option>Over 70</option>
						</select>
						<input type="hidden" name="motherCauseDeath" value="not applicable">
						<input type="text" id="motherCauseDeath" name="motherCauseDeath" placeholder="Cause of death">
					</fieldset>
					<fieldset>
						<legend>Patient other relations</legend>	
						<div id="otherRelationsCon">
							<script type="text/javascript">
								window.onload = addPatientOtherRelations("Brothers")
								window.onload = addPatientOtherRelations("Sisters")
								window.onload = addPatientOtherRelations("Sons")
								window.onload = addPatientOtherRelations("Daughters")
							</script>
						</div>
					</fieldset>
					<fieldset>
						<legend>Personal and family history</legend>	
						<div id="familyConditionsCon">
							<script type="text/javascript">
								window.onload=addFamilyCondition(${familyConditionsList}, familyConditionsCon)
							</script>
						</div>
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

				<!-- user.js sets the value of submit to "isPatient" or "isNonPatient" -->
				<div><input id="patientFormSubmitButton" type="submit" /><input type="reset" name="Reset" /></div>
			</form>
		</div>
	</div>
</body>
</html>