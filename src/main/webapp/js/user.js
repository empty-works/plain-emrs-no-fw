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

let medProbLimit = 0;
MED_PROB_MAX = 15;
function addMedProblem(jsonList) {
	medProbLimit++;
	if(medProbLimit < MED_PROB_MAX) {
		console.log(jsonList);
		let medProbContainer = document.getElementById("genMedProbContainer");
		let medProbNode = document.createElement("div");
		// Set ID of node 
		medProbNode.setAttribute("id", "NodeNum" + randomId());
		let genMedProbDropDown = document.createElement("select");
		let medProbList = [];
		// Push JSON elements to a JS list
		for(let x in jsonList) {
			medProbList.push(x, jsonList[x]);
		}
		// Sort the JS list
		medProbList.sort();
		// Then add the sorted list elements to a dropdown menu
		for(let x in medProbList) {
			console.log(medProbList[x]);
			let element = medProbList[x];
			let option = document.createElement("option");
			option.textContent = element;
			option.value = element; 
			genMedProbDropDown.appendChild(option);
		}
		// Add a remove button
		let removeButton = document.createElement("button");
		let removeButtonText = document.createTextNode("-");
		removeButton.appendChild(removeButtonText);
		// Add the rest of the medical problem inputs to the node
		let medProbHtml = 
		"<input type=\"text\" class=\"gen-med-prob-text\" name=\"addGenMedProbText\" placeholder=\"Medical problem:\">" + 
		"<input type=\"text\" class=\"gen-med-prob-text\" name=\"addGenMedProbSurgeryText\" placeholder=\"Surgical procedure:\">" + 
		"<label class=\"gen-med-prob-text\" for=\"genMedProbSurgeryDate\">Surgical procedure date: </label>" + 
		"<input type=\"date\" class=\"genMedProbSurgeryDate\" name=\"genMedProbSurgeryDate\">" + 
		"<button type=\"button\" onclick=\"removeMedProbNode(this)\">-</button>";
		medProbNode.appendChild(genMedProbDropDown);
		medProbNode.insertAdjacentHTML("beforeend", medProbHtml);
		medProbNode.appendChild(removeButton);
		medProbContainer.appendChild(medProbNode);
	}
	else {
		const limitMsg = document.getElementById("addLimitReached");
		let text = "Cannot add more!";
		// TODO: WORK IN PROGRESS
		if(!limitMsg.innerText.includes(text)) {
			limitMsg.insertAdjacentText("beforebegin", text);
		}
	}
}

function randomId() {
	return Math.floor(Math.random() * (9999-1000 + 1) + 1000);
}

function removeMedProbNode(medProbNode) {
	medProbNode.parentElement.remove();		
}
