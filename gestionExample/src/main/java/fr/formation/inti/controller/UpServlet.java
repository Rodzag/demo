package fr.formation.inti.controller;

import java.io.IOException;
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
@WebServlet("/up")
public class UpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(UpServlet.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forword = request.getParameter("i");

		EmployeeDao dao = new EmployeeDao();
		DepartmentDao daod = new DepartmentDao();
		
		Employee emp = dao.findById(Integer.valueOf(forword));
		

		request.setAttribute("id", emp.getEmpId());
		request.setAttribute("firstName", emp.getFirstName());
		request.setAttribute("lastName", emp.getLastName());
		request.setAttribute("title", emp.getTitle());
		request.setAttribute("dept", emp.getDepartment().getName());
	
		List<Department> list=daod.findAll();

		request.setAttribute("list", list);

		request.getRequestDispatcher("Up.jsp").forward(request, response);

		}


	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDao dao = new EmployeeDao();
		DepartmentDao daod = new DepartmentDao();
		
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
		String dept=request.getParameter("dept");
		
		Department dpt = daod.findByName(dept);
		if(dpt!=null) {
			emp.setDepartment(dpt);
		}
		

		dao.update(emp);

		request.setAttribute("Message", "employe numero : "+id+" bien modifie");
		response.sendRedirect("/gestionExample/new?msg="+id);
	}
	
	}

