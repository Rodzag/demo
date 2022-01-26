package fr.formation.inti.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServelet
 */

public class Connexion extends HttpServlet {

	private String color;
	
	private static final long serialVersionUID = 1L;
       
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Writer out = response.getWriter();
		out.append("<html>")
		.append("<head><title>Connexion</title></head>")
		.append("<body>")
		
		.append("<form action=\"Connexion\" method=\"post\">"
				
				+ "<label style=\"color:"+color+"\" for=\"Login\">Login:</label><br>"
				+ "<input type=\"text\" id=\"Login\" name=\"Login\"><br>"
				
				+ "<label style=\"color:"+color +"\" for=\"PassWord\">Password:</label><br>\r\n"
				+ "<input  type=\"password\" id=\"PassWord\" name=\"PassWord\"><br><br>"
				
				+ "<input type=\"submit\" value=\"Submit\">"
				
				+ "</form>")
		
		.append("<form action=\"index.html\" method=\"post\">"
	
				
				+ "<input type=\"submit\" value=\"Retour home\">"
				
				+ "</form>")
		.append("</body>")
		.append("</html>");

	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("Login");
		String password = request.getParameter("PassWord");
		color ="black";
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30); //seconde
		
		if(("root".equals(login)) && ("123456".equals(password))){
			session.setAttribute("message", "you are connected");
			session.setAttribute("dateConnection", new Date());
			//getServletConfig("config",login);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginServlet");
			dispatcher.forward(request, response);
		}else {
			color = "blue";
			doGet(request,response);
		}

	}

}
