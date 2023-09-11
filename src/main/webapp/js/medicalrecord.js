/**
 * 
 */

var currentPatientId;

function openPatientModal(contextPath, patientId) {
	var medRecModal = document.getElementById("medRecModal");
	
	// Display the modal
 	medRecModal.style.display = "block";
	var encodedPatientId = encodeURIComponent(patientId);
	var servletUrl = contextPath + '/UserPatientServlet?userPatientId=' + encodedPatientId;
	console.log("About to fetch JSON...");
	fetch(servletUrl)
		.then(response => response.json())
		.then(patientData => {
			// Process the patient data
			displayPatientData(patientData);
			loadAddChiefComplaintForm(patientData);
		})
		.catch(error => {
			// Handle any error that occurred during the request
			console.error('Error fetching patient data:', error);
		});
}

function displayPatientData(parsedPatientData) {
	// Access the patient data and updated the DOM
	// The way data in the JSON is accessed is simply by using the dot notation to however many layers deep.
	//document.getElementById('patientSidebarId').innerText = parsedPatientData.userPatientId;
	var fullName = parsedPatientData.userPatient.firstName + ' ' + parsedPatientData.userPatient.middleInitial + ' ' + parsedPatientData.userPatient.lastName;
	document.getElementById('patientSidebarName').innerText = fullName;
	/*
	var isActive = "Active Record";
	if(parsedPatientData.medicalRecord.isActive !== true) {
		isActive = "Inactive Record";
	}
	document.getElementById('patientSidebarActive').innerHTML = "<strong>" + isActive + "</strong>";
	*/
	var id = parsedPatientData.userPatientId;
	var patientSidebarId = document.getElementById('patientSidebarId');
	patientSidebarId.classList.remove('active', 'inactive');
	// Patient ID changes color depending on if the medical record is active or not.
	if(parsedPatientData.medicalRecord.isActive === true) {
		patientSidebarId.classList.add('active');
	}
	else {
		patientSidebarId.classList.add('inactive');
	}	
	patientSidebarId.innerText = id;
	/**********Convert to local date***********/
	var dob = parsedPatientData.userPatient.dateOfBirth;
	var parsedDob = new Date(dob.year, dob.month - 1, dob.day);
	var formattedDob = parsedDob.toLocaleDateString(undefined, {
		year: 'numeric',
		month: 'numeric',
		day: 'numeric'
	});
	/*******************************************/
	document.getElementById('patientSidebarDob').innerHTML = formattedDob;
	document.getElementById('patientSidebarAge').innerHTML = calculateAge(formattedDob)
	document.getElementById('patientSidebarType').innerHTML = parsedPatientData.userPatient.type;
	document.getElementById('patientSidebarLangPref').innerHTML = parsedPatientData.userPatient.languagePreference;
	document.getElementById('patientSidebarCondition').innerHTML = parsedPatientData.medicalRecord.patientCondition;
	document.getElementById('patientSidebarTransfusionStatus').innerHTML = parsedPatientData.medicalRecord.bloodTransfusionStatus;
	document.getElementById('patientSidebarCurGen').innerHTML = parsedPatientData.userPatient.currentGender;
	document.getElementById('patientSidebarGenBirth').innerHTML = parsedPatientData.userPatient.genderAtBirth;
	
	/* Patient tab */
	// Allergies
	var allergiesList = parsedPatientData.allergiesList;
	var allergiesUl = document.getElementById('allergyUl');
	for(let i = 0; i < allergiesList.length; i++) {
		const allergy = document.createElement('li');
		allergy.textContent = allergiesList[i].allergyName;
		allergiesUl.appendChild(allergy);
	}
	// Medications	
	var medicationsList = parsedPatientData.medicationList;
	if(!medicationsList || medicationsList.length == 0) {
		const noMed = document.createElement('p');
		noMed.innerText = 'No medication';
		document.getElementById('medicationUl').appendChild(noMed);
	}
	else {
		var medicationsUl = document.getElementById('medicationUl');
		for(let i = 0; i < medicationsList.length; i++) {
			const medication = document.createElement('li');
			medication.textContent = medicationsList[i].medicationName;
			medicationsUl.appendChild(medication);
		}	
	}
	// Immunizations
	var immunizationsList = parsedPatientData.immunizationsList	;
	var immunizationsUl = document.getElementById('immunizationUl');
	for(let i = 0; i < immunizationsList.length; i++) {
		const immunization = document.createElement('li');
		immunization.textContent = immunizationsList[i].immunization;
		immunizationsUl.appendChild(immunization);
	}
	// Family illnesses
	var familyIllnessesList = parsedPatientData.familyIllnessesList;
	if(!familyIllnessesList || familyIllnessesList.length == 0) {
		const noFamIllness = document.createElement('p');
		noFamIllness.innerText = 'No family illness.';
		document.getElementById('familyIllnessUl').appendChild(noFamIllness);
	}
	else {
		var familyIllnessUl = document.getElementById('familyIllnessUl');
		for(let i = 0; i < familyIllnessesList.length; i++) {
			const familyIllness = document.createElement('li');
			var familyIllnessText = familyIllnessesList[i].illness + " ";
			if(familyIllnessesList[i].illnessFather == true) familyIllnessText += "Father";
			if(familyIllnessesList[i].illnessMother == true) familyIllnessText += "Mother";
			if(familyIllnessesList[i].illnessBrothers == true) familyIllnessText += "Brothers";
			if(familyIllnessesList[i].illnessSisters == true) familyIllnessText += "Sisters";
			if(familyIllnessesList[i].illnessSons == true) familyIllnessText += "Sons";
			if(familyIllnessesList[i].illnessDaughters == true) familyIllnessText += "Daughters";
			if(familyIllnessesList[i].illnessGrandparents == true) familyIllnessText += "Grandparents";
			familyIllness.textContent = familyIllnessText;
			familyIllnessUl.appendChild(familyIllness);
		}
	}
	// Surgery-related Problems
	/*
	var surgeriesList = parsedPatientData.surgicalProblemsList;
	if(!surgeriesList || surgeriesList.length == 0) {
		const noSurgery = document.createElement('p');
		noSurgery.innerText = 'No record of surgeries.';
		document.getElementById('surgeryUl').appendChild(noSurgery);
	}
	else {
		var surgeryUl = document.getElementById('surgeryUl');
		for(let i = 0; i < surgeriesList.length; i++) {
			const surgery = document.createElement('li');
			var surgeryText = surgeriesList[i].surgicalProcedure + " " + surgeriesList[i].surgicalProcedureYear;
			surgery.textContent = surgeryText;
			surgeryUl.appendChild(surgery);
		}
	}
	*/
	// Nurse Notes
	var nurseNotesList = parsedPatientData.nurseNotesList;
	if(!nurseNotesList || nurseNotesList.length == 0) {
		const noNurseNote = document.createElement('p');
		noNurseNote.innerText = 'No record of nurse notes.';
		document.getElementById('nurseNoteUl').appendChild(noNurseNote);
	}
	else {
		var nurseNoteUl = document.getElementById('nurseNoteUl');
		for(let i = 0; i < nurseNotesList.length; i++) {
			const nurseNote = document.createElement('li');
			var nurseNoteText = nurseNotesList[i].focus + " || " + nurseNotesList[i].text;
			nurseNote.textContent = nurseNoteText;
			nurseNoteUl.appendChild(nurseNote);
		}
	}
	// Personal Details
	var patientData = parsedPatientData.userPatient;
	if(!patientData) {
		const noPatientData = document.createElement('p');
		noPatientData.innerText = 'No patient data.';
		document.getElementById('personalDetailUl').appendChild(noPatientData);
	}
	else {
		var personalDetailUl = document.getElementById('personalDetailUl');
		const pd1 = document.createElement('li');
		var pdProvider = 'Provider: ' + patientData.provider;
		pd1.textContent = pdProvider;
		personalDetailUl.appendChild(pd1);
		const pd2 = document.createElement('li');
		var pdProviderId = 'Provider ID: ' + patientData.providerId;
		pd2.textContent = pdProviderId;
		personalDetailUl.appendChild(pd2);
		const pd3 = document.createElement('li');
		var pdAddress = 'Address: ' + patientData.streetAddress + " " + patientData.city + " " + patientData.state + " " + patientData.country;
		pd3.textContent = pdAddress;
		personalDetailUl.appendChild(pd3);
		const pd4 = document.createElement('li');
		var pdPhoneNumber = 'Phone number: ' + patientData.phoneNumber;
		pd4.textContent = pdPhoneNumber;
		personalDetailUl.appendChild(pd4);
		const pd5 = document.createElement('li');
		pd5.textContent = 'Facility ID: ' + patientData.facilityId;
		personalDetailUl.appendChild(pd5);
		const pd6 = document.createElement('li');
		pd6.textContent = 'Sexual orientation: ' + patientData.sexualOrientation;
		personalDetailUl.appendChild(pd6);
		const pd7 = document.createElement('li');
		pd7.textContent = 'Marital status: ' + patientData.maritalStatus;
		personalDetailUl.appendChild(pd7);
		const pd8 = document.createElement('li');
		pd8.textContent = 'Living arrangement: ' + patientData.livingArrangement;
		personalDetailUl.appendChild(pd8);
		const pd9 = document.createElement('li');
		pd9.textContent = 'Is adopted: ' + patientData.isAdopted;
		personalDetailUl.appendChild(pd9);
		const pd10 = document.createElement('li');
		pd10.textContent = 'License number: ' + patientData.licenseNumber;
		personalDetailUl.appendChild(pd10);
		const pd11 = document.createElement('li');
		pd11.textContent = 'Vehicle serial number: ' + patientData.vehicleSerialNumber;
		personalDetailUl.appendChild(pd11);
		const pd12 = document.createElement('li');
		pd12.textContent = 'Vehicle plate number: ' + patientData.vehiclePlateNumber;
		personalDetailUl.appendChild(pd12);
		const pd13 = document.createElement('li');
		pd13.textContent = 'URL: ' + patientData.url;
		personalDetailUl.appendChild(pd13);
		const pd14 = document.createElement('li');
		pd14.textContent = 'Device serial number: ' + patientData.deviceSerialNumber;
		personalDetailUl.appendChild(pd14);
		const pd15 = document.createElement('li');
		pd15.textContent = 'IP address: ' + patientData.ipAddress;
		personalDetailUl.appendChild(pd15);
	}
	
	
	// Chief Complaints 
	var chiefComplaintsList = parsedPatientData.chiefComplaintsList;
	var chiefComplaintDiv = document.getElementById('medRecChiefComplaint');
	if(!chiefComplaintsList || chiefComplaintsList.length == 0) {
		const noChiefComplaint = document.createElement('p');
		noChiefComplaint.innerText = 'No record of chief complaints.';
		chiefComplaintDiv.appendChild(noChiefComplaint);
	}
	else {
		for(let i = 0; i < chiefComplaintsList.length; i++) {
			var chiefComplaintButton = document.createElement('button');
			chiefComplaintButton.classList.add("med-record-accordion");
			chiefComplaintButton.innerText = chiefComplaintsList[i].statement;
			chiefComplaintDiv.appendChild(chiefComplaintButton);
			var ccDetails = document.createElement('div');
			ccDetails.setAttribute("id", "medRecPersonalDetails");
			ccDetails.classList.add("med-record-panel");
			chiefComplaintDiv.appendChild(ccDetails);
			
		}
			
		/*
		var chiefComplaintsUl = document.getElementById('chiefComplaintUl');
		for(let i = 0; i < chiefComplaintsList.length; i++) {
			const chiefComplaint = document.createElement('li');
			var chiefComplaintText = chiefComplaintsList[i].chiefComplaintId + " " + chiefComplaintsList[i].statement;	
			chiefComplaint.textContent = chiefComplaintText;
			chiefComplaintsUl.appendChild(chiefComplaint);
		}
		*/
	}
}

