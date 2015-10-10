package com.ppusari.my.mybatis.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppusari.my.mybatis.db.dao.IDao;
 
 
@Controller
@RequestMapping("/mybatis")
public class TableController {

	private static final Logger logger = LoggerFactory.getLogger(TableController.class);
	
	@Autowired
	private SqlSession sqlSession; // servlet-context.xml 에 등록되어있음 ( setter 필요없음 )
	
	@RequestMapping("/list")
	public String list(Model model){		
/*		ArrayList<ContentDto> dtos = dao.listDao();		
		model.addAttribute("list", dtos);
		return "/list";*/			
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listDao());
		return "/mybatis/list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm(){
		return "/mybatis/writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model){
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String view(){
		return "/mybatis/view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(request.getParameter("mId"));
		return "redirect:list";
	}
	
}
