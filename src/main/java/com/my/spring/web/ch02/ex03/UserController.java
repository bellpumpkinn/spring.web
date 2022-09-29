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
	public String userOut(User user) { //커멘더하나로 선언하면 User에 있는게 다 옴.
		return "ch02/ex03/userOut";
	} // 커맨더이자 모델도됨. 이 커멘더는(user)라는 모델이 자동지정됨.
}

/*
"ch02/ex03/user" 가 userIn의 mapping url

servlet에 쓰는 url은 핸들러의 url이다.

*/