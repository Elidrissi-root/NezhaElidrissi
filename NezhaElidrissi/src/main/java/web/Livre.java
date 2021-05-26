package web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LivreDAO;
import mode.User;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Livre
 */
@WebServlet("/Livre")
public class Livre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LivreDAO lm; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Livre() {
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
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession ses = request.getSession(false);
		User u=(User) ses.getAttribute("user");
		out.print("<h3>Bonjour Mr ."+u.getNom()+"</h3>");
		
		out.print("<h1>Livre Management</h1>");
		
		String titre="";
		String auteur="";
		String catégorie="";
		
		String action="Ajouter";
		int id=0;
		if(request.getParameter("op")!=null)
		{
			if(request.getParameter("op").equals("edit"))
			{
				 id= Integer.parseInt(request.getParameter("id"));
				mode.Livre l=lm.findLivreById(id);
				titre=l.getTitre();
				auteur=l.getAuteur();
				catégorie=l.getCatégorie();
				action="Modifier";
				
			}
		}
		out.print("<form action='servlet1' method='post'> <table>");
		out.print("<tr><td>ID:</td><td><input type='number' readonly name='id' value='"+id+"' /></td></tr>");

		out.print("<tr><td>Titre:</td><td><input type='text' name='titre' value='"+titre+"' /></td></tr>");
		out.print("<tr><td>Auteur:</td><td><input type='text' name='auteur' value='"+auteur+"' /></td></tr>");
		out.print("<tr><td>Catégorie:</td><td><input type='text' name='catégorie' value='"+catégorie+"'/></td></tr>");
		out.print("<tr><td><input type='submit' value='"+action+"' name='action'/><td/><td><input type='reset' value='Annuler' name='add'/></td></tr>");
		out.print("</table><form>");
		out.print("<hr/>");
		
		
		
		List<mode.Livre> ls = lm.allLivre();
		out.print("<table width='80%' bgcolor='gold' biorder='2px'>");
		out.print("<thead><tr><th>ID</th><th>Titre</th><th>Auteur</th><th>Catégorie</th></tr></thead>");
		out.print("<tbody>");
		for (mode.Livre l : ls) {
			out.print("<tr>");
			out.print("<td>"+l.getId()+"</td>");
			out.print("<td>"+l.getTitre()+"</td>");
			out.print("<td>"+l.getAuteur()+"</td>");
			out.print("<td>"+l.getCatégorie()+"</td>");
			if(u.getRole().equalsIgnoreCase("admin"))
			{
			out.print("<td><a href='servlet1?id="+l.getId()+"'>delete</a></td>");
			out.print("<td><a href='?op=edit&id="+l.getId()+"'>update</a></td>");
			}
			out.print("</tr>");
		}
		out.print("</tbody>");
		out.print("</table");
	}
	}

