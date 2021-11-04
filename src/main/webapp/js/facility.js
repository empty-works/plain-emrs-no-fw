/**
 * 
 */
 
 function showAddWardForm() {
	
	document.getElementById("addWardButton").style.display = "none";
	document.getElementById("addWardForm").style.display = "block";
	document.getElementById("addWardForm").scrollIntoView();
 }
 
 function cancelAddWardForm() {
	
	document.getElementById("addWardForm").style.display = "none";
	document.getElementById("addWardButton").style.display = "block";
}
 