function loadAddChiefComplaintForm(parsedPatientData) {
	var addForm = document.getElementById('addChiefComplaintForm');
	var medRecordLabel = document.createElement('label');
	medRecordLabel.innerText = "Medical Record ID: " + parsedPatientData.medicalRecord.medicalRecordId;
	var div0 = document.createElement('div');
	div0.appendChild(medRecordLabel);
	addForm.appendChild(div0);
	var medRecordInput = document.createElement('input');
	medRecordInput.type = 'hidden';
	medRecordInput.id = 'medRecordId';
	medRecordInput.name = 'medRecordId';
	
	// Admissions ID
	medRecordInput.value = parsedPatientData.medicalRecord.medicalRecordId;
	addForm.appendChild(medRecordInput);
	var admissionsIdLabel = document.createElement('label');
	admissionsIdLabel.innerText = "Admissions ID";
	admissionsIdLabel.htmlFor = "admissionsIdInput";
	addForm.appendChild(admissionsIdLabel);
	var admissionsIdInput = document.createElement('input');
	admissionsIdInput.id = "admissionsIdInput";
	admissionsIdInput.name = "admissionsIdInput";
	var div1 = document.createElement('div');
	div1.appendChild(admissionsIdInput);
	addForm.appendChild(div1);
	
	// Statement
	var statementLabel = document.createElement('label');
	statementLabel.innerText = "Statement";
	statementLabel.htmlFor = "statementText";
	addForm.appendChild(statementLabel);
	var statementText = document.createElement('textarea');
	statementText.setAttribute("required", "");
	statementText.id = "statementText";
	statementText.name = "statementText";
	statementText.rows = "2";
	statementText.cols = "50";
	var div2 = document.createElement('div');
	div2.appendChild(statementText);
	addForm.appendChild(div2);
	
	// Current date time is automatically submitted.
	var chiefComplaintDateInput = document.createElement('input');
	chiefComplaintDateInput.type = "hidden";
	chiefComplaintDateInput.id = "chiefComplaintDateInput";
	chiefComplaintDateInput.name = "chiefComplaintDateInput";
	const tz = Intl.DateTimeFormat().resolvedOptions().timeZone;
	fetch("https://worldtimeapi.org/api/timezone/"+tz)
  		.then(response => response.json())
  		.then(data => chiefComplaintDateInput.value = data.datetime);

	// Location of chief complaint
	var locationLabel = document.createElement('label');
	locationLabel.innerText = "Location";
	locationLabel.htmlFor = "locationInput";
	addForm.appendChild(locationLabel);
	var locationInput = document.createElement('textarea');
	locationInput.id = "locationInput";
	locationInput.name = "locationInput";
	locationInput.rows = "1";
	locationInput.cols = "50";
	var div3 = document.createElement('div');
	div3.appendChild(locationInput);
	addForm.appendChild(div3);
	
	// Character of chief complaint
	var characterLabel = document.createElement('label');
	characterLabel.innerText = "Character";
	characterLabel.htmlFor = "characterInput";
	addForm.appendChild(characterLabel);
	var characterInput = document.createElement('textarea');
	characterInput.id = "characterInput";
	characterInput.name = "characterInput";
	characterInput.rows = "1";
	characterInput.cols = "50";
	var div4 = document.createElement('div');
	div4.appendChild(characterInput);
	addForm.appendChild(div4);
	
	// Duration of chief complaint
	var durationLabel = document.createElement('label');
	durationLabel.innerText = "Duration";
	durationLabel.htmlFor = "durationInput";
	addForm.appendChild(durationLabel);
	var durationInput = document.createElement('textarea');
	durationInput.id = "durationInput";
	durationInput.name = "durationInput";
	durationInput.rows = "1";
	durationInput.cols = "50";
	var div5 = document.createElement('div');
	div5.appendChild(durationInput);
	addForm.appendChild(div5);
	
	// Onset of chief complaint
	var onsetLabel = document.createElement('label');
	onsetLabel.innerText = "Onset";
	onsetLabel.htmlFor = "onsetInput";
	addForm.appendChild(onsetLabel);
	var onsetInput = document.createElement('textarea');
	onsetInput.id = "onsetInput";
	onsetInput.name = "onsetInput";
	onsetInput.rows = "1";
	onsetInput.cols = "50";
	var div6 = document.createElement('div');
	div6.appendChild(onsetInput);
	addForm.appendChild(div6);
	
	// Modifying factors
	var modifyingFactorsLabel = document.createElement('label');
	modifyingFactorsLabel.innerText = "Modifying Factors";
	modifyingFactorsLabel.htmlFor = "modifyingFactorsInput";
	addForm.appendChild(modifyingFactorsLabel);
	var modifyingFactorsInput = document.createElement('textarea');
	modifyingFactorsInput.id = "modifyingFactorsInput";
	modifyingFactorsInput.name = "modifyingFactorsInput";
	modifyingFactorsInput.rows = "3";
	modifyingFactorsInput.cols = "50";
	var div7 = document.createElement('div');
	div7.appendChild(modifyingFactorsInput);
	addForm.appendChild(div7);
	
	// Radiation
	var radiationLabel = document.createElement('label');
	radiationLabel.innerText = "Radiation";
	radiationLabel.htmlFor = "radiationInput";
	addForm.appendChild(radiationLabel);
	var radiationInput = document.createElement('textarea');
	radiationInput.id = "radiationInput";
	radiationInput.name = "radiationInput";
	radiationInput.rows = "3";
	radiationInput.cols = "50";
	var div8 = document.createElement('div');
	div8.appendChild(radiationInput);
	addForm.appendChild(div8);
	
	// Temporal pattern
	var temporalPatternLabel = document.createElement('label');
	temporalPatternLabel.innerText = "Temporal Pattern";
	temporalPatternLabel.htmlFor = "temporalPatternInput";
	addForm.appendChild(temporalPatternLabel);
	var temporalPatternInput = document.createElement('textarea');
	temporalPatternInput.id = "temporalPatternInput";
	temporalPatternInput.name = "temporalPatternInput";
	temporalPatternInput.rows = "3";
	temporalPatternInput.cols ="50";
	var div9 = document.createElement('div');
	div9.appendChild(temporalPatternInput);
	addForm.appendChild(div9);
	
	// Severity
	var severityLabel = document.createElement('label');
	severityLabel.innerText = "Severity";
	severityLabel.htmlFor = "severityInput";
	addForm.appendChild(severityLabel);
	var severityInput = document.createElement('textarea');
	severityInput.id = "severityInput";
	severityInput.name = "severityInput";
	severityInput.rows = "1";
	severityInput.cols = "50";
	var div10 = document.createElement('div');
	div10.appendChild(severityInput);
	addForm.appendChild(div10);
	
	// Description
	var descriptionLabel = document.createElement('label');
	descriptionLabel.innerText = "Description";
	descriptionLabel.htmlFor = "descriptionInput";
	addForm.appendChild(descriptionLabel);
	var descriptionInput = document.createElement('textarea');
	descriptionInput.id = "descriptionInput";
	descriptionInput.name = "descriptionInput";
	descriptionInput.rows = "1";
	descriptionInput.cols = "50";
	var div11 = document.createElement('div');
	div11.appendChild(descriptionInput);
	addForm.appendChild(div11);

	// Submit button
	var chiefComplaintFormSubmit = document.createElement('button');
	chiefComplaintFormSubmit.type = "submit";
	chiefComplaintFormSubmit.id = "chiefComplaintFormSubmit";
	chiefComplaintFormSubmit.name = "chiefComplaintFormSubmit";
	chiefComplaintFormSubmit.innerText = "Add chief complaint";
	addForm.appendChild(chiefComplaintFormSubmit);
}

