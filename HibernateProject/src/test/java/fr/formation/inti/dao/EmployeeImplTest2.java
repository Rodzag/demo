package fr.formation.inti.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import fr.formation.inti.entity.Employee;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeImplTest2 {
	
	private static final Log log = LogFactory.getLog(EmployeeImplTest2.class);
	
	private static SessionFactory sf;
	private static Session session;
	private static Transaction tx;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Create Service Registry for hibernate.cfg.xml
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.test.cfg.xml").build();
				
				// Create MetaData :
				
				Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
				
				sf = metadata.getSessionFactoryBuilder().build();
				
				assertNotNull(sf);
				session = sf.getCurrentSession();
				assertNotNull(session);
				tx = session.getTransaction();
				log.info("-------------------------------- open session -------------------------------------");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		session.close();
		sf.close();
	}

	@SuppressWarnings("static-access")
	@Before
	public void setUp() throws Exception {
		log.debug("--------------------------------------------------------------------");
		if (!session.isOpen()) {
			session = sf.openSession();
		}
		if (!tx.isActive()) {
			session.beginTransaction();
		}
		tx = session.getTransaction();
		log.debug("--------------------- Start transaction ----------------------------------------");
	}

	@SuppressWarnings("static-access")
	@After
	public void tearDown() throws Exception {
		log.debug("--------------------------------fin----------------------------------");
		tx.commit();
		
	}

	@Test
	public void test1Save() throws ParseException {
		log.debug("-------------------------------save------------------------------------");
		String startDate = "1997-12-23";
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = formatter.parse(startDate);
		log.debug("date :"+sdate);
//		Integer empID = 405;
		String lastName = "Smith";
		String firstName = "John";
		Employee e = new Employee(lastName, firstName, sdate);
		Serializable idAfterInsert = session.save(e);
		log.debug(" ----- id after insert :"+idAfterInsert);
		assertNotNull("If the employee was inserted into the database, its EMP_ID is not null : ", idAfterInsert);
		assertEquals(idAfterInsert, 1);
	}

	@Test
	public void test3Update() {
		log.debug("-------------------------------update------------------------------------");
		Employee emp = session.find(Employee.class, 1);
		assertNotNull(emp);
		emp.setFirstName("yahya");		
		session.update(emp);
		Employee empAfterUpdate = session.find(Employee.class, 1);
		assertEquals("The updated name of the employee designed by the given ID should be the one given : ",emp.getFirstName(), empAfterUpdate.getFirstName());
	}

	@Test
	public void test5Delete() {
		log.debug("-------------------------------delete------------------------------------");
		Employee e  = session.find(Employee.class, 1);
		assertNotNull(e);
		session.delete(e);
		Employee eAfterDelete = null;
		if (session.contains(e)) {
			eAfterDelete = e;
		}
		assertNull("Employee deleted should be null : ", eAfterDelete);
	}

	@Test
	public void test2FindById() {
		log.debug("-------------------------------FindByID------------------------------------");
		Employee emp = null;
		List<Employee> liste;
		String hql = "select e from " + Employee.class.getName() + " e where e.empId = :empId";
		@SuppressWarnings("unchecked")
		Query<Employee> query = session.createQuery(hql ) ;
		query.setParameter("empId", 1);
		liste = query.getResultList();
		if (!liste.isEmpty()) {
			emp = liste.get(0);
		}
		assertNotNull("Employee found by Id should not be null : ", emp);
	}

	@Test
	public void test4FindAll() {
		List<Employee> employees = null;
		String hql = "select e from " + Employee.class.getName() + " e";
		
		// Query
		
		@SuppressWarnings("unchecked")
		Query<Employee> query = session.createQuery(hql) ;
		employees = query.getResultList();
		
		for (Employee e : employees) {
			log.debug(e);
		}
		assertNotNull("The list of Employees should not be null :", employees);
		assertEquals("The size of the list should be equal to the size of the Database : ", 1, employees.size());
	}

}
