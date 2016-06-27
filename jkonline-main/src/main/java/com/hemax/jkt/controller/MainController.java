package com.hemax.jkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hemax.jkt.data.repository.MsgRepository;

@RequestMapping("/cqjkt")
@Controller
public class MainController {
	
	
	@Autowired
	MsgRepository msgRepository;
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		//List<Msg> msg = msgRepository.findAll();
		model.addAttribute("message", "Black color");
		return "hello";
	}

}
