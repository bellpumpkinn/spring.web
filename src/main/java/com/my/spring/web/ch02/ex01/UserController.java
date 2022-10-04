package com.my.spring.web.ch02.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("ch02/ex01")
/*
@RequestMapping - 특정 url로부터 요청을 받으면 어떤 Controller에서 처리할 지 알아야 한다.
이 때, 특정 url을 요청을 수행할 Controller과 매핑하여 지정하는 어노테이션이 @RequestMapping이다.
 */
public class UserController {
	@GetMapping("11") //localhost/ch02/ex01/11로 요청이 들어오면 아래의 함수를 실행하라고 해석
	//ModelAndView : 데이터와 뷰를 동시에 설정이 가능.
	public ModelAndView handler11(ModelAndView mv) {
		mv.addObject("user", new User("최한석", 11)); // 뷰로 보낼 데이터값. addObject는 key와 밸류를 지님.
		mv.setViewName("ch02/ex01/user"); // 뷰의 이름.
		
		return mv;
	}
	
	@GetMapping("21")
	//Model => 데이터만 설정이 가능.
	public String handler21(Model model) {
		model.addAttribute("user", new User("한아름", 21)); // 뷰로 보낼 데이터값.
		
		return "ch02/ex01/user";
	} // 리턴타입이  스트링인경우 리턴값으로 view를 쓴다.
	
	@GetMapping("22")
	public String handler22() {
		return "ch02/ex01/user";
	} // "ch02/ex01/user" 는 현재 view 1개를 핸들러 3개가 쓰는상황.
	//모델은 안보내줘도 viewName은 보내주는것을 알 수 있다.
	
	@GetMapping("31")  // User가 모델이다.
	public void handler31(User user) { // void = 리턴값X
		user.setUserName("양승일");
		user.setAge(31);
	} //핸들러31이 던져주는 모델은 User고 모델value는 user
	
	@GetMapping("32") // user를 man으로 바꿨음.
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

/*
컨트롤러는 사용자가 화면(view)단에서 입력이나 어떤 이벤트를 했을경우,
그 이벤트화면에 맞는 화면(view)이나 비즈니스로직(model)을 실행할수있도록
업데이트를 해주는 역할을 맡는다.

@Controller 어노테이션은 어노테이션이 적용된 클래스를 컨트롤러임을 내타내고,
자동으로 bean이 등록되어 @Controller어노테이션이 적용된 클래스를 
Controller로 사용할 수 있다.

원래하던 자바는 class를 생성하고 new를 입력해서 원하는 객체를 직접 생성후 사용,
하지만 스프링에서는 직접 new 하지않고 스프링에 의해 관리당하는 자바객체를 사용.
Spring에 의해 생성되고 관리되는 자바객체를 Bean이라고 한다.
*/