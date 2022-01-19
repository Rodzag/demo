package fr.formation.inti.JDBC;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.dao.EmployeeDaoImpl;
import fr.formation.inti.entity.Employee;

public class App {
	private static final Log log = LogFactory.getLog(App.class);
    public static void main( String[] args ) {

      Employee emp = new Employee("Bastien","degraeve","stagiaire");
      EmployeeDaoImpl dao = new EmployeeDaoImpl();
      dao.beginTransaction();
      Integer id = dao.save(emp);
      log.info(dao.findById(id));
      dao.commitTransaction();
      log.info("fin");
    
    }
}
