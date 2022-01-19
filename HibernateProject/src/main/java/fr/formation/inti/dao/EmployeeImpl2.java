package fr.formation.inti.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.utils.HibernateUtils;

public class EmployeeImpl2 implements IEmployeeDao{

	private static final Log log = LogFactory.getLog(EmployeeImpl.class);
	SessionFactory sf = HibernateUtils.getSessionFactory();
	Session session = sf.getCurrentSession();
	private Transaction tx = session.getTransaction();
	
	public void beginTransaction() {
		if(!tx.isActive())
			tx = session.beginTransaction();
	}
	
	public void commitTransaction() {
		tx.commit();
	}
	
	public void rollBackTransaction() {
		tx.rollback();
	}
	
	@Override
	public Integer save(Employee t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(Employee t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Integer i) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Employee findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
