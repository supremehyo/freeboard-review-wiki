package com.example.demo.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.JoinService;
import com.example.demo.service.LoginService;


@Controller
public class UsersController {

	@Autowired
	JoinService joinservice;
	@Autowired
	LoginService loginservice;
	
	@PostMapping(value="/joinRequest")
	public String joinRequest(@RequestParam Map <String,String> paramMap) {
		String userid = paramMap.get("user_id");
		String userPw = paramMap.get("user_pw");
		String userName = paramMap.get("user_name");
		
		String page =joinservice.joinUser(userid, userPw, userName);
		return page;
	}
	
	@PostMapping(value = "/loginRequest")
	public String loginRequest(@RequestParam Map<String, String> paramMap) {
		
		String userid = paramMap.get("user_id");
		String userPw = paramMap.get("user_pw");
		
		String page =loginservice.login(userid,userPw);
		return page;
	}
	
}
