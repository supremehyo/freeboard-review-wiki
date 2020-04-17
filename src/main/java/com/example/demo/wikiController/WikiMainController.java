package com.example.demo.wikiController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WikiMainController {


	@RequestMapping(value ="/wikiwrite")
	public String wikiwrite() {
		return "wikiwrite";
	}
	
	@RequestMapping(value ="/wikidownwrite")
	public String wikidownwrite() {
		return "wikidownwrite";
	}
	
	@RequestMapping(value ="/wikirewrite")
	public String wikirewrite() {
		return "wikirewrite";
	}


}
