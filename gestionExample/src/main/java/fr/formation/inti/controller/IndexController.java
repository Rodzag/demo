package fr.formation.inti.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.entity.User;
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.UserService;

@Controller
public class IndexController {
	
	EmployeeService Eservice;
	UserService Uservice;
	
//	@Autowired
//	private ValidatorEmployee employeeValidator;
//	
//	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
		
//		Object target = binder.getTarget();
//		if(target == null) {
//			return;
//		}
//		if(target.getClass() == Employee.class) {
//			binder.setValidator(employeeValidator);
//		}

	
	  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
	  binder.registerCustomEditor(Date.class, orderDateEditor);
	}
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("userhome","user", new User());
		mv.setViewName("index");
		return mv;
	}

	
	
	@RequestMapping(value = {"/index"}, method = RequestMethod.POST)
	public String indexPost(Model model, @Valid @ModelAttribute("user") User user, BindingResult result ) {
		
        if (result.hasErrors()) {
		  model.addAttribute("message","Error log");
            return "index";
        }

		if("root".equals(user.getLogin())&&("123456".equals(user.getPassword()))){
			model.addAttribute("user",user);
			model.addAttribute("employee", new Employee());
			return "accueil";			
		}

		model.addAttribute("message","Erreur login ou password");
		return "index";
	}
	
//	@RequestMapping(value = {"/index"}, method = RequestMethod.POST)
//	public String indexPost(Model model, @Validated @ModelAttribute("user") User user, BindingResult result ) {
//		
//        if (result.hasErrors()) {
//		  model.addAttribute("message","Error log");
//            return "index";
//        }
//		String login = user.getLogin();
//		String pass = user.getPassword();
//        User userF = null;
//        userF =	Uservice.findByLoginAndPassword(login, pass);
//		if(!userF.equals(null)){
//			model.addAttribute("user",userF);
//			model.addAttribute("employee", new Employee());
//			return "accueil";			
//		}
//
//		model.addAttribute("message","Erreur login ou password");
//		return "index";
//	}
	
	
	@RequestMapping(value = {"/accueil"}, method = RequestMethod.GET)
	public ModelAndView accueilG() {
		
		ModelAndView mv = new ModelAndView("employeeHome","employee", new Employee());
		mv.setViewName("accueil");
		return mv;		
	}
	
	
	@RequestMapping(value = {"/accueil"}, method = RequestMethod.POST)
	public ModelAndView AccueilP() {
		
		ModelAndView mv = new ModelAndView("employeeHome","employee", new Employee());
		mv.setViewName("accueil");
		return mv;		
	}
	

	@RequestMapping(value = {"/accueilE"}, method = RequestMethod.POST)
	public String accueilEP(Model model, @Valid @ModelAttribute("employee") Employee emp, BindingResult result ) {
		
        if (result.hasErrors()) {
		  model.addAttribute("message2","Error form");
            return "accueil";
        }

        model.addAttribute("emp",emp);
			
				return "connected";

	}
	
}
	
	
		

