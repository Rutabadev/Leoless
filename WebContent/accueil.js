var profil = document.getElementById('profil'),
signup = document.getElementById('signup'),
trajet = document.getElementById('profil'),
signin = document.getElementById('signin'),
form_signup = document.getElementById('form_signup'),
form_signin = document.getElementById('form_signin'),
background = document.getElementById('photofond');

background.addEventListener('mouseover', highlight);
background.addEventListener('mouseout', downlight);

function highlight(){
	background.src = 'images/fond.jpg';
}

function downlight(){
	background.src = 'images/fondblack.jpg';
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