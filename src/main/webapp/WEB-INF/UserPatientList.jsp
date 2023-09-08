<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidenav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/topnav.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-setup.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-content-grid.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/patients.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/medical-record.css" />

<title>Patient List</title>
</head>
<body>
	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>
	
	<div class="main-container">
		<!-- Side main menu -->
		<div class="side-main-menu">
			<script id="replace_with_sidemainmenu" src="${pageContext.request.contextPath}/js/adminsidemainmenu.js"></script>	
		</div>

		<div class="main-grid-container">
			<h3>PATIENT LIST</h3>

			<!-- Can only add patient if an admin -->
			<c:if test = "${sessionScope.rolePair.getRoleDb() == 'ROLE_ADMIN'}">
				<div><a href="<c:url value="/AddUserPatientServlet" />">Add Patient</a></div>
			</c:if>

			<form class="content-padding" action="UserPatientServlet" method="post" enctype="multipart/form-data">
			<table> <!-- Global table styling handled in general -->
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>M.I.</th>
					<th>Last Name</th>
					<th>Date of Birth</th>
					<th>Type</th>
					<th>Birth Gender</th>
					<th>Language Preference</th>
				</tr>
				<c:forEach items="${patientSublist}" var="patient" >
					<tr id="list-link">
						<!--  <td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}" onclick="">${patient.getUserId()}</a></td>-->
						<td><a href="#" onclick="openPatientModal('${pageContext.request.contextPath}', '${patient.getUserId()}')">${patient.getUserId()}</a></td>
						<td><a href="#" onclick="openPatientModal('${pageContext.request.contextPath}', '${patient.getUserId()}')">${patient.getFirstName()}</a></td>
						<td><a href="#" onclick="openPatientModal()">${patient.getMiddleInitial()}</a></td>
						<td><a href="#" onclick="openPatientModal()">${patient.getLastName()}</a></td>
						<td><a href="#" onclick="openPatientModal()">${patient.getDateOfBirth()}</a></td>
						<td><a href="#" onclick="openPatientModal()">${patient.getType()}</a></td>
						<td><a href="#" onclick="openPatientModal()">${patient.getGenderAtBirth()}</a></td>	
						<td><a href="#" onclick="openPatientModal()">${patient.getLanguagePreference()}</a></td>	
					</tr>
				</c:forEach>
			</table>
			</form>
			<div id="patient-list-grid-con">
			</div>
			
			<!-- !!!!!!!!!!!!!!!!!!!!!!!!!MODAL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
			<div id="medRecModal" class="modal">
			  <div class="modal-content">
					<div id="patientSidebar">
						<!-- Patient sidebar -->	
						<div class="patient-profile">
							<c:choose>
								<c:when test="${patient.getCurrentGender() == 'female'}">
									<img src="images/default_female_img.jpg"	alt="Female Image" class="patient-picture">
								</c:when>
								<c:when test="${patient.getCurrentGender() == 'male'}">
									<img src="images/default_male_img.jpg"	alt="Male Image" class="patient-picture">
								</c:when>
								<c:otherwise>
									<img src="images/default_nb_img.jpg"	alt="NB Image" class="patient-picture">
								</c:otherwise>
							</c:choose>

							<h4 id="patientSidebarName" class="patient-name"></h4>
							<!--  <p id="patientSidebarActive" class="patient-sidebar-text"></p>-->
							<div id="patientSidebarId" class="patient-sidebar-text"></div>
							<div class="patient-info">
								<div class="label">Current gender: </div>
								<div id="patientSidebarCurGen" class="value"></div>
								<div class="label">Gender at birth:</div>
								<div id="patientSidebarGenBirth" class="value"></div>
								<div class="label">Date of birth:</div>
								<div id="patientSidebarDob" class="value"></div>
								<div class="label">Age:</div>
								<div id="patientSidebarAge" class="value"></div>
								<div class="label">Type:</div>
								<div id="patientSidebarType" class="value"></div>
								<div class="label">Condition:</div>
								<div id="patientSidebarCondition" class="value"></div>
								<div class="label">Blood transfusion:</div>
								<div id="patientSidebarTransfusionStatus" class="value"></div>
								<div class="label">Language preference:</div>
								<div id="patientSidebarLangPref" class="value"></div>
							</div>
						</div>
					</div>
					<div id="tabsContainer">	
						<div>
							<button class="tab active" onclick="changeTab(0)">Patient record</button>
							<button class="tab" onclick="changeTab(1)">Encounters</button>	
						</div>
						<div class="tab-content active">
								<div>
									<a href="<c:url value="/MedicalRecordEditPatientServlet" />">Edit Patient</a>
									<a class="topnav-user"><%=session.getAttribute("userId") %></a>	
								</div>
								<div>
									<fieldset class="modal-fieldset">
										<legend class="modal-legend">Allergies</legend>							
										<div id="medRecAllergies" class="modal-fieldset-content">
											<ul id="allergyUl"><!-- Populated in medicalrecord.js --></ul>
										<!--  
											<p>
											<c:choose>
											<c:when test="${empty medRecordAllergiesList}">
												No allergies
											</c:when>
											<c:otherwise>
												<c:forEach items="${medRecordAllergiesList}" var="allergy">
													${allergy.getAllergyName()}, 
												</c:forEach>	
											</c:otherwise>
											</c:choose>
											</p>
										-->
										</div>
									</fieldset>
									<fieldset class="modal-fieldset">
										<legend class="modal-legend">Medications</legend>							
										<div id="medRecMedication" class="modal-fieldset-content">
											<ul id="medicationUl"><!-- Populated in medicalrecord.js --></ul>
										</div>
									</fieldset>
									<button class="med-record-accordion">Immunizations</button>
									<div id="medRecImmunizations" class="med-record-panel">
										<ul id="immunizationUl"><!-- Populated in medicalrecord.js --></ul>
									</div>
									<button class="med-record-accordion">Family Illnesses</button>
									<div id="medRecFamilyIllnesses" class="med-record-panel">
										<ul id="familyIllnessUl"><!-- Populated in medicalrecord.js --></ul>
									</div>
									<!-- 
									<button class="med-record-accordion">Surgery-related problems</button>
									<div id="medRecSurgProbs" class="med-record-panel">
										<ul id="surgeryUl"></ul>
										<p>
										<c:choose>
										<c:when test="${empty medRecordSurgicalProblemsList}">
											No surgical history	
										</c:when>	
										<c:otherwise>
											<c:forEach items="${medRecordSurgicalProblemsList}" var="surgery">
												<div>
													Problem: ${surgery.getSurgicalRelatedProblem()}<br /> 
													Problem area: ${surgery.getProblemArea()}<br />
													Procedure: ${surgery.getSurgicalProcedure()}<br />
													Procedure year: ${surgery.getSurgicalProcedure()}<br />
												</div>
											</c:forEach>	
										</c:otherwise>
										</c:choose>	
										</p>
									</div>
									 -->
									<button class="med-record-accordion">Nurse notes</button>
									<div id="medRecNurseNotes" class="med-record-panel">
										<ul id="nurseNoteUl"><!-- Populated in medicalrecord.js --></ul>
									</div>
									<button class="med-record-accordion">Personal details</button>
									<div id="medRecPersonalDetails" class="med-record-panel">
										<ul id="personalDetailUl"><!-- Populated in medicalrecord.js --></ul>
										<!-- 
										<p>
										<c:choose>
										<c:when test="">
											
										</c:when>	
										</c:choose>
										</p>	
										 -->
									</div>
									
									<!-- MODAL -->
									<div id="medRecModal" class="modal">
									  <div class="modal-content">
										<span class="close" onclick="closeModal()">&times;</span>
										<div id="medRecModalData"></div>
									  </div>
									</div>
								</div>
						</div>

						<div id="secondTab" class="tab-content">

							<c:if test = "${sessionScope.rolePair.getRoleDb() == 'ROLE_ADMIN'}">
								<button id="addChiefComplaintButton">Add a chief complaint</button>
								<!--  <div><a href="${pageContext.request.contextPath}/MedicalRecordAddChiefComplaintServlet?userPatientId=${userPatientId}">Add Chief Complaint</a></div>-->
							</c:if>
							<div id="medRecChiefComplaint" class="modal-fieldset-content">
								<!-- Inside medicalrecord.js -->	
							</div>
							<button id="backToChiefComplaintsList">Back to chief complaints</button>
							<form id="addChiefComplaintForm" style="display: none;">
								<!-- Inside medicalrecord.js -->
							</form>
							<!--  
							<fieldset class="modal-fieldset">
								<legend class="modal-legend">Chief Complaints</legend>							
								<div id="medRecChiefComplaint" class="modal-fieldset-content">
									<ul id="chiefComplaintUl"></ul>
								</div>
							</fieldset>
							-->
								<!-- 
							<ul id="chiefComplaintUl" class="encounter-list">
								<c:choose>
								<c:when test="${empty medRecordChiefComplaintsList}">
									<p>No encounters/chief complaints</p>	
								</c:when>
								<c:otherwise>
								  <c:forEach items="${medRecordChiefComplaintsList}" var="encounter" varStatus="status">
									<li class="encounter-item">
										  <a href="#" onclick="openMedRecordModal('medRecChiefComplaint', '${encounter.getStatement()}')">
											<div class="encounter-title">${encounter.getStatement()}</div>
											<div class="encounter-date">${medRecordVitals.getDateTaken()}</div>
										  </a>
									</li>
								  </c:forEach>
								</c:otherwise>
								</c:choose>
							</ul>
							
 								-->
 							<!-- 
							<fieldset class="modal-fieldset">
								<legend class="modal-legend">Vitals ${medRecordVitals.getDateTaken()}</legend>							
								<button id="vitalsEditButton" class="edit-link">Edit</button>
								<div id="vitalsEditModal" class="med-rec-modal">
									<div class="vitals-edit-modal-content">
										<span id="vitalsEditSpan" class="close-med-rec-modal">&times;</span>
										<p>Vitals modal...</p>
									</div>	
								</div>
								<div id="medRecVitals" class="modal-fieldset-content">
									<div>
										<div>Height: ${medRecordVitals.getHeight()}</div>
										<div>Temperature: ${medRecordVitals.getTemperature()}</div>
										<div>Blood pressure systolic / diastolic: ${medRecordVitals.getBloodPressureSystolic()} / ${medRecordVitals.getBloodPressureDiastolic()}</div>
									</div>
									<div>
										<div>Weight: ${medRecordVitals.getWeight()}</div>
										<div>Pulse: ${medRecordVitals.getPulse()}</div>
										<div>Arterial blood oxygen saturation: ${medRecordVitals.getArterialBloodOxygenSaturation()}</div>
									</div>
									<div>
										<div>Calculated BMI: ${medRecordVitals.getCalculatedBmi()}</div>
										<div>Respiratory rate: ${medRecordVitals.getRespiratoryRate()}</div>
									</div>
								</div>
							</fieldset>
 							-->
 							<!-- 
							<button class="med-record-accordion">Review of systems</button>
							<div id="medRecRos" class="med-record-panel">
								<p>
								<c:choose>
								<c:when test="${empty medRecordRosLatest}">
									No review of systems
								</c:when>
								<c:otherwise>
									<div>
										Date recorded: ${medRecordRosLatest.getDate()}<br />
										Constitutional symptoms: ${medRecordRosLatest.getConstitutionalSymptoms()}<br />
										Eyes: ${medRecordRosLatest.getEyes()}<br />
										Ears, nose, throat: ${medRecordRosLatest.getEarsNoseThroat()}<br />
										Cardiovascular: ${medRecordRosLatest.getCardiovascular()}<br />
										Respiratory: ${medRecordRosLatest.getRespiratory()}<br />
										Gastrointestinal: ${medRecordRosLatest.getGastrointestinal()}<br />
										Genitournary: ${medRecordRosLatest.getGenitournary()}<br />
										Musculoskeletal: ${medRecordRosLatest.getMusculoskeletal()}<br />
										Integumentary: ${medRecordRosLatest.getIntegumentary()}<br />
										Neurological: ${medRecordRosLatest.getNeurological()}<br />
										Psychiatric: ${medRecordRosLatest.getPsychiatric()}<br />
										Endocrine: ${medRecordRosLatest.getEndocrine()}<br />
										Hematologic lymphatic: ${medRecordRosLatest.getHematologicLymphatic()}<br />
										Allergic immunologic: ${medRecordRosLatest.getAllergicImmunologic()}<br />
									</div>
								</c:otherwise>
								</c:choose>
								</p>
							</div>
 							-->
						</div>
					</div>
					</div>
				<span class="close" id="modalCloseButton" onclick="closeModal()">&times;</span>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/js/medicalrecord.js"></script>
	<!-- Script taken from w3schools HowTO - Collapsibles/Accordion -->
	<script>
		var acc = document.getElementsByClassName("med-record-accordion");
		var i;

		for (i = 0; i < acc.length; i++) {
		  acc[i].addEventListener("click", function() {
			this.classList.toggle("active");
			var panel = this.nextElementSibling;
			if (panel.style.maxHeight) {
			  panel.style.maxHeight = null;
			} else {
			  panel.style.maxHeight = panel.scrollHeight + "px";
			} 
		  });

		  // Keep the accordion panels closed by default
		  var panel = acc[i].nextElementSibling;
		  panel.style.maxHeight = null;
		}
		
		// Toggle between the chief complaints list and add chief complaint form
		const chiefComplaintsList = document.getElementById("medRecChiefComplaint");
		const addChiefComplaintsForm = document.getElementById("addChiefComplaintForm");
		
		
		function changeTab(index) {
			  // Get all tab buttons and tab contents
			  var tabButtons = document.getElementsByClassName("tab");
			  var tabContents = document.getElementsByClassName("tab-content");

			  // Remove "active" class from all tab buttons and tab contents
			  for (var i = 0; i < tabButtons.length; i++) {
			    tabButtons[i].classList.remove("active");
			    tabContents[i].classList.remove("active");
			  }

			  // Add "active" class to the selected tab button and tab content
			  tabButtons[index].classList.add("active");
			  tabContents[index].classList.add("active");
		}

	</script>
</body>
</html>