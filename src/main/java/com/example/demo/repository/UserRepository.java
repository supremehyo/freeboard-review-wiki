package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> //Long �� Users ��� ���̺��� id ���� �ڷ����� ���� �Ǳ⶧���� long�� �Դ�.
{
	
	public Users findByUseridAndUserpw(String userid , String userpw);
	public Users findByUserid(String userid);
		
	
}
