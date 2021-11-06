/**
 * 
 */
 
// Simply unhides the add facility ward form
function showAddWardForm() {
	
	document.getElementById("addWardButton").style.display = "none";
	document.getElementById("addWardForm").style.display = "block";
	document.getElementById("addWardForm").scrollIntoView();
}
 
// Hides add facility ward form
function cancelAddWardForm() {
	
	document.getElementById("addWardForm").style.display = "none";
	document.getElementById("addWardButton").style.display = "block";
}

// Validate add facility ward form input by user
function validateAddWardForm() {
	
	let facName = document.forms["wardForm"]["facilityName"].value;	
	console.log("facility.js - validateAddWardForm facName=" + facName);
	if(facName == "") {
		
		alert("Cannot leave facility name empty!");
		return false;
	}
	return true;
}
 