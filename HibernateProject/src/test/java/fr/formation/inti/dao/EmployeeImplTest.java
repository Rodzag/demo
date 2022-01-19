package fr.formation.inti.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

import fr.formation.inti.entity.Employee;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeImplTest  {

	private static EmployeeImpl dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new EmployeeImpl();
		dao.begin();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao.commit();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test3FindAll() {
		
		List<Employee> list = dao.findAll();
		assertEquals(list.size(),39);
	}

	@Test
	public void test2FindById() {
		Employee emp = dao.findById(1);
		int id = emp.getEmpId();
		assertEquals(id, 1);
	}

	@Test
	public void test6Delete() {
		Employee e = new Employee("bastien", "degraeve", "stagiaire");
		Integer empIdInsered = dao.save(e);
		List<Employee> list = dao.findAll();

		dao.delete(empIdInsered);

		List<Employee> listAfterInsert = dao.findAll();
		assertEquals(list.size() - 1, listAfterInsert.size());
	}
	

	@Test
	public void test4Update() {
		Employee emp = dao.findById(178);
		assertNotNull(emp);
		emp.setFirstName("yahya");
		dao.update(emp);
		Employee empAfterUpdate = dao.findById(178);
		assertEquals(emp.getFirstName(), empAfterUpdate.getFirstName());
	}

	@Test
	public void test1Save() {
		List<Employee> list = dao.findAll();

		Employee e1 = new Employee("bastien", "degraeve", "stagiaire");
		Integer empIdInsered = dao.save(e1);
		assertNotNull(empIdInsered);

		List<Employee> listAfterInsert = dao.findAll();
		assertEquals(list.size() + 1, listAfterInsert.size());
		dao.delete(empIdInsered);
	}

	@Test
	public void test5Merge() {
		

		Employee e1 = new Employee("bastien", "degraeve", "stagiaire");
		Integer empIdInsered = dao.save(e1);
		assertNotNull(empIdInsered);
		
		dao.merge(e1);

		dao.delete(empIdInsered);
	}

	@Test
	public void test6Detach() {
		

		Employee e1 = new Employee("bastien", "degraeve", "stagiaire");
		Integer empIdInsered = dao.save(e1);
		assertNotNull(empIdInsered);

		dao.detach(e1);
		e1.setFirstName("coucou");
		dao.update(e1);
		Employee e2 = dao.findById(empIdInsered);
		assertNotNull(e1.getFirstName(),e2.getFirstName());
		
		
	
		dao.delete(empIdInsered);
	}

}
