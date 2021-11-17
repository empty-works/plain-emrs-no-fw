/**
 * 
 */
 
// Simply unhides the add facility ward form
function showAddForm() {
	
	// Hide add button. Show add form
	document.getElementByClassName("show-fac-form-button").style.display = "none";
	document.getElementByClassName("add-sub-fac-form").style.display = "block";
	document.getElementByClassName("add-sub-fac-form").scrollIntoView();
}
 
// Hides add facility ward form
function cancelAddWardForm() {
	
	document.getElementByClassName("add-sub-fac-form").style.display = "none";
	document.getElementByClassName("show-fac-form-button").style.display = "block";
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
