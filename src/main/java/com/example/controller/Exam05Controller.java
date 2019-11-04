package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Member;
import com.example.service.MemberService;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {

	@Autowired
	private MemberService service;
	
	@RequestMapping("")
	public String index() {
		return "exam-05";
	}
	
	@RequestMapping("/input")
	public String input(String name, RedirectAttributes flash) {
		List<Member> list = service.fuzzySerch(name);
		System.out.println(list);
		flash.addFlashAttribute("memberList", list);
		
		return "redirect:/exam05/result";
	}
	
	@RequestMapping("/result")
	public String result() {
		return "exam05-result";
	}
}
