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

// Validate add facility ward form input by user
function validateAddWardForm() {
	
	let facWardName = document.forms["wardForm"]["facilityWardName"].value;	
	console.log("facility.js - validateAddWardForm facWardName=" + facWardName);
	if(facWardName == "") {
		
		alert("Cannot leave facility ward name empty!");
		return false;
	}
	return true;
}
