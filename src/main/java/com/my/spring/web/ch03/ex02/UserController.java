package com.my.spring.web.ch03.ex02;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller("ch03/ex02")
@RequestMapping("ch03/ex02/user")
public class UserController {
   // attachPath property value를 String attachPath에 저장
   @Value("${attachPath") private String attachPath; 
   
   @GetMapping
   public String userIn() {
      return "ch03/ex02/userIn";
   }
   
   @PostMapping // request 사용이유 = 클라이언트가 입력한 파라미터인 파일이(바이너리 타입) request body에 저장되서 오기에. (바디에 오기에 'Post' 사용) 
   public String userOut(UserDto userDto, HttpServletRequest request, User user) {
      String fileName = userDto.getFace().getOriginalFilename(); // 클라이언트가 갖고있던 파일명 뽑아내기.
      saveFile(attachPath + "/" + fileName, userDto.getFace()); 
      // 클라이언트가 입력한, 리퀘스트에 들어있는 바이너리타입의 파일을 서버의 지정한 위치에 저장하는 메서드구현
      
      user.setFaceFilename(fileName);
      
      return "ch03/ex02/userOut"; // view만 리턴
   }
                        // ▼ 파일명                 ▼ 클라이언트가 입력한 파일?
   private void saveFile(String fileName, MultipartFile file) {
      try {
         file.transferTo(new File(fileName));
      } catch(IOException e) {}
   }
}
/*
리퀘스트를 쓴이유는 클라이언트가 입력한게 리퀘스트바디에 저장되서 오기때문.
바디에 저장시켜야하니까 Post를 씀.
ch03.ex02는 회원가입
*/