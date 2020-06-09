package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.*;
import com.example.demo.service.FreeboardDropService;
import com.example.demo.service.FreeboardListService;
import com.example.demo.service.FreeboardPostService;
import com.example.demo.service.FreeboardRewriteService;
import com.example.demo.service.FreeboardWriteService;



@Controller
public class FreeboardController {

	@Autowired
	private FreeboardListService freeboardlistService;
	@Autowired
	private FreeboardWriteService freeboardWriteService;
	@Autowired
	private FreeboardPostService freeboardPostService;
	@Autowired
	private FreeboardDropService freeboardDropService;
	@Autowired
	private FreeboardRewriteService freeboardRewriteService;
	
	private int returnIntValue(String stringtoint) {
		return Integer.parseInt(stringtoint);
	}
	@GetMapping("/freeboard")
		public String freeboard(@RequestParam(value="pageNum" , defaultValue = "1")String pageNum) {
			String page = freeboardlistService.freeboardList(returnIntValue(pageNum));
			return page;
		}
	@PostMapping("/freeboardWriteRequest")
	public String freeboardWirte(@RequestParam Map <String,String> paramMap) {
		String title = paramMap.get("title");
		String content = paramMap.get("content");
		String writer = paramMap.get("writer");
		String username = paramMap.get("username");
		String place = paramMap.get("hiddenPlace");
		freeboardWriteService.write(title, content, writer,username , place);
		return "redirect:/freeboard";
	}
	
	@PostMapping("/freeboardDrop")
	public  String freeboardDrop(@RequestParam(value="ok") String ok, @RequestParam(value="freeid") String freeid) {
		if(ok.equals("ok")){
			freeboardDropService.drop(freeid);
			return "redirect:/freeboard";
		}
		return "redirect:/freeboard";
	}
	@PostMapping("/freeboardRewrite")
	public String freeboardRewrite(@RequestParam(value="stringreturn") String stringreturn, @RequestParam(value="freeid") String freeid) {
		freeboardRewriteService.Rewrite(stringreturn,freeid);
		return "redirect:/freeboard";
	}
	@GetMapping("freeboardinfo")
	public String getPost(@RequestParam(value="freeid")String freeid) {
		String page = freeboardPostService.getFreeboardPost(freeid);
		return page;
	}
}
