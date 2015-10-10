package com.ppusari.my.mvc2.command;

import java.util.ArrayList;
 
import org.springframework.ui.Model;

import com.ppusari.my.mvc2.dao.BDao;
import com.ppusari.my.mvc2.dto.BDto;
 
public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {

		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);				
	}
}
