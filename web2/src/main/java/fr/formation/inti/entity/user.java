package fr.formation.inti.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class user {
	private int userId;
	private String login;
	private String passWord;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "Id_user", unique = true, nullable = false)
	public int getUserId() {
		return userId;
	}
	
	@Column(name = "login", length = 20)
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Column(name = "password", length = 20)
	public String getPassWord() {
		return passWord;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "user [userId=" + userId + ", login=" + login +"]";
	}
	
	public user(int Id_user, String login, String password) {
		super();
		this.userId = Id_user;
		this.login = login;
		this.passWord = password;
	}
	
	public user() {
		
	}
	

	}
	

