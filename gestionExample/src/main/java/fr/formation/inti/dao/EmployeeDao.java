package fr.formation.inti.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entity.Employee;

@Repository
public class EmployeeDao extends GenericDaoHibernate<Employee, Integer> implements IEmployeeDao {
	private final static Log log =LogFactory.getLog(EmployeeDao.class);
	
	public EmployeeDao() {
		log.info("---------> create new employeeDao");
	}
	
	public static EmployeeDao createInstance() {
		log.info("--------------> create new EmpoyeeDao by factory-method");
		return new EmployeeDao();
	}
}
