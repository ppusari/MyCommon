package com.ppusari.my.spring.controller.modelAttribute;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modelAttribute")
public class ModelAttributeController {

	@RequestMapping("/index")
	public String index(){
		return "spring/modelAttribute/index"; // 
	}	
	
	// studentDisplay에서 사용할 객체 studentInformation 을 si로 변경함. (#4-1 si로 정의 했기때문에)
	@RequestMapping("/studentDisplay")
	public String studentView(@ModelAttribute("si") StudentInformation studentInformation){
		return "spring/modelAttribute/studentDisplay";
	}
}
