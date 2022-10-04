package com.my.spring.web.ch02.ex01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String userName;
	private int age;
}

/*
@Data // setter, getter만들어라라는 어노테이션.

mapper클래스 이름은 도메인명 + map
service이름은 업무명 + service
*/

/*
@어노테이션

@AllArgsConstructor //여기에 필드에 쓴 모든생성자만 만들어줌
@NoArgsConstructor //기본 생성자를 만들어줌
@Data // getter, setter 만들어줌

@Getter, @Setter를 선언해줄 경우, 
모든 필드에 접근자와 설정자가 자동으로 생성된다.

@Controller - 해당 클래스가 Controller임을 나타내기 위한 어노테이션
@RequestMapping - 특정 url로부터 요청을 받으면 어떤 Controller에서 처리할 지 알아야 한다.
이 때, 특정 url을 요청을 수행할 Controller과 매핑하여 지정하는 어노테이션이 @RequestMapping이다.

*/