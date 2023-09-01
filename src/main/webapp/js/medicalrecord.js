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
	// Chief Complaints 
	var chiefComplaintsList = parsedPatientData.chiefComplaintsList;
	if(!chiefComplaintsList || chiefComplaintsList.length == 0) {
		const noChiefComplaint = document.createElement('p');
		noChiefComplaint.innerText = 'No record of chief complaints.';
		document.getElementById('chiefComplaintUl').appendChild(noChiefComplaint);
	}
	else {
		var chiefComplaintsUl = document.getElementById('chiefComplaintUl');
		for(let i = 0; i < chiefComplaintsList.length; i++) {
			const chiefComplaint = document.createElement('li');
			var chiefComplaintText = chiefComplaintsList[i].chiefComplaintId + " " + chiefComplaintsList[i].statement;	
			chiefComplaint.textContent = chiefComplaintText;
			chiefComplaintsUl.appendChild(chiefComplaint);
		}
	}
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