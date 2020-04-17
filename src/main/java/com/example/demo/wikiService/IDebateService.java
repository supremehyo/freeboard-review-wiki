package com.example.demo.wikiService;

public interface IDebateService {
	void debatewrite(long id , String title, String content);
	void debatelistread(long id);
	String debateread(long id);
}
