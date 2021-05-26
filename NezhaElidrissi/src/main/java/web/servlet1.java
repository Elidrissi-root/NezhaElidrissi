package web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LivreDAO;
import mode.Livre;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LivreDAO lm;
    public servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		lm=new LivreDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.parseInt(request.getParameter("id"));
		lm.deleteLivre(id);
		response.sendRedirect("Livre");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titre=request.getParameter("titre");
		String auteur=request.getParameter("auteur");
		String catégorie=request.getParameter("catégorie");
		
		if(request.getParameter("action").equalsIgnoreCase("Ajouter"))
		{
				lm.addLivre(titre, auteur, catégorie);
		}else
			if(request.getParameter("action").equalsIgnoreCase("modifier"))
			{
				int id= Integer.parseInt(request.getParameter("id"));
				Livre l=new Livre(titre, auteur, catégorie);
				lm.updateLivre(id, l);
			}
			
		response.sendRedirect("Livre");
	}
	
	}


