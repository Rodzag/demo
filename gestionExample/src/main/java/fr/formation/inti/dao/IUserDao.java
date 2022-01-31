package fr.formation.inti.dao;

import fr.formation.inti.entity.User;

public interface IUserDao extends IGenericDao<User, Integer>{

	User findByLoginAndPassword(String login, String password) ;
}