// Handle the submit functionality for the add chief complaints form
document.getElementById('addChiefComplaintForm').addEventListener("submit", function(event) {
	event.preventDefault();
	// Handle the form data
	sendChiefComplaintData();
});

function sendChiefComplaintData() {
	const form = document.getElementById('addChiefComplaintForm');
	const addChiefComplaintFormData = new FormData(form);
	
	fetch("/MedicalRecordAddChiefComplaintServlet", {
		method: "POST",
		body: addChiefComplaintFormData,
	})
		.then(response => {
			if(response.ok) {
				console.log("Data sent successfully.");
				// TODO: update the modal
			} else {
				// TODO: Handle any errors
				console.log("Sending data failed.");
			}
		})
		.catch(error => {
			// TODO: Handle network errors
			console.error("Network error: ", error);
		});
}

function openMedRecordModal(section, ...dataExample) {
	var medRecModal = document.getElementById("medRecModal");
	var medRecModalData = document.getElementById("medRecModalData");
	
	// Clear previous content
  	medRecModalData.innerHTML = "";
	
	var editForm = document.createElement('form');
	editForm.method = 'POST';
	editForm.className = 'modal-form';
	
	// Load data based on the section
	if(section === "medRecChiefComplaint") {
		// Create form element
		editForm.action = 'MedicalRecordEditChiefComplaintServlet';
		// View fields
		var ccViewDiv = document.createElement('div');
		var ccTitle = document.createElement('h2');
		ccTitle.textContent = dataExample[0];	
		ccViewDiv.appendChild(ccTitle);
		ccViewDiv.id = 'medRecChiefComplaint';
		ccViewDiv.class = 'patient-data';
		editForm.appendChild(ccViewDiv);
		// Editable fields
		/*
		let statementInput = document.createElement('input');
		statementInput.type = 'text';
		statementInput.id = 'chiefComplaintStatementInput';
		statementInput.name = 'chiefComplaintStatementInput';
		statementInput.value = dataExample[0];
		editForm.appendChild(statementInput);
		*/	
	}
		
	// Create submit button
	var editSubmitButton = document.createElement('input');
	editSubmitButton.type = 'submit';
	editSubmitButton.value = 'Submit';
	editForm.appendChild(editSubmitButton);
	
	// Append the form to the modal
	medRecModalData.appendChild(editForm);
	
	// Append modal to the second tab
	var secondTab = document.getElementById("secondTab");
	secondTab.appendChild(medRecModal);
	
	// Display the modal
 	medRecModal.style.display = "block";

	// Handle form submission
	/*
	editForm.addEventListener('submit', function(event) {
		event.preventDefault(); // Prevent default form submission
	// Perform any additional actions or AJAX requests here
		if(section === "medRecChiefComplaint") {
			
			console.log(editForm.elements.chiefComplaintStatementInput.value);
		}
		// You can access the form input values using editForm.elements
	});
	*/
}

