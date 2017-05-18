var profil = document.getElementById('profil'),
signup = document.getElementById('signup'),
trajet = document.getElementById('profil'),
signin = document.getElementById('signin'),
form_signup = document.getElementById('form_signup'),
form_signin = document.getElementById('form_signin');

signin.addEventListener('click', function(e){
	form_signin.style.display = 'block';
	form_signup.style.display = 'none';
	
	e.preventDefault();
});

signup.addEventListener('click', function(e){
	form_signup.style.display = 'block';
	form_signin.style.display = 'none';
	
	e.preventDefault();
});