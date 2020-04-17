package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.Freeboard;
import com.example.demo.Model.FreeboardComment;
import com.example.demo.repository.FreeboardCommnetRepository;
import com.example.demo.service.FreeboardCommentListService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;



@Controller
public class FreeboardCommentController {

	@Autowired
	private HttpSession session;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private FreeboardCommentListService freeboardCommentListService;
	@Autowired
	private FreeboardCommnetRepository freeboardCommnetRepository;
	
	@GetMapping(value="/freeboardCommentList" , produces = MediaTypes.HAL_JSON_VALUE)
	public @ResponseBody String freeboardCommnetList(){
		Freeboard freeboard = (Freeboard) session.getAttribute("freeboard");
		List<FreeboardComment> commentList = freeboardCommentListService.getList(freeboard.getFreeid());
		String value = "null";
		try {
			value = objectMapper.writeValueAsString(commentList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	@PostMapping("/freeboardCommentWrite")
	public @ResponseBody String freeboardCommentWrite(@RequestBody FreeboardComment freeboardComment ) {
		freeboardComment.setWirteData(LocalDateTime.now());
		freeboardCommnetRepository.save(freeboardComment);
		return "freeboardComment insert";
	}
}
