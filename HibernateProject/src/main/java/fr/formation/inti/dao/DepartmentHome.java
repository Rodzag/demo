package fr.formation.inti.dao;
// Generated 18 janv. 2022 � 15:51:09 by Hibernate Tools 4.3.5.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import fr.formation.inti.entity.Department;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Department.
 * @see fr.formation.inti.dao.Department
 * @author Hibernate Tools
 */
public class DepartmentHome {

	private static final Log log = LogFactory.getLog(DepartmentHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Department transientInstance) {
		log.debug("persisting Department instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Department instance) {
		log.debug("attaching dirty Department instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Department instance) {
		log.debug("attaching clean Department instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Department persistentInstance) {
		log.debug("deleting Department instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Department merge(Department detachedInstance) {
		log.debug("merging Department instance");
		try {
			Department result = (Department) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Department findById(java.lang.Integer id) {
		log.debug("getting Department instance with id: " + id);
		try {
			Department instance = (Department) sessionFactory.getCurrentSession()
					.get("fr.formation.inti.dao.Department", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Department> findByExample(Department instance) {
		log.debug("finding Department instance by example");
		try {
			List<Department> results = (List<Department>) sessionFactory.getCurrentSession()
					.createCriteria("fr.formation.inti.dao.Department").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
