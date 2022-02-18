package fr.formation.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.inti.entity.Event;

@Controller
public class IndexController {


	@GetMapping("/form")
	public String form(@ModelAttribute Event event) {
		return "form";
	}

	
	@PostMapping("/form")
	public String resutForm(Event event, Model model) {
		
		
		model.addAttribute("event", event);
		String date = event.getDate().toString();
		model.addAttribute("date", date);
		return "resultform";
	}
	

}
