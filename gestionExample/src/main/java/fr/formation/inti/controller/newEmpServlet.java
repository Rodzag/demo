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

import fr.formation.inti.dao.DepartmentDao;
import fr.formation.inti.dao.EmployeeDao;
import fr.formation.inti.entity.Department;
import fr.formation.inti.entity.Employee;

/**
 * Servlet implementation class indentif
 */
@WebServlet("/new")
public class newEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(newEmpServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newEmpServlet() {
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
		List<Employee> list=dao.findAll();
		for (Employee e : list) {
			log.info(e);

		}
		request.setAttribute("list", list);
		String msg = (String) request.getAttribute("Message");
		String mess= request.getParameter("msg");
		if(mess!=null) {
			msg="L'employe numero "+mess+" est bien modifie";
		}
		request.setAttribute("Message", msg);
			request.getRequestDispatcher("Tableau.jsp").forward(request, response);

		}


	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDao dao = new EmployeeDao();
		DepartmentDao daod = new DepartmentDao();
		
		String fn = request.getParameter("firstName");
		String ln = request.getParameter("lastName");
		String title = request.getParameter("title");	
        Date date = new Date();
        String dept = request.getParameter("dept");
        Department dpt = daod.findByName(dept);
        log.info(dpt);

		Employee emp = new Employee(fn,ln, title, date, dpt);
		
		int id = (int) dao.save(emp);
		request.setAttribute("Message", "employe numero : "+id+" bien enregistré");
		doGet(request, response);


	}
	

}
