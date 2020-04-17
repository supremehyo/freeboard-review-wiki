package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Users;
import com.example.demo.repository.UserRepository;




@Service 
public class JoinService {
	
	@Autowired
	UserRepository usersRepository;
	
	@Autowired
	private UserPasswordHashClass userpasswordhashclass;
	
	public String joinUser(String userid, String userPw , String userName) {
		
		if(userid.equals("") || userPw.equals("")||userName.equals(""))
		{
			return "join";
		}
		Users user = new Users();
		user.setUserid(userid);
		user.setUserpw(userpasswordhashclass.getHash(userPw));
		user.setUsername(userName);
		usersRepository.save(user);
		return "index";
	}

}
