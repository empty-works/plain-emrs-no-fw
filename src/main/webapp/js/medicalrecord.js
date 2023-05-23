/**
 * 
 */

function showMedRecordModal(link, modal, span) {
	// Get the modal
	// var modal = modal;

	// Get the button that opens the modal
	// var btn = document.getElementById(linkName);

	// Get the <span> element that closes the modal
	//var span = document.getElementById(closeName);

	// When the user clicks the button, open the modal 
	link.onclick = function() {
	  modal.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	  modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	  if (event.target == modal) {
		modal.style.display = "none";
	  }
	}
}