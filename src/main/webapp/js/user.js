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
	constructor(medProbType) {
		this.medProbType = medProbType;
		this.medProbLimit = 0;
		this.MED_PROB_MAX = 15;
	}
	
	addNode(jsonList, medProbCon, needsRemoveButton) {
		if(this.medProbLimit < this.MED_PROB_MAX) {
			this.medProbLimit++;
			console.log(jsonList);
			let medProbNode = document.createElement("div");
			let medProbDropDown = document.createElement("select");
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
			"<input type=\"text\" class=\"med-prob-text\" name=\"medProbText\" placeholder=\"Medical problem:\">" + 
			"<input type=\"text\" class=\"med-prob-text\" name=\"medProbSurgeryText\" placeholder=\"Surgical procedure:\">" + 
			"<label class=\"med-prob-text\" for=\"medProbSurgeryDate\">Surgical procedure date: </label>" + 
			"<input type=\"date\" class=\"medProbSurgeryDate\" name=\"medProbSurgeryDate\">";
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

function addFamilyCondition(jsonList, familyCondCon) {
	let familyCondList = [];
	// Push JSON elements to a JS list
	for(let x in jsonList) {
		familyCondList.push(jsonList[x]);
	}
	// Sort the JS list
	familyCondList.sort();
	// 
	for(let x in familyCondList) {
		let familyCondNode = document.createElement("div");
		console.log(familyCondList[x]);
		/*
		let famCondHtml = "
		<label class=\"patientForm\" for=\"" + x + "FamCond\">" + x + "</label>";
		*/
		// insert Label for checkbox node
		//familyCondNode.appendChild(element);
		familyCondNode.insertAdjacentHTML("beforeend", familyCondList[x]);
		let famCondInputsHtml = 
		"<input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyConditionSelf\">" + 
		"<input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyConditionFather\">" + 
		"<input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyConditionMother\">" + 
		"<input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyConditionBrothers\">" + 
		"<input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyConditionSisters\">" + 
		"<input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyConditionSons\">" + 
		"<input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyConditionDaughters\">" + 
		"<input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyConditionGrandparents\">";
		familyCondNode.insertAdjacentHTML("beforeend", famCondInputsHtml);
		familyCondCon.appendChild(familyCondNode);
	}
}