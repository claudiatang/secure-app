package edu.deakin.sit218.examgeneration.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.deakin.sit218.examgeneration.dao.QuestionDAO;
import edu.deakin.sit218.examgeneration.dao.QuestionDAOImpl;
import edu.deakin.sit218.examgeneration.entity.Question;

@Controller
public class LecturerController {

	@RequestMapping("/submission-result")
	public String result(
			@Valid @ModelAttribute("question") Question question, 
			BindingResult validationErrors, Model model) {
		//Input validation
		if (validationErrors.hasErrors())
			return "question-answer";

		//Retrieve question object from database
		
		//Check whether the question doesn't exist
		QuestionDAO dao = new QuestionDAOImpl(); 
		if (!dao.existsQuestion(question)) {
			dao.insertQuestion(question);

			model.addAttribute("message", "New Question Added");
			model.addAttribute("message_q", "Question: " + question.getQuestioncontent());
			model.addAttribute("message_a", "Answer: "+ question.getAnswer());
			model.addAttribute("message_k", "Knowledge Area: " + question.getKnowledgearea());
		}
		
		//This question is identical to a row in the database
		else {
			question = dao.retrieveQuestion(question);

			model.addAttribute("message", "Existing Question");
			model.addAttribute("message_q", "Question: " + question.getQuestioncontent());
			model.addAttribute("message_a", "Answer: "+ question.getAnswer());
			model.addAttribute("message_k", "Knowledge Area: " + question.getKnowledgearea());
		}
		
		//Sync Question object with database
		dao.updateQuestion(question);
		
		//Return the View 
		return "submission-result";
	}
	
}
