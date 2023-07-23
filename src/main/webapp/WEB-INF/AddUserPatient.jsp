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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css" />
<script src="${pageContext.request.contextPath}/js/user.js"></script>

<title>Add User</title>
</head>
<body>
	
	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>

	<div class="main-container">

		<div class="side-main-menu">
			<script id="replace_with_sidemainmenu" src="${pageContext.request.contextPath}/js/adminsidemainmenu.js"></script>	
		</div>

		<!-- Main content -->
		<div class="main-grid-container form-font form-dimensions">
			<h2 id="patientTitle">Add Patient Form (Admin Only)</h2>

			<form id="addUserPatientForm" name="addUserPatientForm" class="content-padding" action="AddUserPatientServlet" onsubmit="return validateForm()" method="post">
				<fieldSet>
					<legend>General: </legend>
					<!--  User ID will be generated based on the following inputs! -->	
					<label for="userFirstName">First Name: </label>
					<div><input required type="text" id="userFirstName" name="userFirstName" /></div>
					<label for="userMiddleInitial">Middle Initial: </label>
					<div><input type="text" id="userMiddleInitial" name="userMiddleInitial" pattern="[A-Za-z]" maxlength="1" style="text-transform:uppercase" /></div>
					<label for="userLastName">Last Name: </label>
					<div><input required type="text" id="userLastName" name="userLastName" /></div>
					<label for="patientDateOfBirth">Date of Birth: </label>
					<div><input required type="date" id="patientDateOfBirth" name="patientDateOfBirth" /></div>
					<label for="userCurrentFacilityId">Current Facility ID (optional): </label>
					<div><input type="text" id="userCurrentFacilityId" name="userCurrentFacilityId" /></div>
					<label for="userEmailAddress">Email Address: </label>
					<div><input type="email" id="userEmailAddress" name="userEmailAddress" /></div>
					<label for="langPrefSelect">Language Preference</label>
					<div>
						<select id="langPrefSelect" name="langPrefSelect">
							<option>Arabic</option>	
							<option>Bengali</option>
							<option>Chinese (Simplified)</option>
							<option>Chinese (Traditional)</option>
							<option selected="selected">English</option>
							<option>French</option>
							<option>German</option>
							<option>Hindi</option>
							<option>Italian</option>
							<option>Japanese</option>
							<option>Korean</option>
							<option>Lahnda</option>
							<option>Malay</option>
							<option>Marathi</option>
							<option>Persian</option>
							<option>Portuguese</option>
							<option>Spanish</option>
							<option>Russian</option>
							<option>Tamil</option>
							<option>Telugu</option>
							<option>Turkish</option>
							<option>Urdu</option>
							<option>Vietnamese</option>
							<option>Other</option>
						</select>	
					</div>
				</fieldSet>
				<input type="hidden" id="userEnabled" name="userEnabled" value="true">	
				
				<!-- Emergency contacts -->
				<fieldSet>
					<legend>Emergency Contact</legend>	
					<label for="contactFirstName">First Name: </label>
					<div><input type="text" id="contactFirstName" name="contactFirstName" /></div>
					<label for="contactMiddleInitial">Middle Initial: </label>
					<div><input type="text" id="contactMiddleInitial" name="contactMiddleInitial" pattern="[A-Za-z]" maxlength="1" style="text-transform:uppercase" /></div>
					<label for="contactLastName">Last Name: </label>
					<div><input required type="text" id="contactLastName" name="contactLastName" /></div>
					<label for="contactPhoneArea">Phone Number: </label>
					<div><input type="tel" placeholder="123" id="contactPhoneArea" name="contactPhoneArea" pattern="[0-9]{3}" /><input type="tel" placeholder="123-4567" name="contactPhoneNumber" pattern="[0-9]{3}-[0-9]{4}" /></div>
					<label for="contactEmailAddress">Email Address: </label>
					<div><input type="email" id="contactEmailAddress" name="contactEmailAddress" /></div>
				</fieldSet>

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
						<div><input type="tel" placeholder="123" name="patientPhoneArea" pattern="[1-9]{3}" /><input type="tel" placeholder="123-4567" name="patientPhoneNumber" pattern="[0-9]{3}-[0-9]{4}" /></div> 
						<label>Patient Provider</label>
						<div><input required type="text" id="patientProvider" name="patientProvider" /></div>
						<label>Patient Provider ID: </label>
						<div><input required type="text" id="patientProviderId" name="patientProviderId" /></div>
					</fieldset>
					<fieldset>
						<legend id="raceFieldLegend">Race and Ethnicity</legend>
						<c:forEach items="${raceList}" var="raceOption">
							<div>
								<input type="checkbox" id="${raceOption.getRaceId()}" name="raceCheck" value="${raceOption.getRaceName()}">
								<label for="${raceOption.getRaceId()}">${raceOption.getRaceName()}</label>	
								<c:choose>
									<c:when test="${raceOption.getRaceId() == asian}">
										<select id="asianEthnDropdown" name="asianEthnDropdown">
											<option selected="selected">Unknown</option>
											<c:forEach items="${asianEthnList}" var="asianEthn">
												<option value="${asianEthn.getRaceName()}"><c:out value="${asianEthn.getRaceName()}"></c:out></option>	
											</c:forEach>
										</select>	
									</c:when>
								</c:choose>
								<c:choose>
									<c:when test="${raceOption.getRaceId() == hiLa}">
										<select id="hisLatinEthnDropdown" name="hisLatinEthnDropdown">
											<option selected="selected">Unknown</option>
											<c:forEach items="${hisLatEthnList}" var="hisLatEthn">
												<option value="${hisLatEthn.getRaceName()}"><c:out value="${hisLatEthn.getRaceName()}"></c:out></option>	
											</c:forEach>
										</select>	
									</c:when>
								</c:choose>
								<c:choose>
									<c:when test="${raceOption.getRaceId() == naHaPaIs}">
										<select id="pacIslEthnDropdown" name="pacIslEthnDropdown">
											<option selected="selected">Unknown</option>
											<c:forEach items="${pacifIslEthnList}" var="pacIslEthn">
												<option value="${pacIslEthn.getRaceName()}"><c:out value="${pacIslEthn.getRaceName()}"></c:out></option>	
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
								<!-- Last option will be checked by default -->
								<input checked type="radio" id="${maritalStatus.getMaritalStatusId()}" name="maritalOptionRadio" value="${maritalStatus.getMaritalStatusId()}">
								<label for="${maritalStatus.getMaritalStatusId()}">${maritalStatus.getMaritalStatus()}</label>
							</div>	
						</c:forEach>
					</fieldset>
					<fieldset>
						<legend>Living arrangement: </legend>	
						<!-- Living arrangement selection -->
						<c:forEach items="${livingArrangementList}" var="living">
							<div>
								<input checked type="radio" id="${living.getArrangementId()}" name="livingOptionRadio" value="${living.getArrangementId()}">
								<label for="${living.getArrangementId()}">${living.getArrangement()}</label>	
							</div>	
						</c:forEach>
					</fieldset>
					<fieldset>
						<legend>Current gender: </legend>
						<!-- Current gender selection -->
						<c:forEach items="${currentGenderList}" var="currentGender">
							<div>
								<input checked type="radio" id="${currentGender.getCurrentGenderId()}" name="currentGenderRadio" value="${currentGender.getCurrentGenderId()}">
								<label for="${currentGender.getCurrentGenderId()}">${currentGender.getCurrentGender()}</label>
							</div>
						</c:forEach>
					</fieldset>
					<fieldset>
						<legend>Sex assigned at birth: </legend>
						<!-- Gender at birth selection -->
						<c:forEach items="${sexAssignedBirthList}" var="sexAssignedBirth">
							<div>
								<input checked type="radio" id="${sexAssignedBirth.getSexAssignedBirthId()}" name="sexAssignedBirthRadio" value="${sexAssignedBirth.getSexAssignedBirthId()}">	
								<label for="${sexAssignedBirth.getSexAssignedBirthId()}">${sexAssignedBirth.getSexAssignedBirth()}</label>
							</div>	
						</c:forEach>
					</fieldset>
					<fieldset>
						<legend>Sexual orientation: </legend>	
						<!-- Sexual orientation selection -->
						<c:forEach items="${sexualOrientationList}" var="sexualOrientation">
							<div>
								<input checked type="radio" id="${sexualOrientation.getSexualOrientationId()}" name="sexualOrientationRadio" value="${sexualOrientation.getSexualOrientationId()}">
								<label for="${sexualOrientation.getSexualOrientationId()}">${sexualOrientation.getSexualOrientation()}</label>
							</div>	
						</c:forEach>
					</fieldset>

					<h3>Medical History</h3>
					<fieldset>
						<legend>Allergies</legend>	
						<!-- genMedProbContainer is the container for dynamically added general nodes. -->
						<div id="allergiesProbContainer"></div>
						<button type="button" id="allergiesAddButton" onclick='allergiesMed.addNode(allergiesProbContainer, true)'>Add</button><div id="addLimitReached"></div>
						<div id="genMedLimitMsg"></div>
					</fieldset>
					<fieldset>
						<legend>Patient condition</legend>	
						<!-- Patient conditions based on HIPAA guidelines -->
						<select id="patientConditionDropdown" name="patientConditionDropdown">
							<option value="undetermined">Undetermined</option>	
							<option value="good">Good</option>	
							<option value="fair">Fair</option>	
							<option value="serious">Serious</option>	
							<option value="critical">Critical</option>	
							<option value="treatedReleased">Treated and released</option>	
							<option value="confirmedDeath">Confirming patient death</option>	
						</select>
					</fieldset>
					<fieldset>
						<!-- Received blood transfusion -->
						<legend>Blood transfusion: </legend>	
						<div>
							<p id="bloodTransError"></p>
							<input type="radio" id="bloodTransfusionYes" name="bloodTransfusionRadio" value="bloodTransfusionYes">	
							<label for="bloodTransfusionYes">Yes</label>
							<input type="radio" id="bloodTransfusionNo" name="bloodTransfusionRadio" value="bloodTransfusionNo">	
							<label for="bloodTransfusionNo">No</label>
							<input checked type="radio" id="bloodTransfusionUnknown" name="bloodTransfusionRadio" value="bloodTransfusionUnknown">	
							<label for="bloodTransfusionUnknown">Do not know</label>
						</div>
					</fieldset>
					<fieldset>
						<!-- Immunizations/diseases -->	
						<legend>Immunizations</legend>
						<div class="horiz-label-then-buttons-row">
							<div class="horiz-label-then-buttons-name"></div>
							<div class="horiz-label-then-buttons-checkbox">Immunized</div>
							<div class="horiz-label-then-buttons-checkbox">Not immunized</div>
							<div class="horiz-label-then-buttons-checkbox">Do not know</div>
						</div>
						<c:forEach items="${diseaseList}" var="disease">
							<div class="horiz-label-then-buttons-row">
								<div class="horiz-label-then-buttons-name">${disease.getDisease()}: </div>
								<input class="horiz-label-then-buttons-checkbox" type="radio" id="${disease.getDiseaseId()}Immun" name="${disease.getDiseaseId()}" value="${disease.getDiseaseId()}Immun">
								<input class="horiz-label-then-buttons-checkbox" type="radio" id="${disease.getDiseaseId()}NoImm" name="${disease.getDiseaseId()}" value="${disease.getDiseaseId()}NoImm">
								<input checked class="horiz-label-then-buttons-checkbox" type="radio" id="${disease.getDiseaseId()}Unknown" name="${disease.getDiseaseId()}" value="${disease.getDiseaseId()}Unknown">
							</div>	
						</c:forEach>
					</fieldset>
					<!--  
					<fieldset>
						<legend>Medical problems and surgical procedures</legend>	
						<!-- genMedProbContainer is the container for dynamically added general nodes. -->
						<!--  
						<label for="genMedProbContainer">General</label>
						<div id="genMedProbContainer"></div>
						<button type="button" id="genMedAddButton" onclick='genMed.addNode(${fn:escapeXml(generalMedicalProblemListJson)}, genMedProbContainer, true)'>Add</button><div id="addLimitReached"></div>
						<div id="genMedLimitMsg"></div>
						<!-- heartMedProbContainer is the container for dynamically added heart-related nodes. -->
						<!--  
						<label for="heartMedProbContainer">Heart-related</label>
						<div id="heartMedProbContainer"></div>
						<button type="button" id="heartMedAddButton" onclick='heartMed.addNode(${fn:escapeXml(heartMedicalProblemListJson)}, heartMedProbContainer, true)'>Add</button><div id="addLimitReached"></div>
						<div id="heartMedLimitMsg"></div>
						<!-- reproductMedProbContainer is the container for dynamically added reproductive nodes. -->
						<!--  
						<label for="reproductMedProbContainer">Reproductive</label>
						<div id="reproductMedProbContainer"></div>
						<button type="button" id="reproductMedAddButton" onclick='reproductMed.addNode(${fn:escapeXml(reproductMedicalProblemListJson)}, reproductMedProbContainer, true)'>Add</button><div id="addLimitReached"></div>
						<div id="reproductMedLimitMsg"></div>
					</fieldset>
					-->
					<!--  
					<fieldset>
						<legend>Other surgical procedures not listed above</legend>
						<input type="text" class="medProbText" name="medProbAreaText" placeholder="Medical problem area:">
						<input type="text" class="medProbText" name="medProbText" placeholder="Medical problem:">
						<input type="text" class="medProbText" name="medProbSurgeryText" placeholder="Surgical procedure:">
						<label for="medProbSurgeryDate">Surgical procedure date: </label>
						<input type="date" class="medProbText" name="medProbSurgeryDate">
					</fieldset>
					-->
					<fieldset>
						<legend>Personal and family history</legend>	
						<div>Is patient adopted?</div>
						<input type="radio" id="isAdoptedYes" name="patientAdopted" value="true">
						<label for="isAdoptedYes">Yes</label><br>
						<input checked type="radio" id="isAdoptedNo" name="patientAdopted" value="false">
						<label for="isAdoptedNo">No</label><br>

						<div>Father:</div>
						<input type="radio" id="fatherAlive" name="patientFather" value="alive">
						<label for="fatherAlive">Alive</label><br>
						<input type="radio" id="fatherDec" name="patientFather" value="deceased">
						<label for="fatherDec">Deceased: </label>
						<input type="hidden" name="fatherDecAge" value="0">
						<select id="fatherDecAge" name="fatherDecAge">
							<option value="under30">Under 30</option>
							<option value="30-40">30-40</option>
							<option value="41-50">41-50</option>
							<option value="51-60">51-60</option>
							<option value="61-70">61-70</option>
							<option value="over70">Over 70</option>
						</select>
						<input type="hidden" name="fatherCauseDeath" value="not applicable">
						<input type="text" id="fatherCauseDeath" name="fatherCauseDeath" placeholder="Cause of death"><br>
						<input checked type="radio" id="fatherNotKnow" name="patientFather" value="unknown">
						<label for="fatherNotKnow">Do not know</label><br>

						<div>Mother:</div>
						<input type="radio" id="motherAlive" name="patientMother" value="alive">
						<label for="motherAlive">Alive</label><br>
						<input type="radio" id="motherDec" name="patientMother" value="deceased">
						<label for="motherDec">Deceased: </label>
						<input type="hidden" name="motherDecAge" value="0">
						<select id="motherDecAge" name="motherDecAge">
							<option value="under30">Under 30</option>
							<option value="30-40">30-40</option>
							<option value="41-50">41-50</option>
							<option value="51-60">51-60</option>
							<option value="61-70">61-70</option>
							<option value="over70">Over 70</option>
						</select>
						<input type="hidden" name="motherCauseDeath" value="not applicable">
						<input type="text" id="motherCauseDeath" name="motherCauseDeath" placeholder="Cause of death"><br>
						<input checked type="radio" id="motherNotKnow" name="patientMother" value="unknown">
						<label for="motherNotKnow">Do not know</label><br>

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
								window.onload=addFamilyCondition(${familyConditionsList})
							</script>
						</div>
					</fieldset>
					<fieldset>
						<legend>Patient Type</legend>	
						<select id="patientTypeDropdown" name="patientTypeDropdown">
							<option value="outpatient">Outpatient</option>
							<option value="inpatient">Inpatient</option>
						</select>
					</fieldset>	
				</div>
				
				<fieldset>
					<legend>HIPAA Identifiers</legend>
					<input type="text" id="licenseNumber" name="licenseNumber" placeholder="License number">
					<input type="text" id="vehicleSerialNumber" name="vehicleSerialNumber" placeholder="Vehicle serial number">
					<input type="text" id="vehiclePlateNumber" name="vehiclePlateNumber" placeholder="Vehicle plate number">
					<input type="text" id="patientUrl" name="patientUrl" placeholder="Patient URL">
					<input type="text" id="deviceSerialNumber" name="deviceSerialNumber" placeholder="Device serial number">
					<input type="text" id="ipAddress" name="ipAddress" placeholder="IP address">
				</fieldset>
				
				<!-- The role is always patient on this form -->
				<fieldset>
					<legend>Role</legend>
					<label>Patient</label>
					<input type="hidden" id="rolePatient" name="rolePatient" value="${patientRole}">
				</fieldset>

				<!-- user.js sets the value of submit to "isPatient" or "isNonPatient" -->
				<div><input id="patientFormSubmitButton" type="submit" value="Submit" /><input type="reset" name="Reset" /></div>
			</form>
		</div>
	</div>
</body>
</html>