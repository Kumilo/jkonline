package com.hemax.jkt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.hemax.jkt.config.UserConfig;
import com.hemax.jkt.data.repository.MsgRepository;

@RequestMapping("/jk")
@Controller
public class MainController {
	
	@Autowired UserConfig user;
	
	@Autowired
	MsgRepository msgRepository;
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		return "hello";
	}
	
	
	@RequestMapping("/login")
	public String home(@RequestParam String name,@RequestParam String phone,Model model) {
		System.out.println(user.getName()+"  "+user.getPhone());
		if (!user.getName().equals(name) || !user.getPhone().equals(phone)) {
			model.addAttribute("message", "用户名或密码错误!");
			return "hello";
		}
		return "users";
	}
	
	public static void main(String[] args) {
		String s= "hello";
		System.out.println(s);
		System.out.println(JSON.toJSONString(s));
	}

}
