package com.ppusari.my.spring.controller.redirect;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping("redirect/studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model){
		
		String id = httpServletRequest.getParameter("id");
		if(id.equals("ppusari")){
			return "redirect:studentOk";	// redirect: 자신의 java페이지에서 검색하여 호출되는 형태		
		}
		
		return "redirect:studentNg";
	}
	
	@RequestMapping("redirect/studentOk")
	public String studentOk(Model model){
		return "spring/redirect/studentOk";
	}
	
	@RequestMapping("redirect/studentNg")
	public String studentNg(Model model){
		return "spring/redirect/studentNg";
	}
		
	/*전혀 다른 풀패스를 줄 수도 있다.*/
	@RequestMapping("redirect/naver")
	public String naver(Model model){
		return "redirect:http://naver.com";	// 풀패스를 호출함
	}

	
}
