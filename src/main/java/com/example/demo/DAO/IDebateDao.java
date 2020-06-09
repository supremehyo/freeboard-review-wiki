package com.example.demo.DAO;

import java.util.List;

import com.example.demo.wikimodel.Debate;

public interface IDebateDao {
	void debatewrite(long id,String title, String content);
	List<Debate> debatelistread(long id);
	Debate debateread(long id);
}
