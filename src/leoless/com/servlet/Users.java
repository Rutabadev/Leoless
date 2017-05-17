package leoless.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Iterator;

import model.User;

/**
 * Servlet implementation class Users
 */
@WebServlet("/Users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf;
	private static EntityManager em;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
        emf = Persistence.createEntityManagerFactory("Covoit");
        em = emf.createEntityManager();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		PrintWriter out = response.getWriter();
        List<User> arr_user = (List<User>)em.createQuery("SELECT user FROM User user")
                              .getResultList(); 
        out.println("Nombre d'utilisateur : "+arr_user.size());
        /*Iterator<User> i = arr_user.iterator();
        User user;
        while (i.hasNext()) {
        	user = (User) i.next();
            out.println(user.getId()+"<br/>");
            out.println(user.getNom()+"<br/>");
            out.println(user.getPrenom()+"<br/>");
            out.println("----------------" + "<br/>");
        }*/
		//Query selectAllUsers = em.createQuery("SELECT user FROM User user");
		//response.getWriter().append(""+selectAllUsers.getResultList().size());
		//em.close();
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
