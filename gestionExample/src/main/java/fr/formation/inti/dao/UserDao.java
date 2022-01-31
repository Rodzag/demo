package fr.formation.inti.dao;

import org.hibernate.query.Query;

import fr.formation.inti.entity.User;

public class UserDao extends GenericDaoHibernate<User, Integer> implements IUserDao {

	public User findByLoginAndPassword(String login, String password) {
		beginTransaction();
		try {
			
		Query<User> query = session.createQuery(
				"from " + User.class.getName() + " u where u.login= :login and u.password = :pass", User.class);
		query.setParameter("login", login);
		query.setParameter("pass", password);

		return query.getSingleResult();
		
		} catch (Exception e) {
			return null;
		}

	}

}
