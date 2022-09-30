package com.my.spring.web.ch02.ex06;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ch02.ex06")
@RequestMapping("ch02/ex06")
public class UserController {
	@GetMapping("login")
	public String loginIn(@CookieValue(required=false) String userId, 
			@ModelAttribute("user") UserDto user) { // 리퀘스트에 저장된 쿠키밸류를 읽어내는 작업.
		if(userId != null) user.setUserId(userId); // 쿠키로받은 userId를 집어넣는다. userId가 없으면 null
		return "ch02/ex06/login"; // 모델이름이 맘에 안들면 모델어트리뷰트해서 이름 정해줄수있음.
	} // 커맨드는 리퀘스트 파라미터를 사용할수있따.
	
	@PostMapping("login")
	public String login(@ModelAttribute("user") UserDto user, String rememberMe, // rememberMe앞에 @RequestParam 생략.
		HttpSession session, HttpServletResponse response) {
			if(session.getAttribute("userId") == null)
				session.setAttribute("userId",user.getUserId());
			
			if(rememberMe != null && rememberMe.equals("on")) {
				Cookie cookie = new Cookie("userId", user.getUserId());
				cookie.setMaxAge(5);
				response.addCookie(cookie);
			} 
			
		return "ch02/ex06/logout";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();		
		return "redirect:login";
	}
} 
//session객체안에 userId가 있으면 로그인했다. 
//	없으면 로그인안했다. 로 판단.

/*
15번줄 ---------------------------------
UserDto user => 생성자호출 (텅빈 user 생성)
모델네임은 UserDto
----------------------------------------

21번줄 UserDto는 커맨드
*/