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

function addMedProblem(jsonList, medProbCon) {
	
	let node = new MedProbAdder(jsonList, medProbCon);
	node.addNode();
	/*
	if(medProbLimit < MED_PROB_MAX) {
		medProbLimit++;
		console.log(jsonList);
		let medProbContainer = medProbCon;
		let medProbNode = document.createElement("div");
		let medProbDropDown = document.createElement("select");
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
			medProbDropDown.appendChild(option);
		}
		// Add the rest of the medical problem inputs to the node
		let medProbHtml = 
		"<input type=\"text\" class=\"med-prob-text\" name=\"medProbText\" placeholder=\"Medical problem:\">" + 
		"<input type=\"text\" class=\"med-prob-text\" name=\"medProbSurgeryText\" placeholder=\"Surgical procedure:\">" + 
		"<label class=\"med-prob-text\" for=\"medProbSurgeryDate\">Surgical procedure date: </label>" + 
		"<input type=\"date\" class=\"medProbSurgeryDate\" name=\"medProbSurgeryDate\">" + 
		"<button type=\"button\" onclick=\"removeMedProbNode(this)\">-</button>";
		medProbNode.appendChild(medProbDropDown);
		medProbNode.insertAdjacentHTML("beforeend", medProbHtml);
		medProbContainer.appendChild(medProbNode);
	}
	else {
		const limitMsg = document.getElementById("addLimitReached");
		let text = "Cannot add more!";
		// Clear any text
		limitMsg.innerHTML = "";
		limitMsg.innerHTML = text;
	}
	*/
}

class MedProbAdder {
	constructor(jsonList, medProbCon) {
		this.jsonList = jsonList;
		this.medProbCon = medProbCon;
		this.medProbLimit = 0;
		this.MED_PROB_MAX = 15;
	}
	
	addNode() {
		if(this.medProbLimit < this.MED_PROB_MAX) {
			this.medProbLimit++;
			console.log(this.jsonList);
			let medProbContainer = this.medProbCon;
			let medProbNode = document.createElement("div");
			let medProbDropDown = document.createElement("select");
			let medProbList = [];
			// Push JSON elements to a JS list
			for(let x in this.jsonList) {
				medProbList.push(x, this.jsonList[x]);
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
				medProbDropDown.appendChild(option);
			}
			// Add the rest of the medical problem inputs to the node
			let medProbHtml = 
			"<input type=\"text\" class=\"med-prob-text\" name=\"medProbText\" placeholder=\"Medical problem:\">" + 
			"<input type=\"text\" class=\"med-prob-text\" name=\"medProbSurgeryText\" placeholder=\"Surgical procedure:\">" + 
			"<label class=\"med-prob-text\" for=\"medProbSurgeryDate\">Surgical procedure date: </label>" + 
			"<input type=\"date\" class=\"medProbSurgeryDate\" name=\"medProbSurgeryDate\">" + 
			"<button type=\"button\" onclick=\"removeMedProbNode(this)\">-</button>";
			medProbNode.appendChild(medProbDropDown);
			medProbNode.insertAdjacentHTML("beforeend", medProbHtml);
			medProbContainer.appendChild(medProbNode);
		}
		else {
			const limitMsg = document.getElementById("addLimitReached");
			let text = "Cannot add more!";
			// Clear any text
			limitMsg.innerHTML = "";
			limitMsg.innerHTML = text;
		}
	}
}

function removeMedProbNode(medProbNode) {
	const limitMsg = document.getElementById("addLimitReached");
	limitMsg.innerHTML = "";
	medProbNode.parentElement.remove();		
	medProbLimit--;
}
