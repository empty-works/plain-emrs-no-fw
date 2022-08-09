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
		let dropDown = document.createElement("select");
		let medProbList = [];
		for(let x in jsonList) {
			medProbList.push(x, jsonList[x]);
		}
		medProbList.sort();
		for(let x in medProbList) {
			//let option = jsonList[i];
			//console.log(option);
			console.log(medProbList[x]);
			let element = medProbList[x];
			let option = document.createElement("option");
			option.textContent = element;
			option.value = element; 
			dropDown.appendChild(option);
		}
		let areaText = document.createTextNode("Problem area: ");
		let medProbText = document.createTextNode(" Medical problem: ");
		let medProbInput = document.createElement("input");
		let surgProced = document.createTextNode(" Surgical procedure: ");
		let surgProcedInput = document.createElement("input");
		let surgDateText = document.createTextNode(" Surgical procedure date: ")
		let surgDate = document.createElement("input");
		surgDate.setAttribute("type", "date");
		medProbNode.appendChild(areaText);
		medProbNode.appendChild(dropDown);
		medProbNode.appendChild(medProbText);
		medProbNode.appendChild(medProbInput);
		medProbNode.appendChild(surgProced);
		medProbNode.appendChild(surgProcedInput);
		medProbNode.appendChild(surgDateText);
		medProbNode.appendChild(surgDate);
		medProbContainer.appendChild(medProbNode);
	}
	else {
		const limitMsg = document.getElementById("addLimitReached");
		let text = "Cannot add more!";
		limitMsg.insertAdjacentText("beforebegin", text);
	}
}
