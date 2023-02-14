/**
 * 
 */

fetch('./sidenavjsps/PatientsSideNav.jsp')
.then(res => res.text())
.then(text => {
    let oldelem = document.querySelector("script#replace_with_sidenav");
    let newelem = document.createElement("div");
    newelem.innerHTML = text;
    oldelem.parentNode.replaceChild(newelem,oldelem);
})

let patientUserId = "";
function setPatientId(id) {
	patientUserId = id;
}

function getPatientId() {
	return patientUserId;
}