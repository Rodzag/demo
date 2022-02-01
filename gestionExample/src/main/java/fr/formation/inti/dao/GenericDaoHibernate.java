package fr.formation.inti.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.entity.User;
import fr.formation.inti.utils.HibernateUtils;

public class GenericDaoHibernate<T,I extends Serializable> implements IGenericDao<T, I> {
	
	private static final Log log = LogFactory.getLog(GenericDaoHibernate.class);

	SessionFactory sf = HibernateUtils.getSessionFactory();
	Session session = sf.getCurrentSession();
	private Transaction tx = session.getTransaction();
	
	private final Class<T> type;
	
	@SuppressWarnings("unchecked")
	public GenericDaoHibernate() {
		this.type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	
	
	public GenericDaoHibernate(Class<T> type) {
		this.type = type;
	}
	
	
	public Integer register(User u) {
		log.info("persisting Employee instance");
		try {
			beginTransaction();
			session.persist(u);
			Integer id = u.getUserId();
			log.info("persist successful");
			commitTransaction();
			return id;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	
	public void del(Employee emp) {
		log.info("del Employee instance");
		try {
			beginTransaction();
			session.delete(emp);
			commitTransaction();
			log.info("del successful");

		} catch (RuntimeException re) {
			log.error("del failed", re);
			throw re;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public I save(T t) {
		beginTransaction();
		I id = (I) session.save(t);
		commitTransaction();
		return (I) id; 
	}

	public void update(T t) {
		beginTransaction();
		session.update(t);
		commitTransaction();
	}


	public void delete(I i) {
		beginTransaction();
		session.delete(i);
		commitTransaction();
		
	}


	public T findById(I i) {
		beginTransaction();
		T u = (T) session.get(this.type, i);

		return (T) u;
	}

	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		beginTransaction();
		String hql = "select e from "+this.type.getName()+" e";
		Query<T> query = session.createQuery(hql);
		List<T> datas = query.getResultList();
		commitTransaction();
		return datas;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findCherche(String chr) {
		beginTransaction();
		String hql = "select e from "+this.type.getName()+" e where first_Name like ('%"+chr+"%')"
				+ " or last_name like ('%"+chr+"%') or emp_id like ('%"+chr+"%') or title like('%"+chr+"%') or start_date like('%"+chr+"%')";
		Query<T> query = session.createQuery(hql);
		List<T> datas = query.getResultList();
		commitTransaction();
		return datas;
	}
	
	public void beginTransaction() {
		if(!session.isOpen())
			session = sf.openSession();
		if(!tx.isActive())
			tx = session.beginTransaction();
	}
	
	public void commitTransaction() {
		tx.commit();
		session.close();
	}
	
	public void rollBackTransaction() {
		tx.rollback();
	}

	public void close() {
		sf.close();
	}
}
