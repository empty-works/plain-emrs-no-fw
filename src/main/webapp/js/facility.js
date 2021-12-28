/**
 * 
 */
 
// Simply unhides the add facility ward form
function showAddForm(button, form) {
	
	// Hide add button. Show add form
	document.getElementById(button).style.display = "none";
	document.getElementById(form).style.display = "block";
	document.getElementById(form).scrollIntoView();
}
 
// Hides add facility ward form
function cancelAddForm(button, form) {
	
	document.getElementById(button).style.display = "block";
	document.getElementById(form).style.display = "none";
}

function validateAddWardForm() {
	
	let facWardName = document.forms["wardForm"]["facilityWardName"].value;	
	return validateAddForm(facWardName);
}

function validateAddPositionForm() {
	
	let facPositionName = document.forms["positionForm"]["facilityPositionName"].value;
	return validateAddForm(facPositionName);
}

function validateAddSpecialtyForm() {
	
	let facSpecialtyName = document.forms["specialtyForm"]["facilitySpecialtyName"].value;
	return validateAddForm(facSpecialtyName);
}

// Validate add facility sub-categories (ward, staff position, staff specialty). Just checks if name is empty
function validateAddForm(name) {	

	if(name == "")	{
		
		alert("Cannot leave name empty!");
		return false;
	}
	return true;
}

function makeFormEditable() {
	
	document.getElementById("fac-edit-button").style.display = "none";
	document.getElementById("fac-save-cancel").style.display = "block";
	

	document.getElementById("facility-data").style.display = "none";
	document.getElementById("edit-facility-form").style.display = "block";
	/*
	document.getElementById("fac-address").contentEditable = true;
	document.getElementById("fac-city").contentEditable = true;
	document.getElementById("fac-state").contentEditable = true;
	document.getElementById("fac-country").contentEditable = true;
	document.getElementById("fac-zip").contentEditable = true;
	document.getElementById("fac-num-beds").contentEditable = true;
	document.getElementById("fac-desc").contentEditable = true;
	*/
}

function makeFormNotEditable() {
	
	document.getElementById("fac-edit-button").style.display = "block";
	document.getElementById("fac-save-cancel").style.display = "none";
	
	document.getElementById("facility-data").style.display = "block";
	document.getElementById("edit-facility-form").style.display = "none";

	/*
	document.getElementById("fac-address").contentEditable = false;
	document.getElementById("fac-city").contentEditable = false;
	document.getElementById("fac-state").contentEditable = false;
	document.getElementById("fac-country").contentEditable = false;
	document.getElementById("fac-zip").contentEditable = false;
	document.getElementById("fac-num-beds").contentEditable = false;
	document.getElementById("fac-desc").contentEditable = false;
	*/
}

function saveFacilityInfo() {
	
		
}