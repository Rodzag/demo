package fr.formation.inti.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.dao.EmployeeDao;
import fr.formation.inti.entity.Employee;

/**
 * Servlet implementation class indentif
 */
@WebServlet("/cherche")
public class ChercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ChercheServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChercheServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmployeeDao dao = new EmployeeDao();
		String chr = request.getParameter("text");
		
		
		List<Employee> list=dao.findCherche(chr);
		for (Employee e : list) {
			log.info(e);
			
		}
		request.setAttribute("list", list);

		
		request.setAttribute("Message", "Recherche avec :"+chr);
			request.getRequestDispatcher("Tableau.jsp").forward(request, response);

		}


	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}
	

}
