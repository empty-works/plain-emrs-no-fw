/**
 * 
 */

function openMedRecordModal(section, dataExample) {
	var medRecModal = document.getElementById("medRecModal");
	var medRecModalData = document.getElementById("medRecModalData");
	
	// Load data based on the section
	if(section === "medRecChiefComplaint") {
		medRecModalData.innerHTML = "<input type=\"text\" id=\"chiefComplaintStatementInput\" name=\"chiefComplaintStatementInput\" value=${medRecordChiefComplaintsLatest.getStatement()}>";	
		medRecModalData.innerHTML = "<input type=\"text\" id=\"chiefComplaintStatementInput\" name=\"chiefComplaintStatementInput\" value=" + dataExample + "}>";	
	}
	
	// Display the modal
 	medRecModal.style.display = "block";
}

// Close the modal
function closeModal() {
	var medRecModal = document.getElementById("medRecModal");
	medRecModal.style.display = "none";
}				
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