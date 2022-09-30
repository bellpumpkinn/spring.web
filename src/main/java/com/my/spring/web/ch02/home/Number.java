package com.my.spring.web.ch02.home;

import lombok.Setter;

@Setter
public class Number {
	private double num;
	
	public double getNum() {
		return num + (int)(Math.random() * 10) / 10.0;
	}
}

// 간단하고 도메인이 갖고있는데이터만으로 알고리즘은 도메인에 구현하는거

/*
<과제>

폼에 자연수 하나를 입력한다.
폼을 제출한다.
입력값 <= x < 입력값 + 1 인, x를 출력한다.
x는 실수이다.
x는 랜덤값이다.
x는 소수점 이하 한자리까지 표현한다.
*/
