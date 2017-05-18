var signup = document.getElementById('signup'),
trajet = document.getElementById('profil'),
signin = document.getElementById('signin'),
form_signup = document.getElementById('form_signup'),
form_signin = document.getElementById('form_signin'),
background = document.getElementById('photofond'),
nom = document.getElementById('nom'),
prenom = document.getElementById('prenom'),
email = document.getElementById('email'),
birth = document.getElementById('birth'),
pwd1 = document.getElementById('pwd1'),
pwd2 = document.getElementById('pwd2');
//nom = document.getElementById('photofond'),;

background.addEventListener('mouseover', highlight);
background.addEventListener('mouseout', downlight);

function highlight(){
	background.src = 'images/fond.jpg';
}

function downlight(){
	background.src = 'images/fondblack.jpg';
}

nom.addEventListener('blur', checkNom);
prenom.addEventListener('blur', checkPrenom);
mail.addEventListener('blur', checkEmail);
birth.addEventListener('blur', checkBirth);
pwd1.addEventListener('blur', checkPwd1);
pwd2.addEventListener('blur', checkPwd2);

function checkNom(){
	var regexNom = /^[a-zA-Z0-9.\-_$@*!]{3,20}$/;

    if (regexNom.test(nom.value)) {
        setValid('nom');
        document.getElementById('errorNom').style.color = '#4CAF50';
        document.getElementById('errorNom').innerHTML = 'Nom est valide';
    } else {
        document.getElementById('errorNom').style.color = '#f44336';
        document.getElementById('errorNom').innerHTML = 'erreur';
        setInvalid('nom');
    }
}
function checkPrenom(){
	var regexPrenom = /^[a-zA-Z0-9.\-_$@*!]{3,20}$/;

    if (regexPrenom.test(prenom.value)) {
        setValid('prenom');
        document.getElementById('errorPrenom').style.color = '#4CAF50';
        document.getElementById('errorPrenom').innerHTML = 'Prenom est valide';
    } else {
        document.getElementById('errorPrenom').style.color = '#f44336';
        document.getElementById('errorPrenom').innerHTML = 'erreur';
        setInvalid('prenom');
    }
}
function checkEmail(){
	var regexMail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;

    if (regexMail.test(mail.value)) {
        setValid('mail');
        document.getElementById('errorEmail').style.color = '#4CAF50';
        document.getElementById('errorEmail').innerHTML = 'Mail est valide';
    } else {
        document.getElementById('errorEmail').style.color = '#f44336';
        document.getElementById('errorEmail').innerHTML = 'erreur';
        setInvalid('mail');
    }
}
function checkBirth(){
	
    if (0==0/*Si l'age est correct*/) {
        setValid('birth');
        document.getElementById('errorBirth').style.color = '#4CAF50';
        document.getElementById('errorBirth').innerHTML = 'Date de naissance valide';
    } else {
        document.getElementById('errorBirth').style.color = '#f44336';
        document.getElementById('errorBirth').innerHTML = 'erreur';
        setInvalid('birth');
    }
}
function checkPwd1(){
	var regexPwd = /^[a-zA-Z0-9]{5,20}$/;

    if (regexPwd.test(pwd1.value)) {
        document.getElementById('errorPwd1').innerHTML = ' (Mot de passe est valide)';
        document.getElementById('errorPwd1').style.color = '#4CAF50';
        setValid('pwd1');
    } else {
    	document.getElementById('errorPwd1').innerHTML = ' (Mot de passe est invalide)';
        document.getElementById('errorPwd1').style.color = '#f44336';
        setInvalid('pwd1');
    }
    checkPwd2();
}
function checkPwd2(){
	if (pwd1.value == '') {

    } else {
        if (pwd1.value == pwd2.value) {
            document.getElementById('errorPwd2').innerHTML = ' (Identique)';
            document.getElementById('errorPwd2').style.color = '#4CAF50';
            setValid('pwd2');
        } else {
            document.getElementById('errorPwd2').innerHTML = ' (Ne correspond pas)';
            document.getElementById('errorPwd2').style.color = '#f44336';
            setInvalid('pwd2');
        }
    }
}
function setValid(element) {
    document.getElementById(element).style.border = '1px solid #4CAF50';
    document.getElementById(element).style.boxShadow = '1px 1px 1px 1px #4CAF50';
}

function setInvalid(element) {
    document.getElementById(element).style.border = '1px solid #f44336';
    document.getElementById(element).style.boxShadow = '1px 1px 1px 1px #f44336';
}

signin.addEventListener('click', function(){
	setTimeout(function(){form_signin.style.height = '250px';
	form_signin.classList.add('open');}, 1000);
	form_signup.style.height = '0px';
	setTimeout(function(){form_signup.classList.remove('open');}, 1000);
	background.removeEventListener('mouseover', highlight);
});

signup.addEventListener('click', function(){
	setTimeout(function(){form_signup.style.height = '575px';
	form_signup.classList.add('open');}, 1000);
	form_signin.style.height = '0px';
	setTimeout(function(){form_signin.classList.remove('open');}, 1000);
	background.removeEventListener('mouseover', highlight);
});