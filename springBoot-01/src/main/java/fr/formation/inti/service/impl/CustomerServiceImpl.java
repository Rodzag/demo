package fr.formation.inti.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.CustomerDao;
import fr.formation.inti.entity.Customer;
import fr.formation.inti.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public Integer saveCustomer(Customer cust) {
		return customerDao.save(cust).getCustId();
	}

	@Override
	public void updateCustomer(Customer cust) {
		customerDao.save(cust);
		
	}

	@Override
	public void deleteCustomer(Customer cust) {
		customerDao.delete(cust);
		
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerDao.deleteById(id);
		
	}

	@Override
	public Optional<Customer> findById(Integer id) {	
		return customerDao.findById(id);
	}

	@Override
	@Transactional
	public List<Customer> findByState(String state) {

		return customerDao.findByState(state);
	}

	/**
	 *  customer with fedId xxx-xx-xxxx
	 */
		
	@Override
	public List<Customer> findByFedId(String fedId) {
		return customerDao.findByFedId(fedId);
	}

	/**
	 *  trouver meme avec un bout d'adress
	 */
	
	@Override
	@Transactional
	public List<Customer> findByAddress(String address) {
		return customerDao.findByAddress(address);
	}



}
