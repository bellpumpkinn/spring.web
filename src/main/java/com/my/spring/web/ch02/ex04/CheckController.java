package com.my.spring.web.ch02.ex04;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch02/ex04")
public class CheckController {
	@GetMapping
	public String main() {
		return "ch02/ex04/main";
	}
	
	@GetMapping("choice")
	public String choice(int kind) {
		String view = "ch02/ex04/";
		
		switch(kind) {
		case 1: view += "radioIn"; break;
		case 2: view += "checkboxIn";
		}
		
		return view;
	}
	/*
	@PostMapping("radio")
	public String radio(String agree, Model model) { // String agree가 parameter
		model.addAttribute("agree", agree);
		return "ch02/ex04/radioOut";
	}
	*/
	
	@PostMapping("radio")
	public String radio(@ModelAttribute("agree") String agree) {
		return "ch02/ex04/radioOut";
	}
	
	@PostMapping("checkbox")
	public String checkbox(ArrayList<String> fruits) {
		System.out.println(fruits);
		return "ch02/ex04/checkboxIn";
	}// 과제: 현재상태에서 파라미터 못받음. request파라미터를 받아봐라.
}
