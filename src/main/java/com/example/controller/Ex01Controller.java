package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/exam01")
public class Ex01Controller {
	
	@RequestMapping("")
	public String index() {
		return "exam-01";
	}
	
	@RequestMapping("/input")
	public String inputName(String name, RedirectAttributes flash) {
		flash.addFlashAttribute("name", name);
		return "redirect:/exam01/result";
	}
	
	@RequestMapping("/result")
	public String result() {
		return "result";
	}

}
