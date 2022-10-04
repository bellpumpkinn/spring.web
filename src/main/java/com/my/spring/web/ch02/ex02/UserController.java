package com.my.spring.web.ch02.ex02;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("ch02.ex02")
@RequestMapping("ch02/ex02")
public class UserController {
	@GetMapping("userIn")
	public String userIn() { 
		return "ch02/ex02/userIn";
	}
	
	/*
	@PostMapping("userOut")
	public String userOut(@RequestParam String userName,
							@RequestParam int age,
							@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate regDate,
							Model model) {
		model.addAttribute("user", new User(userName, age, regDate));
		return "ch02/ex02/userOut";
	}
	*/
	
	@PostMapping("userOut")
	public String userOut( String userName,
							int age,
							@DateTimeFormat(pattern="yyyy-MM-dd") LocalDate regDate,
							Model model) { // 커맨드할땐 날짜형식을 미리 정해놔야함.
		model.addAttribute("user", new User(userName, age, regDate));
		return "ch02/ex02/userOut";
	} // @RequestParam 없어도 작동 잘되는걸 확인.
}

// 리퀘스트안에 있는걸꺼내서 사용하고 싶을때 쓰는 예제. 주소만 바꾸면되요 한다음에
/*

컨트롤러를 만들때 유일한 값을 지정해야하는 2가지
=> 빈의 ID, request Mapping URL (2개)

*/