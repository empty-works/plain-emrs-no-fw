/**
 *  Code taken from a w3schools How TO - Collapsibles/Accordion
 */

var acc = document.getElementsByClassName("med-record-accordion");
var i;

for(i = 0; i < acc.length; i++) {
	acc[i].addEventListener("click", function() {
		this.classList.toggle("active");
		var panel = this.nextElementSibling;
		if(panel.style.maxHeight) {
			panel.style.display = null;
		} else {
			panel.style.maxHeight = panel.scrollHeight + "px";
		}
	});
}