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

class MedProbAdder {
	constructor() {
		this.medProbLimit = 0;
		this.MED_PROB_MAX = 15;
	}
	
	addNode(jsonList, medProbCon) {
		if(this.medProbLimit < this.MED_PROB_MAX) {
			this.medProbLimit++;
			console.log(jsonList);
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
			"<input type=\"date\" class=\"medProbSurgeryDate\" name=\"medProbSurgeryDate\">" 
			medProbNode.appendChild(medProbDropDown);
			medProbNode.insertAdjacentHTML("beforeend", medProbHtml);
			let removeButton = document.createElement("button");
			removeButton.innerHTML = "-";
			removeButton.onclick = function() {
				removeMedProbNode(medProbNode);	
			};
			medProbNode.appendChild(removeButton);
			medProbCon.appendChild(medProbNode);
		}
		else {
			let limitMsg = document.createElement("div");	
			let text = "Cannot add more!";
			// Clear any text
			limitMsg.innerHTML = "";
			limitMsg.innerHTML = text;
			medProbCon.appendChild(limitMsg);
		}
	}

	removeMedProbNode(medProbNode) {
		this.medProbCon.removeChild(this.medProbCon.lastChild);
		medProbNode.parentElement.remove();		
		this.medProbLimit--;
	}
}

genMed = new MedProbAdder();
heartMed = new MedProbAdder();
reproductMed = new MedProbAdder();

function removeMedProbNodeWrap(med, medProbNode) {
	med.removeMedProbNode(medProbNode);
}