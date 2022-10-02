package edu.deakin.sit218.examgeneration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.deakin.sit218.examgeneration.entity.*;

@Controller
public class ExamGenController {
	
	@GetMapping("/examgen")
	public String showHome(Model model) {
		//Create a question object
		KnowledgeQuery kQuery = new KnowledgeQuery();
				
		//add question object to model
		model.addAttribute("knowledgearea", kQuery);
		
		return "examgen";
	}
}
