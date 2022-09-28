package com.my.spring.web.ch02.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("ch02/ex01")
public class UserController {
	@GetMapping("11")
	public ModelAndView handler11(ModelAndView mv) {
		mv.addObject("user", new User("최한석", 11));
		mv.setViewName("ch02/ex01/user"); //디스패쳐가 뷰리졸버한테 해석 부탁.
		
		return mv;
	}
	
	@GetMapping("21")
	public String handler21(Model model) {
		model.addAttribute("user", new User("한아름", 21));
		return "ch02/ex01/user";
	}
	
	@GetMapping("22")
	public String handler22() {
		return "ch02/ex01/user";
	} // "ch02/ex01/user" view 1개를 핸들러 3개가 쓰는상황.
	//모델은 안보내줘도 viewName은 보내주는것을 알 수 있다.
	
	@GetMapping("31")
	public void handler31(User user) { // void = 리턴값X
		user.setUserName("양승일");
		user.setAge(31);
	} //핸들러31이 던져주는 모델은 User고 모델value는 user
	
	@GetMapping("32")
	public void handler32(@ModelAttribute("man")User user) {
		user.setUserName("서준한");
		user.setAge(32);
	}
	
	@GetMapping("41")   // 리턴타입이 모델인 경우.
	public User handler41(User user) {
		user.setUserName("김가람");
		user.setAge(41);
		
		return user;
	}
	
	@GetMapping("42")
	@ModelAttribute("man")
	public User handler42(User user) {
		user.setUserName("박건우");
		user.setAge(42);
		
		return user;
	}
	// 리퀘스트안에 있는걸꺼내서 사용하고 싶어 그걸연습이 ch02.ex02
}

/*

dao와 service는 request 안받고
MVC는 클라이언트와 리퀘스트받고 리스폰스도 보내주고해야함

디스패쳐가 리퀘스트를 다받음.
컨트롤러는 리퀘스트를 직접받지않고
리퀘스트에 해당하는 메서드를 골라서 콜할거임
핸들러는 리퀘스트를 받지않는다.

리퀘스트타입은 get과 post
ch02/ex01이 11이면 Mapping함.
이 맵핑된정보가 핸들러맵핑이 관리함.

핸들러와 url이 맵핑돼있는상태. -> 핸들러맵핑이 관리를 한다.

유저컨트롤러는 모델과 뷰를 맵핑해서 리턴해줌.
떄로는 모델만 또는 뷰만 리턴하기도 한다.

핸들러11의 url(또는 이름)이 ch02/ex01/11 

mv는 디스패처가 리턴받는다.
*/

/*


1. Client ▶ request (url:"/") ▶ 
2. (Server)Dispatcher Servlet ("ch01/main"으로 파악) ▶ 
	request 해석의뢰 ▶ 
3. View Resolver ▶ response (prefix, suffix 붙여서) ▶ 
4. Dispatcher ▶ viewName을 파악 후, request ▶ 
5. ch01/main.jsp이름을 갖는 Servlet(View) ▶ response ▶ 
6. Dispatcher Servlet ▶ response ▶ View - (WEB-INF/view/ch01/main.jsp) 
	▶ Client
	
	
@GetMapping : GET 요청을 하는 API의 어노테이션.
			  데이터를 가져올 때 사용한다.
@PostMapping : POST 요청을 하는 API의 어노테이션
			   데이터를 게시할 때 사용한다.

	
*/