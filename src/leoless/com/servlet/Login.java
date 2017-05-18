package leoless.com.servlet;

import java.io.IOException;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static String VIEW_PAGES_URL = "/WEB-INF/index.jsp";
	
	public static final String FIELD_MAIL = "mail";
	public static final String FIELD_PWD = "pwd";
	
	public static Map<String, String> form;
	public static Map<String, String> errors;
	public static String actionMessage;
	
	private static Query qUser;
	
	String loginInfo;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		String email = request.getParameter(FIELD_MAIL);
		String pwd = request.getParameter(FIELD_PWD);				
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Covoit");
		EntityManager em = emf.createEntityManager();
		qUser = em.createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :pwd");
		qUser.setParameter("email", email);
		qUser.setParameter("pwd", pwd);
		boolean valide = true;
		try {
			User u = (User) qUser.getSingleResult();
		} catch (NoResultException e) {						
			valide = false;
		}
		if (valide) {			
			request.getSession().setAttribute( "user", email);
			response.sendRedirect("Acceuil");			
		} else {
			response.sendRedirect("Login");;
		}		
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
