var profil = document.getElementById('profil'),
signup = document.getElementById('signup'),
trajet = document.getElementById('profil'),
signin = document.getElementById('signin'),
form_signup = document.getElementById('form_signup'),
form_signin = document.getElementById('form_signin'),
background = document.getElementById('photofond');

background.addEventListener('mouseover', highlight);

function highlight(){
	background.src = 'images/fond.jpg';
}

signin.addEventListener('click', function(e){
	form_signin.style.height = '250px';
	form_signin.classlist.add('open');
	form_signup.style.height = '0px';
//    login.focus();
	
	e.preventDefault();
});

signup.addEventListener('click', function(e){
	form_signup.style.height = '500px';
	form_signin.style.height = '0px';
	
	e.preventDefault();
});