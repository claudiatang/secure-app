package edu.deakin.sit218.examgeneration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.deakin.sit218.examgeneration.entity.Question;





@Controller
public class QuestionAnswerController {
	@GetMapping("/question-answer")
	public String showHome(Model model) {
		//Create a question object
		Question question = new Question();
		
//		//add question object to model
		model.addAttribute("question", question);
		return "question-answer";
	}
}






