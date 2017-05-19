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
    
<c:if test="${not empty objects}">
    <table>
        <c:forEach var="o" items="${objects}">
            <tr>
                <td>${o.id}</td>
                <td>${o.name}</td>
                <td>${o.descriptio}</td>   
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>