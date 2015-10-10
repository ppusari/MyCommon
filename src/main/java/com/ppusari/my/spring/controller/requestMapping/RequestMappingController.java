package com.ppusari.my.spring.controller.requestMapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*컨트롤러를 만들때 클래스 이름이 같으면 500 에러 발생됨*/
@Controller
@RequestMapping("requestMapping")
public class RequestMappingController {
		
	/*#3-1*/
	@RequestMapping("index")
	public String goIndex(){
		return "spring/requestMapping/index";
	}
 	
	// requestMapping/index.jsp Form 테그에서 전달됨   (#3-3-1 GET방식은 이곳으로 받고)
	@RequestMapping(method = RequestMethod.GET, value = "student") 
	public String goStudent(HttpServletRequest httpServletRequest, Model model){	
		String id = httpServletRequest.getParameter("id");
		model.addAttribute("studentId",id);		
		return "spring/requestMapping/studentView";
	} 
	
	// requestMapping/index.jsp Form 테그에서 전달됨  (#3-3-2 POST 방식은 이곳으로 받음)
	@RequestMapping(method = RequestMethod.POST, value = "student") 
	public ModelAndView  goStudent(HttpServletRequest httpServletRequest){	
		String id = httpServletRequest.getParameter("id");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("spring/requestMapping/studentView");
		mv.addObject("studentId",id);	
		return mv;		
	}  
	
}
