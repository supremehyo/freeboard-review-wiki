package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	
	@Autowired
	private HttpSession httpsession;
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/freeboardindex")
	public String freeboardindex() {
		return "freeboardindex";
	}

	
	@RequestMapping(value="/roadviewtest")
	public String roViewtest() {
		return "roadviewtest";
	}
	
	@RequestMapping(value="/joinPage")
	public String joinPage() {
		
		return "join";
	}
	
	@RequestMapping(value = "/loginPage")
	public String loginPage() {
		
		return "login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout() {
		httpsession.invalidate();
		return "freeboardindex";
	}
	
	@GetMapping(value = "/freeboardWritePage")
	public String freeboardwrite() {
		
		return "freeboardwrite";
	}
	
	@RequestMapping(value ="/wiki")
	public String gowiki() {
		return "wikiindex";
	}
}
