package fr.formation.inti.service;

import fr.formation.inti.entity.User;

public interface IUserService {
	
	
	User findByLoginAndPassword(String login, String password) ;
	
	Integer ajouterUser(User user);

}
