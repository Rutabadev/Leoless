package leoless.com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Trajet;

/**
 * Servlet implementation class Trajets
 */
@WebServlet("/Trajets")
public class Trajets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static String VIEW_PAGES_URL = "/WEB-INF/listTrajet.jsp";
	public static List<Trajet> trajets;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Trajets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("trajets", Trajet.getTrajetByUser());
		if(request.getParameter("id") != null) {
			request.setAttribute("trajet", Trajet.getTrajet(Integer.parseInt(request.getParameter("id"))));
		}
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

