package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entity.Employee;

public interface IEmployeeService {

Integer save(Employee employee);
	
	void update(Employee employee);
	
	void delete(Integer id);
	
	Employee findById(Integer id);
	
	List<Employee> findAll();

}
