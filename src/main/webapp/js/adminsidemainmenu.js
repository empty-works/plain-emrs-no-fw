/**
 * 
 */

fetch('./sidenavjsps/SideMainMenu.jsp')
.then(res => res.text())
.then(text => {
    let oldelem = document.querySelector("script#replace_with_sidemainmenu");
    let newelem = document.createElement("div");
    newelem.innerHTML = text;
    oldelem.parentNode.replaceChild(newelem,oldelem);
})