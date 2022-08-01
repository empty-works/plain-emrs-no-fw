/**
 * 
 */

let roleDropdown = document.getElementById('role-dropdown');

function showPatientForm() {
	const patientTitle = document.getElementById("patientTitle");
	const nonpatientTitle = document.getElementById("nonpatientTitle");
	const patientSection = document.getElementById("patientSection");
	const nonpatientSection = document.getElementById("nonpatientSection");
	const addUserForm = document.getElementById("addUserForm");

	addUserForm.style.display = "block";
	patientTitle.style.display = "block";
	patientSection.style.display = "block";
	nonpatientTitle.style.display = "none";
	nonpatientSection.style.display = "none";
}

function showNonpatientForm() {
	const patientTitle = document.getElementById("patientTitle");
	const nonpatientTitle = document.getElementById("nonpatientTitle");
	const patientSection = document.getElementById("patientSection");
	const nonpatientSection = document.getElementById("nonpatientSection");
	const addUserForm = document.getElementById("addUserForm");

	addUserForm.style.display = "block";
	patientTitle.style.display = "none";
	patientSection.style.display = "none";
	nonpatientTitle.style.display = "block";
	nonpatientSection.style.display = "block";
}

	let select = document.getElementById("genMedProbDropdown");
	let fakeList = ['A', 'B', 'C'];
	for(var i = 0; i < fakeList.length; i++) {
		var element = document.createElement("option");
		element.textContent = "YO";
		element.value = "HEY";
		select.appendChild(element);
	}
function addMedProblem(jsonList) {
	
	let medProbList = JSON.parse(jsonList);
	let select = document.getElementById("genMedProbDropdown");
	let fakeList = ['A', 'B', 'C'];
	for(var i = 0; i < fakeList.length; i++) {
		var element = document.createElement("option");
		element.textContent = "YO";
		element.value = "HEY";
		select.appendChild(element);
	}
	// Get the container first.
	/*
	const medProbContainer = document.getElementById("genMedProbContainer");
	let medProbHtml = "<div class=\"genMedProbNode\">" + 
							"<label for=\"genMedProbDropdown\">Problem area: </label>" + 
							"<select id=\"genMedProbDropdown\" name=\"genMedProbDropdown\">" + 
							"<c:forEach items=\"${generalMedicalProblemList}\" var=\"genMedProb\">" + 
							"<option>${genMedProb.getProblemArea()}</option>" + 
							"</c:forEach></select>" + 
							"<label for=\"genMedProbText\">Medical problem: </label>" + 
							"<input type=\"text\" class=\"genMedProbText\" name=\"genMedProbText\">" + 
							"<label for=\"genMedProbSurgeryText\">Surgical procedure: </label>" + 
							"<input type=\"text\" class=\"genMedProbSurgeryText\" name=\"genMedProbSurgeryText\">" + 
							"<label for=\"genMedProbSurgeryDate\">Surgical procedure date: </label>" + 
							"<input type=\"date\" class=\"genMedProbSurgeryDate\" name=\"genMedProbSurgeryDate\"></div>";
	medProbContainer.insertAdjacentHTML("beforeend", medProbHtml);
	*/
	/*
	const medProbDivNode = document.createElement("div");
	const medProbBlockNode = document.getElementById("genMedProbNode");
	medProbDivNode.appendChild(medProbBlockNode);
	medProbContainer.appendChild(medProbDivNode);
	*/
}
