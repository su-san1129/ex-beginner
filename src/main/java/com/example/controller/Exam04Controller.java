package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping("")
	public String index() {
		return "exam-04";
	}
	
	@RequestMapping("/input")
	public String input(
			@Validated UserForm userForm
			, BindingResult result // エラーメッセージが格納されるオブジェクト
			, RedirectAttributes flash) {
		
		// エラーが一つでもあった場合は、入力画面に遷移
		if(result.hasErrors()) {
			return index(); //index()メソッドを呼ぶ
		}
		
		User user = new User();
		System.out.println(userForm);
		BeanUtils.copyProperties(userForm, user);
		flash.addFlashAttribute("user", user);
		System.out.println(user);
		return "redirect:/exam04/result";
	}
	
	@RequestMapping("/result")
	public String result() {
		return "exam04-result";
	}
	

}
