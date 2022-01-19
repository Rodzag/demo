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
import fr.formation.inti.utils.HibernateUtils;

public class GenericDaoHibernate<T,I extends Serializable> implements IGenericDao<T, I> {

	private static final Log log = LogFactory.getLog(EmployeeImpl.class);
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
	
	@SuppressWarnings("unchecked")
	@Override
	public I save(T t) {
		return (I) session.save(t);
	}

	@Override
	public void update(T t) {
		session.update(t);
	}

	@Override
	public void delete(I i) {
		session.delete(i);
	}

	@Override
	public T findById(I i) {
		return (T) session.get(this.type, i);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		String hql = "select e from "+Employee.class.getName()+" e";
		Query<Employee> query = session.createQuery(hql);
		List<Employee> datas = query.getResultList();
		return (List<T>) datas;
	}
	
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

}
