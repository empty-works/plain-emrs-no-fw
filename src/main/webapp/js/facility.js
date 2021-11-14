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
	
	let facWardName = document.forms["wardForm"]["facilityWardName"].value;	
	console.log("facility.js - validateAddWardForm facWardName=" + facWardName);
	if(facWardName == "") {
		
		alert("Cannot leave facility ward name empty!");
		return false;
	}
	return true;
}
