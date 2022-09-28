package com.my.spring.web.ch02.ex03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ch02.ex03")
@RequestMapping("ch02/ex03/user")
public class UserController {
	@GetMapping   // 핸들러
	public String userIn() {
		return "ch02/ex03/userIn";
	}
	
	@PostMapping
	public String userOut(User user) {
		return "ch02/ex03/userOut";
	}
}

/*
"ch02/ex03/user" 가 userIn의 mapping url

servlet에 쓰는 url은 핸들러의 url이다.

*/