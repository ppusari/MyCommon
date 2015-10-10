package com.ppusari.my.spring.controller.basic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/* #2 클래스 전체 */
@Controller	// 클래스를 따로 만들어서 @Controller을 선헌하면 사용할 수 있다.
@RequestMapping("basic")  // 클래스 위에 선언하면 아래 함수들은 모두 앞에 prefix로  /basic 가 붙는다
public class MyController {
	
	@RequestMapping("view")	// #1-5 http://localhost:8888/mvc/basic/view 주소로 접근하면
	public String view(){
		return "spring/basic/view"; // #1-6 basic/view.jsp 에 전달된다.
	}
	
	@RequestMapping("content")	// http://localhost:8888/mvc/basic/content
	public String content(Model model){
		model.addAttribute("id", 30);
		return "spring/basic/content";
	}
	
	@RequestMapping("reply")	// http://localhost:8888/mvc/basic/reply
	public ModelAndView reply(){
		ModelAndView mv = new ModelAndView();	// Model 인자를 받지 않고 사용하는 방법
		mv.addObject("id", 30);
		mv.setViewName("basic/reply");
		return mv;		
	}	

	@RequestMapping("confirmid") // http://localhost:8888/mvc/basic/confirmid?id=ppusari&pw=1234
	public String confirmid(HttpServletRequest httpServletRequest, Model model){
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "spring/basic/confirmid";
	}
	
	// @ 에노테이션을 이용하여 받아오는 방법 (주소 파라미터값이 없으면 400 에러가 난다)
	@RequestMapping("checkid") // http://localhost:8888/mvc/basic/checkid?id=test&pw=12345
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model){

		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		return "spring/basic/checkid";
	}
	
/*	@RequestMapping("/member/join") // http://localhost:8888/mvc/basic/join?name=1&id=test&pw=2&email=3
	public String joinData(@RequestParam("name") String name, 
							@RequestParam("id") String id,
							@RequestParam("pw") String pw,
							@RequestParam("email") String email,
							Model model){		
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);		
		model.addAttribute("member", member);				
		return "basic/join";
	}
*/	
	// 위처럼 해야할 것을 아래처럼 간단하게 할 수 있다.
	@RequestMapping("join") // http://localhost:8888/mvc/basic/join?name=조병국&id=ppusari&pw=1234&email=ppusari@gmail.com
	public String joinData(Member member){
		return "spring/basic/join";
	}
	
	// @PathVariable 어노테이션을 이용하면 경로에 변수를 넣어 요청메소드에서 파라미터로 이용 할 수 있다 ( 자주 쓰이는 방법은 아니다 ) 
	@RequestMapping("student/{id}")	// http://localhost:8888/mvc/basic/student/8
	public String getStudent(@PathVariable String id, Model model){
		model.addAttribute("id", id);
		return "spring/basic/student";
	}
}
