package edu.deakin.sit218.examgeneration.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	protected static Logger logger= LogManager.getLogger(HomeController.class);

	@GetMapping("/")
	public String showHome() {
		 Authentication LoginUser = SecurityContextHolder.getContext().getAuthentication();
	     String userName = LoginUser.getName();
	     logger.info("log in: " + userName);
		
		return "home";
	}
}
