package fr.formation.inti.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.inti.dao.UserDao;
import fr.formation.inti.entity.User;

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
		UserDao dao = new UserDao();
		String login = request.getParameter("Login");
		String passWord = request.getParameter("passWord");
		
		User u = new User(0,login,passWord);
		
		int id = dao.register(u);
		
		
		request.setAttribute("Message", "Utilisateur "+id+" bien enregistré");

			request.getRequestDispatcher("Connexion.jsp").forward(request, response);

		}


	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao dao = new UserDao();
		String login = request.getParameter("Login");
		String passWord = request.getParameter("passWord");

		User user = dao.findByLoginAndPassword(login, passWord);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(500); // 30 secondes avant d�connexion auto
			session.setAttribute("user", user);
			session.setAttribute("Message2", "Bienvenue    ");

			request.getRequestDispatcher("Core.jsp").forward(request, response);
		} else {
			request.setAttribute("MessageError", "Erreur sur le login ou le MDP");
			request.getRequestDispatcher("Connexion.jsp").forward(request, response);

		}

	}
}
