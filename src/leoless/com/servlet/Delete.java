package leoless.com.servlet;

import java.io.IOException;

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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail = request.getSession().getAttribute("user").toString();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Covoit");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email = :mail");
		query.setParameter("mail", mail);
		User user = (User) query.getSingleResult();
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		request.getSession().removeAttribute("user");
		
		response.sendRedirect("/Leoless/Acceuil");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