// Confirmation dialog when closing the modal
document.getElementById('modalCloseButton').addEventListener("click", function () {
	// Display confirmation dialog
	const confirmation = confirm("Are you sure you want to close the patient's profile?");
	
	// Check the user's choice
	if(confirmation) {
		// User clicked OK, close the modal
		closeModal();
	}
});

// Close the modal
function closeModal() {
	clearModalData();
	var medRecModal = document.getElementById("medRecModal");
	medRecModal.style.display = "none";
}				

function clearModalData() {
	document.getElementById('allergyUl').innerText = "";
	document.getElementById('medicationUl').innerText = "";
	document.getElementById('immunizationUl').innerText = "";
	document.getElementById('familyIllnessUl').innerText = "";
}

function calculateAge(dateOfBirth) {
	var currentDate = new Date();
	var dob = new Date(dateOfBirth)
	console.log("currentDate.getFullYear: " + currentDate.getFullYear + " " + "dob.getFullYear: " + dob.getFullYear);
	var yearsDiff = currentDate.getFullYear() - dob.getFullYear();
	var monthsDiff = currentDate.getMonth() - dob.getMonth();
	var daysDiff = currentDate.getDate() - dob.getDate();
	
	// Adjust the age if the current date if before the birth date.
	if (monthsDiff < 0 || monthsDiff === 0 && daysDiff < 0) {
		yearsDiff--;
	}
	
	return yearsDiff; 
}

