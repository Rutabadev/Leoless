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
import javax.persistence.Query;
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
	public static final String FIELD_DATE = "birth";
	public static final String FIELD_FUMEUR = "smoke";

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

		boolean fumeur = Boolean.parseBoolean(request.getParameter(FIELD_FUMEUR));

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		String mail = request.getParameter(FIELD_EMAIL);

		Query findUser = em.createQuery("SELECT u FROM User u WHERE u.email = :mail");
		findUser.setParameter("mail", mail);
	
		if (findUser.getResultList().size() == 0) {
			em.getTransaction().begin();

			User user = new User();
			user.setEmail(request.getParameter(FIELD_EMAIL));
			user.setDateNaissance(request.getParameter(FIELD_DATE));
			user.setFumeur(fumeur);
			user.setNom(request.getParameter(FIELD_NOM));
			user.setPassword(request.getParameter(FIELD_PWD1));
			user.setPrenom(request.getParameter(FIELD_PRENOM));

			em.persist(user);

			em.getTransaction().commit();
		}

		em.close();
		emf.close();

//		request.setAttribute("Exist", "Mail existant");
//		request.getRequestDispatcher("/Acceuil?form=signup").forward(request, response);
		
		response.sendRedirect(response.encodeRedirectURL("/Leoless/Acceuil?signup=" + "signup"));


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
