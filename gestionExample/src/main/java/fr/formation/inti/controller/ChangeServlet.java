package fr.formation.inti.controller;

import java.io.IOException;

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
@WebServlet("/change")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ChangeServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeServlet() {
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
		
		String forword2 = request.getParameter("m");
		if ("del".equals(forword2)) {		

			int id = Integer.parseInt(request.getParameter("i"));
			log.info("------------------>"+id);

			Employee emp = dao.findById(id);
			dao.del(emp);
			request.setAttribute("Message", "employe numero : "+id+" bien supprime");
		}
		try {
	

		}catch (Exception e) {
			
		}
		request.getRequestDispatcher("new").forward(request, response);
		}


	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}
}
