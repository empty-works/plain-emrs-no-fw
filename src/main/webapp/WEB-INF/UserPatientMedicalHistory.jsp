<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Medical Record</title>
</head>
<body>
	
	<!-- Calls script to place top bar instead of copy/pasting top bar code. Can easily make changes. -->
	<script id="replace_with_topbar" src="${pageContext.request.contextPath}/js/topbar.js"></script>
	
	<div class="main-container">
		<!-- Side main menu -->
		<div class="side-main-menu">
			<script id="replace_with_sidemainmenu" src="${pageContext.request.contextPath}/js/adminsidemainmenu.js"></script>	
		</div>
		<!-- Side navigation -->
		<div class="sidenav main-font">
			<script id="replace_with_sidenav" src="${pageContext.request.contextPath}/js/patientssidenav.js"></script>
		</div>
		
		<div class="main-grid-container">
			<div class="main-grid">
				<fieldset>
					<legend class="patient-header">Overview</legend>	
					<div class="patient-data">
						<div>
							<div>${medicalRecordId}</div>	
							<div>${medRecordPatientCondition}</div>
							<div>${medRecordCreated}</div>
							<div>${medRecordIsActive}</div>
							<div>${medRecordBloodTransfusionStatus}</div>
						</div>	
					</div>
				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>