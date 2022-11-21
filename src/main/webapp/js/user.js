/**
 * 
 */

let roleDropdown = document.getElementById('role-dropdown');

function validateForm() {
	const raceCheckboxes = document.querySelectorAll('[name="raceCheck"]');
	let raceChecked = false;
	for(const raceCheckbox of raceCheckboxes) {
		if(raceCheckbox.checked) {
			raceChecked = true;	
			break;
		}	
	}
	if(!raceChecked) {
		const raceFieldLegend = document.getElementById("raceFieldLegend");
		raceFieldLegend.focus();
		alert("At least one race must be selected.");
		return false;
	}
	return true;
}

function addPatientOtherRelations(relation) {
	const otherRelationsCon = document.getElementById("otherRelationsCon");
	const otherRelationsHtml = 
	"<label for=\"" + relation + "Alive\">" + relation + " alive: </label>" + 
	"<select id=\"" + relation + "Alive\" name=\"" + relation + "Alive\">" + 
		"<option>0</option>" + 
		"<option>1</option>" +
		"<option>2</option>" +
		"<option>3</option>" +
		"<option>4</option>" +
		"<option>5</option>" +
		"<option>6</option>" +
		"<option>7+</option>" +
	"</select><br>";
	otherRelationsCon.insertAdjacentHTML("beforeend", otherRelationsHtml);
}

class MedProbAdder {
	limitMsg;
	MAX_NAME_INT;
	constructor(medProbType) {
		this.medProbType = medProbType;
		this.medProbLimit = 0;
		this.MED_PROB_MAX = 15;
		this.MAX_NAME_INT = 99999;
	}
	
	addNode(jsonList, medProbCon, needsRemoveButton) {
		if(this.medProbLimit < this.MED_PROB_MAX) {
			this.medProbLimit++;
			console.log(jsonList);
			let medProbNode = document.createElement("div");
			let medProbDropDown = document.createElement("select");
			// Needed for specific naming
			medProbDropDown.setAttribute("name", "medProbArea");
			let medProbList = [];
			// Push JSON elements to a JS list
			for(let x in jsonList) {
				medProbList.push(jsonList[x]);
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
			"<input type=\"text\" class=\"med-prob-text\" name=\"medProbText" + "\" placeholder=\"Medical problem:\">" + 
			"<input type=\"text\" class=\"med-prob-text\" name=\"medProbSurgeryText" + "\" placeholder=\"Surgical procedure:\">" + 
			"<label class=\"med-prob-text\" for=\"medProbSurgeryDate" + "\">Surgical procedure date: </label>" + 
			"<input type=\"date\" class=\"medProbSurgeryDate\" name=\"medProbSurgeryDate" + "\">";
			medProbNode.appendChild(medProbDropDown);
			medProbNode.insertAdjacentHTML("beforeend", medProbHtml);
			if(needsRemoveButton == true) {
				medProbNode.insertAdjacentHTML("beforeend", this.setMedProbType());
			}
			medProbCon.appendChild(medProbNode);
		}
		else {
			// Disable add button first.
			document.getElementById(this.medProbType + "AddButton").disabled = true;	
			// Set limit message.
			this.limitMsg = document.getElementById(this.medProbType + "LimitMsg");	
			this.limitMsg.innerHTML = "Cannot add more!";
		}
	}
	
	setMedProbType() {
		if(this.medProbType === "genMed") {
			return "<button type=\"button\" onclick=\"genMed.removeNode(this)\">-</button>";
		}
		else if(this.medProbType === "heartMed") {
			return "<button type=\"button\" onclick=\"heartMed.removeNode(this)\">-</button>";
		}
		else if(this.medProbType === "reproductMed") {
			return "<button type=\"button\" onclick=\"reproductMed.removeNode(this)\">-</button>";
		}
	}

	removeNode(removeButton) {
		removeButton.parentNode.remove();		
		this.medProbLimit--; 
		// Reenable add button.
		document.getElementById(this.medProbType + "AddButton").disabled = false;	
		// Remove limit message.
		this.limitMsg = document.getElementById(this.medProbType + "LimitMsg");	
		this.limitMsg.innerHTML = "";
	}
}

genMed = new MedProbAdder("genMed");
heartMed = new MedProbAdder("heartMed");
reproductMed = new MedProbAdder("reproductMed");

function addFamilyCondition(jsonList) {
	const illnessDiv = document.getElementById("familyConditionsCon");
	// Add illness relations labels
	illnessDiv.appendChild(setUpIllRelationsRow());
	for(let illnessId in jsonList) {
		console.log(illnessId);
		illnessDiv.appendChild(getIllnessRow(illnessId, jsonList[illnessId]));
	}
}

function setUpIllRelationsRow() {
	let illWrapper = document.createElement("div");
	illWrapper.classList.add("horiz-label-then-buttons-row");
	let illName = document.createElement("div");
	illName.classList.add("horiz-label-then-buttons-name");
	illWrapper.appendChild(illName);
	// Add relations labels
	illWrapper.appendChild(getIllRelationsLabel("Self"));
	illWrapper.appendChild(getIllRelationsLabel("Father"));
	illWrapper.appendChild(getIllRelationsLabel("Mother"));
	illWrapper.appendChild(getIllRelationsLabel("Brothers"));
	illWrapper.appendChild(getIllRelationsLabel("Sisters"));
	illWrapper.appendChild(getIllRelationsLabel("Sons"));
	illWrapper.appendChild(getIllRelationsLabel("Daughters"));
	illWrapper.appendChild(getIllRelationsLabel("Grandparents"));
	return illWrapper;
}

function getIllRelationsLabel(relation) {
	let illLabel = document.createElement("div");
	illLabel.classList.add("horiz-label-then-buttons-checkbox"); // Just using the illness checkbox styling
	illLabel.textContent = relation;
	return illLabel;
}

function getIllnessRow(illnessId, illnessName) {
	let illWrapper = document.createElement("div");
	illWrapper.classList.add("horiz-label-then-buttons-row");
	let illName = document.createElement("div");
	illName.classList.add("horiz-label-then-buttons-name");
	illName.textContent = illnessName;
	illWrapper.appendChild(illName);
	// Add relations
	illWrapper.appendChild(getIllCheckbox(illnessId, "familyIllnessSelf"));
	illWrapper.appendChild(getIllCheckbox(illnessId, "familyIllnessFather"));
	illWrapper.appendChild(getIllCheckbox(illnessId, "familyIllnessMother"));
	illWrapper.appendChild(getIllCheckbox(illnessId, "familyIllnessBrothers"));
	illWrapper.appendChild(getIllCheckbox(illnessId, "familyIllnessSisters"));
	illWrapper.appendChild(getIllCheckbox(illnessId, "familyIllnessSons"));
	illWrapper.appendChild(getIllCheckbox(illnessId, "familyIllnessDaughters"));
	illWrapper.appendChild(getIllCheckbox(illnessId, "familyIllnessGrandparents"));
	return illWrapper;
}

function getIllCheckbox(illnessId, relation) {
	let illBox = document.createElement("input");
	illBox.type = "checkbox";
	illBox.id = illnessId + relation;
	illBox.name = illnessId + relation;
	illBox.classList.add("horiz-label-then-buttons-checkbox");
	illBox.value = "true";
	return illBox;
}

function getRandomInt(max) {
	return Math.floor(Math.random() * max);
}