<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TU MONTES ?</title>
<link rel="stylesheet" type="text/css" href="accueil.css">
</head>
<body>

<section id="barreMenu">
        <a href='/Leoless/Acceuil'><img src="images/tumontes.png" id="logoHaut"></a>
        <label id="profil" class='titres'>PROFIL</label>
        <label id="signup" class='titres'>CREER UN COMPTE</label>
        <label id="trajet" class='titres'>TRAJET</label>
        <label id="signin" class='titres'>S'IDENTIFIER</label>
    </section>
    
<img id="photofond" src="images/fondblack.jpg"/>

<div id='wrapper-trajets'>
	<c:if test="${not empty trajets}">
	    <table>
            <tr> 
                <th>Nom</th>
                <th>Nombre de places</th>
                <th id='option'>Actions</th>
        </tr>
        <c:forEach var="t" items="${trajets}">
            <tr>
                <td class='trajetNom'>${t.nom}</td>
                <td>${t.nbPlaces}</td>
                <td><a href="Trajets?id=${t.id}">Consulter/Modifier</a></td>
            </tr>
        </c:forEach>
        </table>
	</c:if>
</div>
<% if (request.getParameter("id") != null) { %>
<div id='wrapper-trajet'>
	<!-- <form> -->
	<label for="trajet-nom">Nom</label>
	<input type="text" value="${trajet.nom}" id="trajet-nom"/>
	<label for="trajet-distance">Distance</label>
	<input type="text" value="${trajet.distance}" id="trajet-distance"/>
	<label for="trajet-horaire">Horaire de départ</label>
	<input type="text" value="${trajet.horaireDepart}" id="trajet-horaire"/>
	<label for="trajet-nbplace">Nombre de place</label>
	<input type="text" value="${trajet.nbPlaces}" id="trajet-nbplace"/>
	<input type="text" value="${trajet.latDepart}" id="trajet-lat-depart" class="hidden"/>
	<input type="text" value="${trajet.longDepart}" id="trajet-long-depart" class="hidden"/>
	<label for="trajet-distance">Position de départ <button id="localisate">ME TROUVER</button></label>
	<iframe
  width="600"
  height="450"
  frameborder="0" style="border:0" id="mapTrajet"
  src="https://www.google.com/maps/embed/v1/place?key=AIzaSyCNuqsACDNMEU79YIMaVYslNSsR1TnQAFU
    &q=${trajet.latDepart},${trajet.longDepart}" allowfullscreen>
</iframe>
	<button id="save">ENREGISTRER LES MODIFICATIONS</button>
	<!-- </form> -->
</div>
<% } %>

<script>
document.getElementById('logoHaut').addEventListener('mouseenter', function(){
	document.getElementById('logoHaut').src = 'images/tumonteshover.png';
});
document.getElementById('logoHaut').addEventListener('mouseleave', function(){
	document.getElementById('logoHaut').src = 'images/tumontes.png';
});
document.getElementById('localisate').addEventListener('click', function(){
	    if (navigator.geolocation) {
	        navigator.geolocation.getCurrentPosition(setPosition);
	    } else {
	        alert("Geolocation is not supported by this browser.");
	    }
});
function setPosition(position) {
	document.getElementById("mapTrajet").src = "https://www.google.com/maps/embed/v1/place?key=AIzaSyCNuqsACDNMEU79YIMaVYslNSsR1TnQAFU&q="+position.coords.latitude+","+position.coords.longitude;
}
</script>

</body>
</html>