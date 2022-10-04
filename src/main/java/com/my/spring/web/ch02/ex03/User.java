package com.my.spring.web.ch02.ex03;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
	private String userName;
	private int age;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate regDate;
}

/*
@AllArgsConstructor // 클래스의 모든 필드에 대한 생성자를 자동으로 생성합니다.
public User(userName, age, .....)
this.age = age.... 이런것들을 안만들어도 되게 해줌.

@Getter, @Setter를 선언해줄 경우, 
모든 필드에 접근자와 설정자가 자동으로 생성된다.
*/