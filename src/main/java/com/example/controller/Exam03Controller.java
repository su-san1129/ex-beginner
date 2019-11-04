package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam-03";
	}
	
	@RequestMapping("/input")
	public String input(Integer item1, Integer item2, Integer item3) {
		Integer totalPrice = item1 + item2 + item3;
		double tax = 1.10;
		Integer taxIncludePrice = (int)(totalPrice * tax);
		application.setAttribute("totalPrice", totalPrice);
		application.setAttribute("taxIncludePrice", taxIncludePrice);
		return "redirect:/exam03/result";
	}
	
	@RequestMapping("/result")
	public String result() {
		return "exam03-result";
	}
	
	

}
