package com.example.demo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Freeboard;
import com.example.demo.repository.FreeboardRepository;

@Service
public class FreeboardPostService {

	@Autowired
	private FreeboardRepository freeboardRepository;
	@Autowired
	private HttpSession session;
	public String getFreeboardPost(String stringfreeid) {
		Long freeid = Long.parseLong(stringfreeid);
		Freeboard findboard = freeboardRepository.findById(freeid).get();
		if(findboard == null) {
			return "freeboard";
		}
		session.setAttribute("freeboard", findboard);
		return "freeboardinfo";
	}
}
