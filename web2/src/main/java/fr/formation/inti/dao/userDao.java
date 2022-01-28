package fr.formation.inti.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.query.Query;

import fr.formation.inti.entity.user;

public class userDao extends GenericDaoHibernate<user, Integer> {
	private static final Log log = LogFactory.getLog(userDao.class);


	public user login(String login, String passWord) {
		beginTransaction();
		user user = null;

		String hql = "select user from user user where user.login=:login";
		@SuppressWarnings("unchecked")
		Query<user> query = session.createQuery(hql);
		query.setParameter("login", login);

		List<user> users = query.getResultList();

		for (user u : users) {
			if (passWord.equals(u.getPassWord())) {
				log.info("------------->" + u);
				user = u;
				session.getTransaction().commit();
				return user;
			}

		}
		return user;
	}
	
	
	public Integer save(user u) {
		log.info("persisting Employee instance");
		try {
			beginTransaction();
			session.persist(u);
			Integer id = u.getUserId();
			log.info("persist successful");
			session.getTransaction().commit();
			return id;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
}
