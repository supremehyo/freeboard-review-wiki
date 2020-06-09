package com.example.demo.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.JoinService;
import com.example.demo.service.LoginService;


@Controller
public class UsersController { //유저의 로그인과 회원가입의 로직을 담당하는 컨트롤러.

	@Autowired
	JoinService joinservice; // 회원가입을 담당하는 서비스
	@Autowired
	LoginService loginservice; // 로그인을 담당하는 서비스
	
	@PostMapping(value="/joinRequest")  //join.html의 회원가입 form 에서 /joinRequest로 요청을 보낼때.
	public String joinRequest(@RequestParam Map <String,String> paramMap) { 
		//form 의 요소들의 값이  name 에 담겨서 파라미터로 넘어옴.
		String userid = paramMap.get("user_id");// 각각 요소의 값에 해당하는 것들
		String userPw = paramMap.get("user_pw");
		String userName = paramMap.get("user_name");
		String page =joinservice.joinUser(userid, userPw, userName); 
		// Joinservice 로 회원가입에 필요한 정보들을 전달.
		return page; 
		// 회원가입의 성공과 실패에 따라 다른 화면을 보여주기 위해 page 라는 String 변수를 사용
	}
	
	@PostMapping(value = "/loginRequest")//login.html의 로그인 form 에서 /loginRequest로 요청을 보낼때.
	public String loginRequest(@RequestParam Map<String, String> paramMap) {
		
		String userid = paramMap.get("user_id");
		String userPw = paramMap.get("user_pw");
		String page =loginservice.login(userid,userPw);
		return page;
	}
	
}
