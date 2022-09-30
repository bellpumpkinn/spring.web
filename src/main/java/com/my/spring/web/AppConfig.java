package com.my.spring.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer{
	@Value("${attachPath}")
	private String attachPath;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("ch01/main");
		//registry.addViewController("ch02/ex03/user").setViewName("ch02/ex03/userIn");
	} /*위 11번줄 코드는 "/ch02/ex03/user"  url이 요청되면
	  ch02/ex03/userIn라는 view로 이동하게 해준다.
	
	  	UserController가 우선적으로 실행되는데
	  	@PostMapping, @GetMapping를 지우면 12번줄이 실행이된다.
	 */
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("res/**").addResourceLocations("WEB-INF/res/"); // res뒤에 뭐가 와도 괜찮다를 *2개로 표현.
		registry.addResourceHandler("attach/**").addResourceLocations("file:///" + attachPath + "/");
	} //27번줄 : res로 시작하는 무엇이든지를 WEB-INF/res/ 라는 url을 만듬.
	  // "file:///" => 외부에서 받는거.
}

/*
컨트롤러의 역할은 모델과 뷰를 짝지어주는거.

ViewControllerRegistry는 모델없이 view를 등록.

"ch01/main"주소를 
view resolver한테 줌. 그럼 리턴하는 값은

클라이언트가 서버로 리퀘스트를 보냄.
1차로 디스패쳐가 받음. 받아보니 url 이 /(슬래시) 이다.
/ 에 있는 viewName이 "ch01/main"라고 해준거다.

뷰리절버는 /WEB-INF/view/ch01/main.jsp가 됨.

*/