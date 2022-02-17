package fr.formation.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.inti.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c WHERE c.state LIKE ?1")
	List<Customer> findByState(String state);

	@Query("SELECT c FROM Customer c WHERE c.fedId LIKE %?1% and c.fedId LIKE '%-__-%'")
	List<Customer> findByFedId(String fedId);
	
	@Query("SELECT c FROM Customer c WHERE c.address LIKE %?1%" )
	List<Customer> findByAddress(String address);
}
