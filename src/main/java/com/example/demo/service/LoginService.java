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
		// 로그인 할때 아이디와 비밀번호가 입력되지 않았을때 오류처리.
		{
			return "login";
		}
		String hashedPassword = userPasswordHashClass.getHash(userPw);
		//DB에는 암호화된 비밀번호가 저장되어 있으므로 입력받은 비밀번호를 암호화 하여 DB에서 검색한다.
		Users user = usersRepository.findByUseridAndUserpw(userid,hashedPassword); 
		if(user == null) { // 입력된 정보와 일치하는 user 정보가 없을때의 오류처리.
			return "login";
		}
		session.setAttribute("loginUser", user);
		return "freeboardindex";
	}
}
