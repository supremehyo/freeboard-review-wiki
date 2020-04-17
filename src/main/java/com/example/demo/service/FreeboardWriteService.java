package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Freeboard;
import com.example.demo.repository.FreeboardRepository;

@Service
public class FreeboardWriteService {

	@Autowired
	FreeboardRepository freeboardrepository;
	
	public void write(String title, String content, String writer , String username , String place) {
		Freeboard freeboard = new Freeboard();
		freeboard.setTitle(title);
		freeboard.setContent(content);
		freeboard.setWriter(writer);
		freeboard.setUsername(username);
		freeboard.setPlace(place);
		freeboardrepository.save(freeboard);
	}
}
