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

import java.util.ArrayList;
import java.util.Iterator;

import model.Trajet;
import model.TrajetShort;
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
		if(request.getParameter("latitude") != null && request.getParameter("longitude") != null) {
			int latitude = (int) Double.parseDouble(request.getParameter("latitude"));
			int longitude = (int) Double.parseDouble(request.getParameter("longitude"));
	        List<User> arr_user = (List<User>)em.createQuery("SELECT user FROM User user WHERE user.id IN (SELECT userTrajet.idUser FROM UserTrajet userTrajet,Trajet trajet WHERE trajet.longDepart like '"+longitude+"%' AND trajet.latDepart like '"+latitude+"%' AND userTrajet.idTrajet = trajet.id)")
	                              .getResultList();
	        List<TrajetShort> arr_trajet = (List<TrajetShort>) em.createQuery("select DISTINCT new model.TrajetShort(trajet.latDepart,trajet.longDepart) FROM Trajet trajet WHERE trajet.id IN (SELECT userTrajet.idTrajet as id FROM UserTrajet userTrajet WHERE userTrajet.fonction = 'conducteur')").getResultList();
	        
	        request.setAttribute("usersProcheText", arr_user.size() + " utilisateur(s) proche(s) de vous !");
	        request.setAttribute("usersProcheLatLng", arr_trajet);
	        //request.setAttribute("usersProcheText", ""+latitude+" "+longitude);
		} else {
			request.setAttribute("usersProcheText", "Localisation introuvable, recherche des utilisateurs proches impossible");
			request.setAttribute("usersProcheLatLng", new ArrayList<Trajet>());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
