package com.hemax.jkt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.hemax.jkt.data.repository.MsgRepository;
import com.hemax.jkt.domain.Msg;

@RequestMapping("/cqjkt")
@RestController
public class MainController {
	
	
	@Autowired
	MsgRepository msgRepository;
	
	@RequestMapping("/home")
	public String home() {
		
		List<Msg> msg = msgRepository.findAll();
		return JSON.toJSONString(msg);
	}

}
