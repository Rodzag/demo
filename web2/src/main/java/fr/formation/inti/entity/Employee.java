package fr.formation.inti.entity;

public class Employee {
	private String name;
	private String firstName;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", firstName=" + firstName + "]";
	}
	
	

}
