var profil = document.getElementById('profil'),
form_profil = document.getElementById('form_profil');

background.addEventListener('mouseover', highlight);
background.addEventListener('mouseout', downlight);

function highlight(){
	background.src = 'images/fond.jpg';
}

function downlight(){
	background.src = 'images/fondblack.jpg';
}

profil.addEventListener('click', function(){
	setTimeout(function(){form_profil.style.height = '450px';
	form_profil.classList.add('open');}, 1000);
	form_profil.style.height = '0px';
	setTimeout(function(){form_signup.classList.remove('open');}, 1000);
	background.removeEventListener('mouseover', highlight);
});
