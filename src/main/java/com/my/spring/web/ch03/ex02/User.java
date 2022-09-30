package com.my.spring.web.ch03.ex02;

import lombok.Data;

@Data
public class User {
	private String userName;
	private int age;
	private String faceFilename; // DB랑 대화할때 쓰려구 만듬.
}
