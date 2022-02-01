package fr.formation.inti.entity;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DEPT_ID", unique = true, nullable = false)
	private Integer deptId;
	@Column(name = "NAME", nullable = false, length = 20)
	private String name;

	public Department() {
	}

	public Department(String name) {
		this.name = name;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + "]";
	}
	
	
}