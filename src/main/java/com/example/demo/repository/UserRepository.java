package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> //Long 은 Users 라는 테이블의 id 값의 자료형이 오면 되기때문에 long이 왔다.
{
	
	public Users findByUseridAndUserpw(String userid , String userpw);
		
	
}
