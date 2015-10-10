package com.ppusari.my.security;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("/login")
	public String login(Locale locale, Model model){
		logger.info("/security/login");
		return "security/login";
	}
	
	@RequestMapping("/welcome")
	public String welcome(Locale locale, Model model){
		logger.info("/security/welcome");
		return "security/welcome";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm(Locale locale, Model model){
		logger.info("/security/loginForm");
		return "security/loginForm";
	}
}
