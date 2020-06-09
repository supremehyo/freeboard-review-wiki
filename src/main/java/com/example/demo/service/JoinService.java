package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Users;
import com.example.demo.repository.UserRepository;

@Service 
public class JoinService {
	@Autowired
	UserRepository usersRepository; //User정보를 관리하는 DB Repository
	@Autowired
	private UserPasswordHashClass userpasswordhashclass;
	//비밀번호를 SHA-256 암호화하기 위한 클래스.
	public String joinUser(String userid, String userPw , String userName) {
		Users use = usersRepository.findByUserid(userid);
		if(userid.equals("") || userPw.equals("")||userName.equals(""))
		{
			return "join"; // 입력 된 정보가 없을때의 오류처리.
		}
		if(use!=null) { //이미 중복된 계정이 있는지 체크
			return "join2";
		}
		Users user = new Users();
		user.setUserid(userid);
		user.setUserpw(userpasswordhashclass.getHash(userPw)); // 암호화 된 비밀번호를 User 객체에 저장
		user.setUsername(userName);
		usersRepository.save(user); // 회원의 정보가 담긴 user 객체를 DB에 저장.
		return "freeboardindex";
	}
}
