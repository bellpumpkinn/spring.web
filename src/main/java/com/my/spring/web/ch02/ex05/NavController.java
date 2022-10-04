package com.my.spring.web.ch02.ex05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch02/ex05")
public class NavController {
	@GetMapping("forward") 
	public String forward() { // ch02/ex05/forward하면 target의 화면을 띄움.
		return "forward:target"; // forward핸들러에서 target핸들러로 이동하고싶을때.
	} // target은 url이다를 알려준다.
	
	@GetMapping("target")
	public String target() {
		return "ch02/ex05/target";
	}
	
	@GetMapping("redirect")
	public String redirect() {
		return "redirect:target";
	} //redirect는 response의 내장객체의 url이 담김.
	
//과제: 핸들러 하나 추가. ch02/ex05/naver하면 브라우저에 네이버뜨게
	@GetMapping("naver")
	public String naver() {
		return "redirect:http://naver.com";
	}
}
/*

return "target"; 은 컨테이너는 target을 view네임으로 인지.

forward하면 주소창이 forward인데
redirect하면 주소창이 target으로 바뀜.

*/