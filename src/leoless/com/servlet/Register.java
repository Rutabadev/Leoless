package leoless.com.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String VIEW_PAGES_URL = "/WEB-INF/register.html";

	public static final String FIELD_EMAIL = "mail";
	public static final String FIELD_PWD1 = "pwd1";
	public static final String FIELD_PWD2 = "pwd2";
	public static final String FIELD_NOM = "nom";
	public static final String FIELD_PRENOM = "prenom";
	public static final String FIELD_DATE = "date";
	public static final String FIELD_FUMEUR = "fumeur";
	
	private static final String PERSISTENCE_UNIT_NAME = "Covoit";

	public static Map<String, String> form;
	public static Map<String, String> errors;
	public static String actionMessage;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("errorStatus", false);
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User newUser = null;

//		errors = new HashMap<String, String>();
//		form = new HashMap<String, String>();

//		String email = request.getParameter(FIELD_EMAIL);
//		String pwd = request.getParameter(FIELD_PWD1);
//		String nom = request.getParameter(FIELD_NOM);

//		String errMsg = validateEmail(email);
//
//		if (errMsg != null) {
//			errors.put(FIELD_EMAIL, errMsg);
//			actionMessage = "Echec de l'inscription";
//			request.setAttribute("errorStatus", false);
//		} else {
//			form.put(FIELD_EMAIL, email);
//			actionMessage = "Succ�s de l'inscription";
//			// TODO newUser = new User(nom, email, pwd);
//			request.setAttribute("errorStatus", true);
//		}
//
//		request.setAttribute("form", form);
//		request.setAttribute("erreurs", errors);
//		request.setAttribute("actionMessage", actionMessage);
//		request.setAttribute("newUser", newUser);
//
//		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
//
//		System.out.println(request.getParameter(FIELD_EMAIL));
//		System.out.println(request.getParameter(FIELD_NOM));
//		System.out.println(request.getParameter(FIELD_PWD1));
//		System.out.println(request.getParameter(FIELD_PRENOM));
//		System.out.println(new Date(9999999));
//		System.out.println((byte) 0);
		
		String date = request.getParameter(FIELD_DATE);
		
		String fumeur = request.getParameter(FIELD_FUMEUR);
		
		int fumeurParse = Integer.parseInt(fumeur);
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				
		java.util.Date parsed = null;
		Date sqlDate = null;
		try {
			parsed = formatter.parse(date);
			sqlDate = new Date(parsed.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		User user = new User();
		user.setEmail(request.getParameter(FIELD_EMAIL));
		user.setDateNaissance(sqlDate);
		user.setFumeur(fumeurParse);
		user.setNom(request.getParameter(FIELD_NOM));
		user.setPassword(request.getParameter(FIELD_PWD1));
		user.setPrenom(request.getParameter(FIELD_PRENOM));
		
		em.persist(user);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
//		try {
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
	}

	private String validateEmail(String email) {

		if (email != null && email.trim().length() != 0) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				return "Veuillez saisir une adresse mail valide";
			}
		} else {
			return "L'adresse mail est obligatoire";
		}

		return null;
	}

	private String validatePwd(String pwd1, String pwd2) {

		if (pwd1 != null && pwd2 != null && pwd1.length() != 0 && pwd2.length() != 0) {
			if (!pwd1.equals(pwd2)) {
				return "Les mots de passe ne correspondent pas";
			}
		} else {
			return "Le mot de passe est obligatoire";
		}

		return null;
	}

}
