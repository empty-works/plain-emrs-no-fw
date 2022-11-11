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

function addFamilyCondition(jsonList, familyCondCon) {
	let familyCondList = [];
	// Push JSON elements to a JS list
	for(let x in jsonList) {
		familyCondList.push(jsonList[x]);
	}
	// Sort the JS list
	familyCondList.sort();

	// TODO: TEMPORARY TABLE - just need this work first then make it pretty later using CSS.
	let famCondInputsHtml = 
	"<table>" + 
	" <tr>" + 
	"  <th colspan=\"5\">Condition Name</th>" + 
	"  <th colspan=\"4\">Self</th>" + 
	"  <th colspan=\"4\">Father</th>" + 
	"  <th colspan=\"4\">Mother</th>" + 
	"  <th colspan=\"4\">Brothers</th>" + 
	"  <th colspan=\"4\">Sisters</th>" + 
	"  <th colspan=\"4\">Sons</th>" + 
	"  <th colspan=\"4\">Daughters</th>" + 
	"  <th colspan=\"4\">Grandparents</th>" + 
	" </tr>";

	for(let x in familyCondList) {
		console.log(familyCondList[x]);
		famCondInputsHtml += 
		"<tr>" + 
		" <td colspan=\"5\">" + familyCondList[x] + "</td>" + 
		// Hidden inputs return a false value while its corresponding checkbox input returns true if checked.
		" <input type=\"hidden\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessSelf\" value=\"false\">" + 
		" <td colspan=\"4\"><input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessSelf\" value=\"true\"></td>" + 
		" <input type=\"hidden\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessFather\" value=\"false\">" + 
		" <td colspan=\"4\"><input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessFather\" value=\"true\"></td>" + 
		" <input type=\"hidden\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessMother\" value=\"false\">" + 
		" <td colspan=\"4\"><input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessMother\" value=\"true\"></td>" + 
		" <input type=\"hidden\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessBrothers\" value=\"false\">" + 
		" <td colspan=\"4\"><input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessBrothers\" value=\"true\"></td>" + 
		" <input type=\"hidden\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessSisters\" value=\"false\">" + 
		" <td colspan=\"4\"><input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessSisters\" value=\"true\"></td>" + 
		" <input type=\"hidden\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessSons\" value=\"false\">" + 
		" <td colspan=\"4\"><input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessSons\" value=\"true\"></td>" + 
		" <input type=\"hidden\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessDaughters\" value=\"false\">" + 
		" <td colspan=\"4\"><input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessDaughters\" value=\"true\"></td>" + 
		" <input type=\"hidden\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessGrandparents\" value=\"false\">" + 
		" <td colspan=\"4\"><input type=\"checkbox\" class=\"patient-form-fam-cond-checkbox\" name=" + familyCondList[x] + "\"familyIllnessGrandparents\" value=\"true\"></td>" + 
		"</tr>";
	}
	famCondInputsHtml += "</table>";
	console.log(famCondInputsHtml);
	familyCondCon.insertAdjacentHTML("beforeend", famCondInputsHtml);
}

function getRandomInt(max) {
	return Math.floor(Math.random() * max);
}