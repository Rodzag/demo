package fr.formation.inti.controller;

import java.util.Properties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.entity.User;
import fr.formation.inti.service.IEmployeeService;

@Controller
public class IndexController {
	
	
	@SuppressWarnings("unused")
	@Autowired
	private IEmployeeService service;
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		//model.addAttribute("message","Hello Spring MVC");
	//	model.addAttribute("user", new User("root", "123456", 3));

		return "index";
	}
	
	@RequestMapping(value = {"/index"}, method = RequestMethod.POST)
	public String indexPost(Model model,
			@RequestParam("login") String log,
			@RequestParam("passWord") String pass) {
		
		if("root".equals(log)&&"123456".equals(pass)) {
			model.addAttribute("log",log);
			return "accueil";			
		}

		model.addAttribute("message","Erreur login ou password");
		return "index";
	}
	
	@RequestMapping(value = {"/index2"}, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new User("root2", "123456", 3));
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value = {"/accueil"}, method = RequestMethod.POST)
	public String indexPost(Model model,@RequestParam("login") String log) {
		
		

			model.addAttribute("log",log);
			return "accueil";			
		}

	}
		

