package fr.formation.inti.dao;


import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.utils.HibernateUtils;

/**
 * save = saveOrUpdate - persist - merge - clear
 * find - load - get - delete - remove - refresh
 * @author degra
 *
 */

public class EmployeeImpl implements IEmployeeDao{

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
	public List<Employee> findAll() {
		log.info("find all");
	String hql = "select e from "+Employee.class.getName()+" e";

		
		Query<Employee> query = session.createQuery(hql);
		
		List<Employee> datas = query.getResultList();
		for (Employee e : datas) {
			log.info("------------->"+e);
			
		}

		return datas;
	}

	@Override
	public Employee findById(Integer Id) {
		log.info("getting Employee instance with id: " + Id);
		try {
			String hql = "select e from "+Employee.class.getName()+" e where e.empId = :empId";
			
			
			Query<Employee> query = session.createQuery(hql);
			query.setParameter("empId", Id);
			
			Employee emp = query.getSingleResult();
			
			log.info("------------->"+emp);
			if (emp == null) {
				log.info("get successful, no instance found");
			} else {
				log.info("get successful, instance found");
			}
			return emp;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void delete(Integer empId) {

		log.info("deleting Employee instance");
		try {
			Employee e = findById(empId);
			sf.getCurrentSession().delete(e);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		
	}

	@Override
	public void update(Employee e1) {
		log.info("deleting Employee instance");
		try {
			sf.getCurrentSession().update(e1);;
			log.info("update data successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		
		
	}

	@Override
	public Integer save(Employee e) {
		log.info("persisting Employee instance");
		try {
			
			session.persist(e);
			Integer id = e.getEmpId();
			log.info("persist successful");
			return id;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	
	public Employee merge(Employee e) {
		log.info("merging Employee instance");
		try {
			
			Employee result = (Employee) sf.getCurrentSession().merge(e);
			log.info("merge successful");

			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public void detach(Employee e) {
		log.info("detach Employee instance");
		try {
			
			sf.getCurrentSession().detach(e);
			log.info("detach successful");

		} catch (RuntimeException re) {
			log.error("detach failed", re);
			throw re;
		}
	}
	
	
	public void close() {
		session.close();
		sf.close();
	}
	
	public void commit() {
		session.getTransaction().commit();
	}
	
	public void begin() {
		session.getTransaction().begin();
	}
	
	public void isManaged(Employee e) {
		
	
	}

}
