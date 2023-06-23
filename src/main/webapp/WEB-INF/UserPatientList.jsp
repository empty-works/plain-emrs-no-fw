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

<script src="${pageContext.request.contextPath}/js/medicalrecord.js"></script>

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
						<td><a href="#" onclick="openPatientModal()">${patient.getUserId()}</a></td>
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getFirstName()}</a></td>
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getMiddleInitial()}</a></td>
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getLastName()}</a></td>
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getDateOfBirth()}</a></td>
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getType()}</a></td>
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getGenderAtBirth()}</a></td>	
						<td><a href="${pageContext.request.contextPath}/UserPatientServlet?userPatientId=${patient.getUserId()}">${patient.getLanguagePreference()}</a></td>	
					</tr>
				</c:forEach>
			</table>
			</form>
			<div id="patient-list-grid-con">
			</div>
			
			<!-- !!!!!!!!!!!!!!!!!!!!!!!!!MODAL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
			<div id="medRecModal" class="modal">
			  <div class="modal-content">
				<span class="close" onclick="closeModal()">&times;</span>
				<div id="medRecModalData">
					<div class="container">	
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
										<fieldset>
											<legend class="patient-header">Personal Overview</legend>
											<div id="medRecPersonalOverview" class="patient-data">
												<div>
													<div>${userPatientId}</div>
													<div>${patientType}</div>
												</div>
												<div>
													<div>${userPatientFirstName} ${userPatientMiddleInitial} ${userPatientLastName}</div>
													<div>${patientLanguagePreference}</div>
												</div>
												<div>
													<div>${userDateOfBirth}</div>
												</div>
											</div>
										</fieldset>
										<fieldset>
											<legend class="patient-header">Medical Record Overview</legend>	
											<div id="medRecOverview" class="patient-data">
												<div>
													<label for="medRecordId">Medical Record ID:</label>
													<div id="medRecordId">${medicalRecordId}</div>	
													<label for="medRecordCond">Medical Record Condition:</label>
													<div id="medRecordCond">${medRecordPatientCondition}</div>
													<label for="medRecordCreated">Medical Record Created:</label>
												</div>	
												<div>
													<div id="medRecordCreated">${medRecordCreated}</div>
													<label for="medRecordActive">Medical Record Active:</label>
													<div id="medRecordActive">${medRecordIsActive}</div>
													<label for="medRecordBloodTransfusion">Blood Transfusion Status:</label>
													<div id="medRecordBloodTransfusion">${medRecordBloodTransfusionStatus}</div>
												</div>
											</div>
										</fieldset>
										<fieldset>
											<legend class="patient-header">Allergies</legend>							
											<div id="medRecAllergies" class="patient-data">
												<p>
												<c:choose>
												<c:when test="empty ${medRecordAllergiesList}">
													No allergies
												</c:when>
												<c:otherwise>
													<c:forEach items="${medRecordAllergiesList}" var="allergy">
														${allergy.getAllergyName()}, 
													</c:forEach>	
												</c:otherwise>
												</c:choose>
												</p>
											</div>
										</fieldset>
										<fieldset>
											<legend class="patient-header">Medication</legend>							
											<div id="medRecMedication" class="patient-data">
												<p>
												<c:choose>
													<c:when test="${empty medRecordMedicationList}">
														No medication
													</c:when>
													<c:otherwise>
														<c:forEach items="${medRecordMedicationList}" var="medication">
															${medication.getMedicationName()}, 
														</c:forEach>
													</c:otherwise>
												</c:choose>
												</p>
											</div>
										</fieldset>
										<button class="med-record-accordion">Illnesses</button>
										<div id="medRecIllnesses" class="med-record-panel">
											<p>
											<c:choose>
											<c:when test="${empty medRecordIllnessesList}">
												No illnesses
											</c:when>
											<c:otherwise>
												<c:forEach items="${medRecordIllnessesList}" var="illness">
													${illness.getIllness()}, 		
												</c:forEach>
											</c:otherwise>
											</c:choose>
											</p>
										</div>
										<button class="med-record-accordion">Diseases</button>
										<div id="medRecDiseases" class="med-record-panel">
											<p>
											<c:choose>
											<c:when test="${empty medRecordDiseasesList}">
												No diseases	
											</c:when>	
											<c:otherwise>
												<c:forEach items="${medRecordDiseasesList}" var="disease">
													${disease.getDisease()}, 
												</c:forEach>	
											</c:otherwise>
											</c:choose>
											</p>
										</div>
										<button class="med-record-accordion">Surgery-related problems</button>
										<div id="medRecSurgProbs" class="med-record-panel">
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
										<button class="med-record-accordion">Nurse notes</button>
										<div id="medRecNurseNotes" class="med-record-panel">
											<p>
											<c:choose>
											<c:when test="${empty medRecordNurseNotesList}">
												No nurse notes
											</c:when>	
											<c:otherwise>
												<c:forEach items="${medRecordNurseNotesList}" var="nurseNote">
													<div>- ${nurseNote.getText()}</div>	
												</c:forEach>	
											</c:otherwise>
											</c:choose>
											</p>
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
							<div><a href="${pageContext.request.contextPath}/MedicalRecordAddChiefComplaintServlet?userPatientId=${userPatientId}">Add Chief Complaint</a></div>
						</c:if>
							<ul class="encounter-list">
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
							
							<fieldset>
								<legend class="patient-header">Vitals ${medRecordVitals.getDateTaken()}</legend>							
								<!-- Vitals edit link -->
								<button id="vitalsEditButton" class="edit-link">Edit</button>
								<!-- Vitals edit modal -->
								<div id="vitalsEditModal" class="med-rec-modal">
									<div class="vitals-edit-modal-content">
										<span id="vitalsEditSpan" class="close-med-rec-modal">&times;</span>
										<p>Vitals modal...</p>
									</div>	
								</div>
								<div id="medRecVitals" class="patient-data">
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
						</div>
					</div>
							</div>
						  </div>
			</div>
		</div>
	</div>
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
		}
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