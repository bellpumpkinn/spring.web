package com.my.spring.web.ch03.ex02;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserDto {
   private String userName;
   private int age;
   private MultipartFile face;  // 클라이언트랑 대화할떄 쓰려구 만듬.
}

/*
파일은 DB에 파일명을 insert한다.

클라이언트가 전달하는데이터(파라미터)
파라미터밸류가 binary면 MultipartFile 사용
*/