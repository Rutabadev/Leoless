package leoless.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static String VIEW_PAGES_URL = "/WEB-INF/register.jsp";
	
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_PWD1 = "pwd1";
	public static final String FIELD_PWD2 = "pwd2";
	public static final String FIELD_NOM = "name";
	
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("errorStatus", false);
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User newUser = null;
		
		errors = new HashMap<String, String>();
		form = new HashMap<String, String>();
		
		String email = request.getParameter(FIELD_EMAIL);
		String pwd = request.getParameter(FIELD_PWD1);
		String nom = request.getParameter(FIELD_NOM);
		
		String errMsg = validateEmail(email);
		
		if (errMsg != null) {
			errors.put(FIELD_EMAIL, errMsg);
			actionMessage = "Echec de l'inscription";
			request.setAttribute("errorStatus", false);
		}
		else {
			form.put(FIELD_EMAIL, email);
			actionMessage = "Succès de l'inscription";
			newUser = new User(nom, email, pwd);
			request.setAttribute("errorStatus", true);
		}
				
		request.setAttribute("form", form);
		request.setAttribute("erreurs", errors);
		request.setAttribute("actionMessage", actionMessage);
		request.setAttribute("newUser", newUser);
		
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
		
	}
	
	private String validateEmail(String email) {
		
		if (email != null && email.trim().length() != 0) {
			if (!email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )) {
				return "Veuillez saisir une adresse mail valide";
			}
		}
		else {
			return "L'adresse mail est obligatoire";
		}
		
		return null;
		
	}
	
	private String validatePwd(String pwd1, String pwd2) {
		
		if (pwd1 != null && pwd2 != null && pwd1.length() != 0 && pwd2.length() != 0) {
			if (!pwd1.equals(pwd2)) {
				return "Les mots de passe ne correspondent pas";
			}
		}
		else {
			return "Le mot de passe est obligatoire";
		}
		
		return null;
		
	}
	
}
