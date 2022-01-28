package fr.formation.inti.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.inti.entity.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/emp")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String name = request.getParameter("name");
		
		request.setAttribute("firstName", firstName);
		request.setAttribute("name", name);
		request.getRequestDispatcher("jspEL.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String name = request.getParameter("name");
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setName(name);
		
		request.setAttribute("firstName", firstName);
		request.setAttribute("name", name);
		request.setAttribute("employee", emp);
		request.setAttribute("message", "Hello ");
		request.getRequestDispatcher("jspEL.jsp").forward(request,response);
	}

}
