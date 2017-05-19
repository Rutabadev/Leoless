<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TU MONTES ?</title>
<link rel="stylesheet" type="text/css" href="accueil.css">
</head>
<body>
<section id="barreMenu">
        <a href="/Leoless/Acceuil"><img src="images/tumontes.png" id="logoHaut"></a>
        <% if (request.getSession().getAttribute("user") != null) { %>
        	<label id="profil" class='titres'><%= request.getSession().getAttribute("user") %></label>
        <% } %>
        <label id="trajet" class='titres'>TRAJET</label>
        <% if (request.getSession().getAttribute("user") != null) { %>
        	<a href="/Leoless/Logout"><label id="logout" class='titres'>DECONNEXION</label></a>
        	<a href="/Leoless/Delete"><label id="delete" class="titres">Supprimer mon compte</label></a>
        <% } else { %>
        	<label id="signup" class='titres'>CREER UN COMPTE</label>
        	<label id="signin" class='titres'>S'IDENTIFIER</label>
        <% } %>
    </section>
    
<section id="usersProche"> 
	<p id="usersProcheText"><c:out value="${usersProcheText}"></c:out></p>
	<div id="map"></div>
	<script>
	var tabLatLong = [];
	<c:forEach items="${usersProcheLatLng}" var="element">
	tabLatLong.push([${element.latDepart},${element.longDepart}]);
	</c:forEach>
	function getLocation() {
	    if (navigator.geolocation) {
	        navigator.geolocation.getCurrentPosition(showPosition);
	    } else {
	        document.getElementById("usersProcheText").innerHTML += "<br>Geolocation is not supported by this browser.";
	    }
	}
	function showPosition(position) {
		if(location.href.indexOf('longitude') == -1) {
			location.href += (location.href.indexOf('?') == -1 ? "?" : "") + "&longitude=" + position.coords.longitude + "&latitude=" + position.coords.latitude;
		}
	}
	var map;
    function initMap() {
      if(location.href.indexOf('longitude') != -1) {
          map = new google.maps.Map(document.getElementById('map'), {
              center: {lat: parseFloat(getParameterByName('latitude')), lng: parseFloat(getParameterByName('longitude'))},
              zoom: 10
            });
          document.getElementById('map').classList.add('show');
          var marker = new google.maps.Marker({
       	    position: {lat: parseFloat(getParameterByName('latitude')), lng: parseFloat(getParameterByName('longitude'))},
       	    map: map,
       	    title: 'Vous',
       	    icon: 'http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=%E2%80%A2|FFFFFF'
       	  });
          for (var i = 0; i < tabLatLong.length; i++) {
       	  	var marker = new google.maps.Marker({
            	    position: {lat: tabLatLong[i][0], lng: tabLatLong[i][1]},
            	    map: map,
            	    title: 'Eux',
            	    icon: 'http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=%E2%80%A2|000000'
            	  });
          }
      }
    }
    function getParameterByName(name, url) {
        if (!url) url = window.location.href;
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    }
	getLocation();
	</script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCNuqsACDNMEU79YIMaVYslNSsR1TnQAFU&callback=initMap"
    async defer></script>
</section>

<form id='form_signin' class="formAcc" method="POST" action="Login">
        <h2>Connexion</h2>
        <label>EMAIL</label><label class='errorMsg' id='errorLogin'></label>
        <input type="email" id="login" placeholder="Entrez votre Email" name="mail" required>
        <label>Mot de passe</label><label class='errorMsg' id='errorMdp1'></label>
        <input type="password" id="pwd" placeholder="Entrez votre Mot de passe"  name="pwd" required>
        <input type="submit" id="submit_button" value="Se connecter">        
</form>

<form id='form_signup' class="formAcc" method="POST" action="Register">
			<h2>Inscription</h2>
            <label>Nom</label><span id='errorNom' class='errorMsg'></span>
            <input type="text" id="nom" name='nom' placeholder="Entrez un NOM" required>
            <label>Prénom</label><span id='errorPrenom' class='errorMsg'></span>
            <input type="text" id="prenom" name='prenom' placeholder="Entrez un Prénom" required>
            <label>Email</label><span id='errorEmail' class='errorMsg'></span>
            <input type="text" id="mail" name='mail' placeholder="Entrez un Email" required>
            <label>Date de naissance</label><span id='errorBirth' class='errorMsg'></span>
            <input type='date' id="birth" name='birth' placeholder='Indiquez votre date de naissance' required>
            <label>Mot de passe</label><span id='errorPwd1' class='errorMsg'></span>
            <input type="password" name="pwd1" id="pwd1" placeholder="Entrez un Mot de passe" required>
            <label>Vérifiez Mot de passe</label><span id='errorPwd2' class='errorMsg'></span>
            <input type="password" id="pwd2" placeholder="Vérifiez le Mot de passe" required>
			<input type="radio" name="smoke" value="fumeur" required> fumeur
  			<input type="radio" name="smoke" value="non_fumeur" required> non fumeur
            <input type="submit" id="submit_button" value="S'inscrire">
            <input type="reset" id="reset_button">
    </form>

        <img id="photofond" src="images/fondblack.jpg"/>

	<script src='accueil.js'></script>
	<script src='annexe.js'></script>
	
</body>
</html>