/*
function changeTab(evt, tabName) {
  // Declare all variables
  var i, medrectabcontent, medrectablinks;

  // Get all elements with class="tabcontent" and hide them
  medrectabcontent = document.getElementsByClassName("medrectabcontent");
  for (i = 0; i < medrectabcontent.length; i++) {
    medrectabcontent[i].style.display = "none";
  }

  // Get all elements with class="tablinks" and remove the class "active"
  medrectablinks = document.getElementsByClassName("medrectablinks");
  for (i = 0; i < medrectablinks.length; i++) {
    medrectablinks[i].className = medrectablinks[i].className.replace(" active", "");
  }

  // Show the current tab, and add an "active" class to the button that opened the tab
  document.getElementById(tabName).style.display = "block";
  evt.currentTarget.className += " active";
}
*/ 

/*
// Get the modal
var modal = document.getElementById("vitalsEditModal");

// Get the button that opens the modal
var btn = document.getElementById("vitalsEditButton");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("vitalsEditSpan")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}


//##################### Cancel button functionality to go back to the patient's page. ################################
var editPatientCancelButtonTop = document.getElementById("editPatientCancelButtonTop");
var editPatientCancelButtonBottom = document.getElementById("editPatientCancelButtonBottom");

function cancelButtonClickHandler() {
	if (confirm("Are you sure you want to cancel editing and return to the patient's page?")) {
		window.location.href="/WEB-INF/MedicalRecordLatestChiefComplaint.jsp";
	}
}

// Assign the event handler to both cancel buttons.
editPatientCancelButtonTop.addEventListener("click", cancelButtonClickHandler());
editPatientCancelButtonBottom.addEventListener("click", cancelButtonClickHandler());
*/