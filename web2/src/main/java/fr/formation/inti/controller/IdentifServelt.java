package fr.formation.inti.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.inti.dao.userDao;
import fr.formation.inti.entity.user;

/**
 * Servlet implementation class indentif
 */
@WebServlet("/ident")
public class IdentifServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IdentifServelt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userDao dao = new userDao();
		String login = request.getParameter("Login");
		String passWord = request.getParameter("passWord");
		
		user u = new user(0,login,passWord);
		
		int id = dao.save(u);
		
		request.setAttribute("Message", "Utilisateur "+id+" bien enregistré");

			request.getRequestDispatcher("identif.jsp").forward(request, response);

		}


	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userDao dao = new userDao();
		String login = request.getParameter("Login");
		String passWord = request.getParameter("passWord");

		user user = dao.login(login, passWord);

		if (user != null) {
			request.setAttribute("Message2", "Bienvenue  ");
			request.setAttribute("user", user);

			request.getRequestDispatcher("identif.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);

		}

	}
}
