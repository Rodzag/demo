package fr.formation.inti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Table base de donnée   T_User
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer userId;
	private String login;
	private String password;
	@OneToOne
	@JoinColumn(name = "emp_id")
	private Employee emp;
	@Column(name = "connection_number")
	private Integer connectionNumber;
	
	
	public User(int i, String login, String passWord) {
		super();
		this.login = login;
		this.password = passWord;
	}
	
	public User() {
	}
	
	public User(String login, String password, Integer connectionNumber) {
		super();
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
	}
	public User(Integer userId, String login, String password, Integer connectionNumber) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
	}
	
	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Integer getConnectionNumber() {
		return connectionNumber;
	}
	public void setConnectionNumber(Integer connectionNumber) {
		this.connectionNumber = connectionNumber;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return login+"   [ userid = "+userId+" ]";
	}
	
	
	
	

}
