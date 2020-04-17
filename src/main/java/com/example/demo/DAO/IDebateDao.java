package com.example.demo.DAO;

public interface IDebateDao {
	void debatewrite(long id,String title, String content);
	void debatelistread(long id);
	String debateread(long id);
}
