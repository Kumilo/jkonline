package com.hemax.jkt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cqjkt")
@Controller
public class MainController {
	
	@RequestMapping("/home")
	public void home() {
		System.out.println("enter home");
	}

}
