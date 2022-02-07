package fr.formation.inti.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.IEmployeeDao;
import fr.formation.inti.entity.Employee;



@Service
public class EmployeeService implements IEmployeeService{
	private final Log log = LogFactory.getLog(EmployeeService.class);

	@Autowired
	//@Qualifier
	private IEmployeeDao dao;
	
	public EmployeeService() {
		log.info("new EmployeeService()");
	}
	
	@Override
	public Integer save(Employee employee) {
		dao.save(employee);
		return null;
	}

	@Override
	public void update(Employee employee) {
		dao.update(employee);
		
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
		
	}

	@Override
	public Employee findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Employee> findAll() {

		List<Employee> list = dao.findAll();
		dao.close();

		return list;
	}

	public IEmployeeDao getDao() {
		return dao;
	}

	public void setDao(IEmployeeDao dao) {
		this.dao = dao;
	}

	
}
