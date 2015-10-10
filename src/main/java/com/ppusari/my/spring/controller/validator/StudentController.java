package com.ppusari.my.spring.controller.validator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("/validator/studentForm")
	public String studentForm() {
		return "spring/validator/createPage";
	}
	
	@RequestMapping("/validator/student/create")
	public String studentCreate(@ModelAttribute("student") Student student, BindingResult result){
		String page = "spring/validator/createDonePage";
		
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		if (result.hasErrors()){
			page = "spring/validator/createPage";
		}
		 
		return page;
	}
}
