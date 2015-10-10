package com.ppusari.my.mvc2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ppusari.my.mvc2.command.BCommand;
import com.ppusari.my.mvc2.command.BContentCommand;
import com.ppusari.my.mvc2.command.BDeleteCommand;
import com.ppusari.my.mvc2.command.BListCommand;
import com.ppusari.my.mvc2.command.BModifyCommand;
import com.ppusari.my.mvc2.command.BReplayViewComand;
import com.ppusari.my.mvc2.command.BReplyCommand;
import com.ppusari.my.mvc2.command.BWriteCommand;

@Controller  
@RequestMapping("/mvc2")
public class BController {
	
	BCommand command;
	
	@RequestMapping("/list")	 
	public String list(Model model){
		command = new BListCommand();
		command.execute(model);		
		return "mvc2/list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model){
		return "mvc2/write_view";				
	}
	
	@RequestMapping("/write")  /*write_view.jsp의 form 태크에서 post로 전달됨*/
	public String write(HttpServletRequest request, Model model){		
		model.addAttribute("request", request);		
		command = new BWriteCommand();		
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);		
		return "mvc2/content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value= "/modify")
	public String modify(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		command = new BReplayViewComand();
		command.execute(model);
		return "mvc2/reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		return "mvc2/redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		return "mvc2/redirect:list";
	} 
}
