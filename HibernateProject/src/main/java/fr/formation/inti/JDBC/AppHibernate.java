package fr.formation.inti.JDBC;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import fr.formation.inti.dao.EmployeeImpl;
import fr.formation.inti.dao.IEmployeeDao;
import fr.formation.inti.entity.Employee;
import fr.formation.inti.entity.EmployeeInfos;
import fr.formation.inti.utils.HibernateUtils;

public class AppHibernate {

	private static final Log log = LogFactory.getLog(AppHibernate.class);
	
	
		

	
	public static void main(String[] args) {
		EmployeeImpl dao = new EmployeeImpl();
		Employee e = new Employee();
		
		dao.begin();
		//queryObject();
		//queryColumn();
		//queryShortInfoEmployee();
		//queryUnique();
		dao.findAll();
		dao.findById(15);
		dao.save(e);
		Integer id = e.getEmpId();
		log.info(id);
		dao.detach(e);
		dao.merge(e);
		e.setFirstName("bastien");
		dao.update(e);
		dao.findById(id);
		dao.delete(id);
		dao.commit();
		dao.close();
		
		log.info("fin de programme");
		
	}
	
	public static void queryObject() {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		String hql = "select e from "+Employee.class.getName()+" e where e.department.deptId=:deptId order by e.firstName";
		
		session.getTransaction().begin();
		
		Query<Employee> query = session.createQuery(hql);
		query.setParameter("deptId", 2);
		
		List<Employee> employees = query.getResultList();
		
		for (Employee e : employees) {
			log.info("------------->"+e);
			
		}
		session.getTransaction().commit();
		
		session.close();
		sf.close();

	}
	
	public static void queryColumn() {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		String hql = "select e.empId, e.firstName, e.lastName from "+Employee.class.getName()+" e";
		
		session.getTransaction().begin();
		
		Query<Object[]> query = session.createQuery(hql);
		
		List<Object[]> datas = query.getResultList();
		
		for (Object[] e : datas) {
			log.info("------------->"+e[0]+" "+e[1]+" "+e[2]);

		}
		session.getTransaction().commit();
		
		session.close();
		sf.close();
	}
	
	public static void queryShortInfoEmployee() {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.getCurrentSession();
		
		String hql = "select new "+EmployeeInfos.class.getName()+"(e.empId,e.firstName,e.lastName) from "+Employee.class.getName()+" e";
		
		session.getTransaction().begin();
		
		Query<EmployeeInfos> query = session.createQuery(hql);
		
		List<EmployeeInfos> employees = query.getResultList();
		
		for (EmployeeInfos e : employees) {
			log.info("------------->"+e);

		}
		session.getTransaction().commit();
		
		session.close();
		sf.close();
	}
	
	
	public static void queryUnique() {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		String hql = "select e from "+Employee.class.getName()+" e where e.empId = :empId";
		
		session.getTransaction().begin();
		
		Query<Employee> query = session.createQuery(hql);
		query.setParameter("empId", 3);
		
		Employee emp = query.getSingleResult();
		
		log.info("------------->"+emp);
			
		session.getTransaction().commit();
		
		session.close();
		sf.close();

	}

}
