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
	
	var facName = document.getElementById("facAddName");	
	var valid = true;
	if(facName.nodeValue.length <= 0) {
		
		alert("Cannot leave facility name empty");
		valid = false;	
	}
	return valid;
}
 