package fr.formation.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entity.Customer;
import fr.formation.inti.entity.Employee;
import fr.formation.inti.entity.Greeting;
import fr.formation.inti.service.CustomerService;

@Controller
public class IndexController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/greeting")
	public String greetingForm(@ModelAttribute Greeting greeting) {	
		return "greeting";
	}

	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
		model.addAttribute("greeting", greeting);
		return "result";
	}
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String loopMethod(Model model) {
		model.addAttribute("message","Hello Spring Boot!!");
		List<String> list = new ArrayList<String>();
		list.add("patrick");
		list.add("bastien");
		list.add("yahya");
		model.addAttribute("list", list);
		
		
		return "index";
	}
	
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
	public String listEmployee(Model model) {
		
		Employee e1 = new Employee(1, "nom1", "nom1");
		Employee e2 = new Employee(2, "nom2", "nom2");
		Employee e3 = new Employee(3, "nom3", "nom3");
		Employee e4 = new Employee(4, "nom4", "nom4");
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		model.addAttribute("listEmployee", list);
		
		
		return "index";
	}
	
	@RequestMapping(value = {"/listCustomer"}, method = RequestMethod.GET)
	public String listCustomer(Model model) {
		
		List<Customer> list = customerService.findAll();
		
		model.addAttribute("listCustomer", list);	
		return "index";
	}
	
	@RequestMapping(value = {"/listByState"}, method = RequestMethod.POST)
	public String listCustomerState(Model model,@RequestParam String state) {
		
		List<Customer> list = customerService.findByState(state);
		
		model.addAttribute("listByState", list);	
		return "index";
	}
	
	@RequestMapping(value = {"/listByFedId"}, method = RequestMethod.POST)
	public String listCustomerFed(Model model,@RequestParam String fedId) {
		
		List<Customer> list = customerService.findByFedId(fedId);
		
		model.addAttribute("listByFedId", list);	
		return "index";
	}
	
	@RequestMapping(value = {"/listByAddress"}, method = RequestMethod.POST)
	public String listCustomerAddress(Model model,@RequestParam String address) {
		
		List<Customer> list = customerService.findByAddress(address);
		
		model.addAttribute("listByAddress", list);	
		return "index";
	}

}
