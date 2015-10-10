package com.ppusari.my.spring.controller.initBinder;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/* Pom.xml 에 아래 의존추가 
 * 
 * <dependency>
 *   <groupId>org.hibernate</groupId>
 *   <artifactId>hibernate-validator</artifactId> 
 *   <version>4.2.0.Final</version>
 * </dependency>
*/


@Controller
@RequestMapping("/initBinder")
public class Student2Controller {

	@RequestMapping("/studentForm")
	public String studentForm() {
		return "spring/initBinder/createPage";
	}
	
	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") @Valid Student student, BindingResult result){
		String page = "spring/initBinder/createDonePage";
	
// 아래 두줄을 이용하여 호출하지 않고 아래 @InitBinder 가 대신 호출해준다.	
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result);
		if (result.hasErrors()){
			page = "spring/initBinder/createPage";
		}
		 
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new StudentValidator());
	}
}
