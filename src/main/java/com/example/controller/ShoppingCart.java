package com.example.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

@Controller
@RequestMapping("/exam06")
public class ShoppingCart {
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String index(Model model) {
		@SuppressWarnings("unchecked")
		List<Item> cartList = (List<Item>) session.getAttribute("cartList");
		
		if(cartList == null) {
			cartList = new LinkedList<>();
			session.setAttribute("cartList", cartList);
		}
		List<Item> itemList = new LinkedList<>();
		Item item1 = new Item("手帳ノート", 1000);
		Item item2 = new Item("文房具セット", 1500);
		Item item3 = new Item("ファイル", 2000);
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		application.setAttribute("itemList", itemList);
		int totalPrice = 0;
		for (Item item : cartList) {
			totalPrice = totalPrice + item.getPrice();
		}
		System.out.println(totalPrice);
		model.addAttribute("totalPrice", totalPrice);
		return "item-and-cart";
	}
	
	@RequestMapping("/incart/{index}")
	public String inCart(@PathVariable("index") Integer index) {
		@SuppressWarnings("unchecked")
		List<Item> itemList = (List<Item>) application.getAttribute("itemList");
		@SuppressWarnings("unchecked")
		List<Item> cartList = (List<Item>) session.getAttribute("cartList");
		cartList.add(itemList.get(index));
		System.out.println(cartList);
		
		return "redirect:/exam06";
	}
	
	@RequestMapping("/delete/{index}")
	public String delete(@PathVariable("index") int index) {
		@SuppressWarnings("unchecked")
		List<Item> cartList = (List<Item>) session.getAttribute("cartList");
		cartList.remove(index);
		return "redirect:/exam06";
	}
	
	

}
