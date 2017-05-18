<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TU MONTES ?</title>
<link rel="stylesheet" type="text/css" href="accueil.css">
</head>
<body>
<section id="barreMenu">
        <img src="images/tumontes.png" id="logoHaut">
        <label id="profil" class='titres'>PROFIL</label>
        <label id="signup" class='titres'>CREER UN COMPTE</label>
        <label id="trajet" class='titres'>TRAJET</label>
        <label id="signin" class='titres'>S'IDENTIFIER</label>
    </section>

<form id='form_signin' method="">
        <h2>Connexion</h2>
        <label>EMAIL</label><label class='errorMsg' id='errorLogin'></label>
        <input type="text" id="login" placeholder="Entrez votre Email" required>
        <label>Mot de passe</label><label class='errorMsg' id='errorMdp1'></label>
        <input type="password" id="pwd" placeholder="Entrez votre Mot de passe" required>
        <input type="submit" id="submit_button" value="Se connecter">
</form>

<form id='form_signup' method="">
			<h2>Inscription</h2>
            <label>Nom</label>
            <input type="text" id="nom" name='nom' placeholder="Entrez un NOM" required>
            <label>Prénom</label>
            <input type="text" id="prenom" name='prenom' placeholder="Entrez un Prénom" required>
            <label>Email</label>
            <input type="text" id="mail" name='mail' placeholder="Entrez un Email" required>
            <label>Date de naissance</label>
            <input type='date' id="birth" name='birth' placeholder='Indiquez votre date de naissance' required>
            <label>Mot de passe</label>
            <input type="password" id="pwd1" placeholder="Entrez un Mot de passe" required>
            <label>Vérifiez Mot de passe</label>
            <input type="password" id="pwd2" placeholder="Vérifiez le Mot de passe" required>
			<input type="radio" name="smoke" value="fumeur"> fumeur
  			<input type="radio" name="smoke" value="non_fumeur"> non fumeur
            <input type="submit" id="submit_button" value="S'inscrire">
            <input type="reset" id="reset_button">
    </form>

        <img id="photofond" src="images/fondblack.jpg"/>
        
	<script src='accueil.js'></script>
	<script src='annexe.js'></script>
	
</body>
</html>