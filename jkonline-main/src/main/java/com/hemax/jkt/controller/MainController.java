package com.hemax.jkt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hemax.jkt.data.repository.MsgRepository;
import com.hemax.jkt.domain.Msg;

@RequestMapping("/cqjkt")
@Controller
public class MainController {
	
	
	@Autowired
	MsgRepository msgRepository;
	
	@RequestMapping("/home")
	public String home() {
		
		List<Msg> msg = msgRepository.findAll();
		System.out.println(msg.size());
		return "hello";
	}

}
