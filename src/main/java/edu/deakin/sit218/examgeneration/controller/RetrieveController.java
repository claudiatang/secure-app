package edu.deakin.sit218.examgeneration.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.deakin.sit218.examgeneration.dao.QuestionDAO;
import edu.deakin.sit218.examgeneration.dao.QuestionDAOImpl;
import edu.deakin.sit218.examgeneration.entity.*;

@Controller
public class RetrieveController {
	
	@RequestMapping(value="/retrieve-result", method=RequestMethod.POST)
	public String result(
			@Valid @ModelAttribute("knowledgearea") KnowledgeQuery kQuery, 
			BindingResult validationErrors, Model model) {
		
		if (validationErrors.hasErrors())
			return "examgen";
		
		QuestionDAO dao = new QuestionDAOImpl();
		
		try {
			List<Question> questions = dao.retrieveQuestions(kQuery.getKnowledgearea());
//			List<String> questionStrings = Collections.<String>emptyList();
//			for(int i=0; i<questions.size(); i++) {
//				questionStrings.add(questions.get(i).toString());
//			}
			
			model.addAttribute("found", "true");
			model.addAttribute("question1", questions.get(0).toString());
			model.addAttribute("question2", questions.get(1).toString());
			model.addAttribute("question3", questions.get(2).toString());
			model.addAttribute("question4", questions.get(3).toString());
			model.addAttribute("question5", questions.get(4).toString());
			
			System.out.println(Arrays.toString(questions.toArray()));
			
		} catch (RuntimeException e) {
			 System.out.println(e.getMessage());
			 
			 model.addAttribute("found", "false");
			 model.addAttribute("message", "Queried knowledge area not found!!");
		}
		
		System.out.println("Working fine after DAO return value");
		

		return "retrieve-result";
		
	}

}
