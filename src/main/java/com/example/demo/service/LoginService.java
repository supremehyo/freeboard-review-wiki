package com.example.demo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Users;
import com.example.demo.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserPasswordHashClass userPasswordHashClass;
	@Autowired
	UserRepository usersRepository;
	
	@Autowired
	HttpSession session;
	
	public String login(String userid , String userPw) {
		if(userid.equals("")|| userPw.equals(""))
		{
			return "login";
		}
		String hashedPassword = userPasswordHashClass.getHash(userPw);
		Users user = usersRepository.findByUseridAndUserpw(userid,hashedPassword); //DB에서 정보 가져오는곳
		if(user == null) {
			return "login";
		}
		
		session.setAttribute("loginUser", user);
		return "freeboardindex";
	}
}
