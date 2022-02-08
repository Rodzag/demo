package fr.formation.inti.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.inti.dao.IEmployeeDao;
import fr.formation.inti.entity.Employee;



@Repository
public class EmployeeService implements IEmployeeService{
	private final Log log = LogFactory.getLog(EmployeeService.class);

	private String message;
	
	//@Autowired
	//@Qualifier("employeeDao")
	private IEmployeeDao dao;
	

	public EmployeeService() {
		log.info("new EmployeeService()");
	}
	
	// @Autowired injection par constructeur
	public EmployeeService(IEmployeeDao dao) {
		log.info("new EmployeeService(dao)");
		
		this.dao=dao;
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

		return list;
	}

//	//Pour la config xml
	
	public IEmployeeDao getDao() {
		return dao;
	}

	@Autowired
	public void setDao(IEmployeeDao dao) {
		log.info("---------> set dao");
		this.dao = dao;
	}

	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		log.info(message);
		this.message = message;
	}
	
	@PostConstruct
	private void postConstructor() {
		log.info("------------ init :  @PostConstruct -----------");
	}
	
	@PreDestroy
	private void preDestroy() {
		log.info("------------ init :  @preDestroy destroy service -----------");
		if(dao !=null) {
			log.info("------------ dao :  @preDestroy destroy dao -----------");
			dao.close();
		}
	}
}
