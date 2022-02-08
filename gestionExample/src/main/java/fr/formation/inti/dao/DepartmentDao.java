package fr.formation.inti.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.query.Query;

import fr.formation.inti.entity.Department;

public class DepartmentDao extends GenericDaoHibernate<Department, Integer> implements IDepartmentDao {
	public static final Log log = LogFactory.getLog(DepartmentDao.class);

	@Override
	public Department findByName(String name) {
		try {

			Query<Department> query = getCurrentSession().createQuery(
					"from " + Department.class.getName() + " d where d.name= :name", Department.class);
			query.setParameter("name", name);

		return query.getSingleResult();

		} catch (Exception e) {

			log.info("-------------------> findbyname failed");
			log.error(e.getStackTrace());
			return null;
		}
	}
	
	
}
