package fr.formation.inti.service;

import fr.formation.inti.dao.EmployeeImpl;

import fr.formation.inti.entity.Employee;

public class EmployeeService {
	
	private EmployeeImpl dao = new EmployeeImpl();
	
	public Integer ajouterEmployee(Employee emp) {
		
		dao.beginTransaction();
		Integer empId = dao.save(emp);
		dao.commitTransaction();
		return empId;
	}

}
