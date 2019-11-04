package com.example.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		List<Item> itemList = new LinkedList<>();
		Item item1 = new Item("手帳ノート", 1000);
		Item item2 = new Item("文房具セット", 1500);
		Item item3 = new Item("ファイル", 2000);
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		application.setAttribute("itemList", itemList);
		return "item-and-cart";
	}

}
