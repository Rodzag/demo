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
@WebServlet("/up")
public class UpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(UpServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forword = request.getParameter("i");

		EmployeeDao dao = new EmployeeDao();
		
		Employee emp = dao.findById(Integer.valueOf(forword));
		
		request.setAttribute("id", emp.getEmpId());
		request.setAttribute("firstName", emp.getFirstName());
		request.setAttribute("lastName", emp.getLastName());
		request.setAttribute("title", emp.getTitle());
		

		request.getRequestDispatcher("Up.jsp").forward(request, response);

		}


	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
EmployeeDao dao = new EmployeeDao();
		
		String id= request.getParameter("i");
		Employee emp = dao.findById(Integer.valueOf(id));
		
		String fn= request.getParameter("firstName");
		if(fn!=null) {
			emp.setFirstName(fn);
		}
		String ln=request.getParameter("lastName");
		if(ln!=null) {
			emp.setLastName(ln);
		}
		String title=request.getParameter("title");
		if(title!=null) {
			emp.setTitle(title);
		}
		

		dao.update(emp);

		request.setAttribute("Message", "employe numero : "+id+" bien modifie");
		response.sendRedirect("/gestionExample/new?msg="+id);
	}
}
