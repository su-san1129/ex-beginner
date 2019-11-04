package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String index() {
		return "exam-02";
	}
	
	@RequestMapping("/input")
	public String input(Integer num1, Integer num2) {
		Integer sum = num1 + num2;
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("sum", sum);
		return "redirect:/exam02/result";
	}
	
	@RequestMapping("/result")
	public String result() {
		return "exam02-result";
	}
	
	@RequestMapping("/result2")
	public String result2() {
		return "exam02-result2";
	}

}
