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
        <a href='/Leoless/Acceuil'><img src="images/tumontes.png" id="logoHaut"></a>
        <label id="profil" class='titres'>PROFIL</label>
        <label id="signup" class='titres'>CREER UN COMPTE</label>
        <label id="trajet" class='titres'>TRAJET</label>
        <label id="signin" class='titres'>S'IDENTIFIER</label>
    </section>
    
    <img id="photofond" src="images/fondblack.jpg"/>
    
<div id='tabTrajet'>
	<c:if test="${not empty objects}">
	    <table>
            <tr> 
                <th>Nom</th>
                <th>Nombre de places</th>
                <th id='option'></th>
        </tr>
        <c:if test = "${trajets}">
        <c:forEach var="t" items="${trajets}">
            <tr>
                <td class='trajetNom'>Serge ${t.getNom()}</td>
                <td>3 ${t.getNbPlaces()}</td>
                <td><a href="Trajet?id="+${t.getId()}>Consulter/Modifier</a></td>
            </tr>
            <tr>
                <td class='trajetNom'>Raymond ${t.getNom()}</td>
                <td>6 ${t.getNbPlaces()}</td>
                <td><a href="Trajet?id="+${t.getId()}>Consulter/Modifier</a></td>
            </tr>
            <tr>
                <td class='trajetNom'>Françis ${t.getNom()}</td>
                <td>1 ${t.getNbPlaces()}</td>
                <td><a href="Trajet?id="+${t.getId()}>Consulter/Modifier</a></td>
            </tr>
        </c:forEach>
        </c:if>
        </table>
	</c:if>
</div>
<script>
document.getElementById('logoHaut').addEventListener('mouseenter', function(){
	document.getElementById('logoHaut').src = 'images/tumonteshover.png';
});
document.getElementById('logoHaut').addEventListener('mouseleave', function(){
	document.getElementById('logoHaut').src = 'images/tumontes.png';
});
</script>

</body>
</html>