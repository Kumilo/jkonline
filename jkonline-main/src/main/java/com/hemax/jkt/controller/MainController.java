package com.hemax.jkt.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.hemax.jkt.config.UserConfig;
import com.hemax.jkt.data.repository.XueyuanRepository;
import com.hemax.jkt.domain.Xueyuan;

@RequestMapping("/jk")
@Controller
public class MainController {
	
	@Autowired 
	UserConfig user;
	
	@Autowired
	XueyuanRepository xueyuanRepository;
	
	@RequestMapping("/index")
	public String home(Model model) {
		
		return "index";
	}
	
	
	@RequestMapping("/login")
	public String home(@RequestParam String name,@RequestParam String phone,Model model) {
		model.addAttribute("name", name);
		return "guide";
	}
	
	@RequestMapping("/users")
	public String userList(Model model,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="step",required=false) Integer step) {
		
		List<Xueyuan> xueYuans = Lists.newArrayList();
		
		if (StringUtils.isBlank(name) && (step == null|| step ==0)) {
			xueYuans.addAll(xueyuanRepository.findAll());
			model.addAttribute("xueyuans",xueYuans);
			return "users";
		}
		
		if (StringUtils.isNotBlank(name) && (step == null|| step ==0)) {
			xueYuans.addAll(xueyuanRepository.findByName(name));
			model.addAttribute("xueyuans",xueYuans);
			return "users";
		}
		
		if (StringUtils.isBlank(name) && (step != null|| step !=0)) {
			xueYuans.addAll(xueyuanRepository.findByStep(step));
			model.addAttribute("xueyuans",xueYuans);
			return "users";
		}
		
		if (!StringUtils.isBlank(name) && (step != null|| step !=0)) {
			xueYuans.addAll(xueyuanRepository.findByNameAndStep(name, step));
			model.addAttribute("xueyuans",xueYuans);
			return "users";
		}
		
		return "users";
	}
	
	@RequestMapping("/addPage")
	public String addPage(Model model) {
		
		return "add";
	}
	
	@RequestMapping("/query")
	public String query(@RequestParam Integer id,Model model) {
		Xueyuan xueyuan = xueyuanRepository.findOne(Long.valueOf(id));
//		List<Xueyuan> xueYuans = xueyuanRepository.findAll();
//		model.addAttribute("xueyuans",xueYuans);
		model.addAttribute("xueyuan",xueyuan);
		return "singleUser";
	}
	
	@RequestMapping("/updateQuery")
	public String updateQuery(@RequestParam Integer id,Model model) {
		Xueyuan xueyuan = xueyuanRepository.findOne(Long.valueOf(id));
		model.addAttribute("xueyuan",xueyuan);
		return "update";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String  add(
			@RequestParam(required=false) Long id,
			@RequestParam Integer step,
			@RequestParam String memo) {
		
		Assert.notNull(id);
		
		Xueyuan xueyuan = xueyuanRepository.findOne(id);
		xueyuan.setMemo(memo);
		xueyuan.setStep(step);
		xueyuanRepository.save(xueyuan);
		
		return "修改学员信息成功，请点击返回按钮返回.";
		
	
	}
	
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String  add(
			@RequestParam String name,
			@RequestParam Integer age,
			@RequestParam Integer sex,
			@RequestParam Integer step,
			@RequestParam String phone,
			@RequestParam String cert,
			@RequestParam String memo
			) {
		Xueyuan xueyuan = new Xueyuan();
		xueyuan.setAge(age);
		xueyuan.setName(name);
		xueyuan.setAge(age);
		xueyuan.setCert(cert);
		xueyuan.setMemo(memo);
		xueyuan.setPhone(phone);
		xueyuan.setStep(step);
		xueyuan.setSex(sex);
		xueyuan.setTime(new Date());

		xueyuanRepository.save(xueyuan);
		return "添加成功";
	}
	
	
	public static void main(String[] args) {
		String s= "hello";
		System.out.println(s);
		System.out.println(JSON.toJSONString(s));
	}

}
