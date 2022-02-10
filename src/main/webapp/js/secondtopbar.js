/**
 * 
 */

fetch('SecondTopBar.jsp')
.then(res => res.text())
.then(text => {
    let oldelem = document.querySelector("script#replace_with_secondtopbar");
    let newelem = document.createElement("div");
    newelem.innerHTML = text;
    oldelem.parentNode.replaceChild(newelem,oldelem);
})

var makeButtonActive = function(buttonName) {

	
	var clickedButton = document.getElementsByName(buttonName);
	clickedButton.className += " sectopnav-active";
/*	
	var buttonContainer = document.getElementById("sectopnav-ul");
	var buttons = buttonContainer.getElementsByName("sectopnav-button");

	for(var i = 0; i < buttons.length; i++) {
		buttons[i].addEventListener("click", function() {
			var current = document.getElementsByClassName("sectopnav-active");
			current[0].className = current[0].className.replace(" sectopnav-active", "");
			this.className += " sectopnav-active";
		});
	}
	*/
}