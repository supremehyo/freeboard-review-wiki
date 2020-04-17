package com.example.demo.wikiController;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.demo.wikiService.DebateCommentService;
import com.example.demo.wikiService.DebateService;
import com.example.demo.wikiService.WikiRequestService;
import com.example.demo.wikimodel.Debate;
import com.example.demo.wikimodel.DebateComment;
import com.example.demo.wikimodel.Wikidocument;
import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
public class WikiBoardController {

	@Autowired
	public WikiRequestService wikiRequestService;
	@Autowired
	public DebateService debateservice;
	@Autowired
	public DebateCommentService debateCommentService;
	@Autowired
	private HttpSession session;
	@Autowired
	private ObjectMapper objectMapper;
	
	@PostMapping("/wikiWriteRequest")
	public String wikiWirte(@RequestParam Map <String,String> paramMap) {
		String title = paramMap.get("title");
		String content = paramMap.get("content");
		wikiRequestService.write(title, content);
		return "redirect:/wiki";
	}
	
	@RequestMapping("/wikiReadRequest")
	public String getRead(@RequestParam(value="title")String title) {
		String page=wikiRequestService.read(title);
		wikiRequestService.count(title);
		return page;
	}
	@RequestMapping("/wikidownwriteRequest")
	public String wikidownwrite(@RequestParam Map <String,String> paramMap) {
		String title = paramMap.get("title");
		String content = paramMap.get("content");
		String linktitle = paramMap.get("linktitle");
		int linktitleint = Integer.parseInt(linktitle);
		wikiRequestService.downwrite(title, content , linktitleint);
		return "redirect:/wiki";
		//session.setAttribute("linktitle", linktitle);
	}
	
	@RequestMapping("/wikirewriteRequest")
	public String wikirewrite(@RequestParam Map<String,String> params) {
		String title = params.get("title");
		String content = params.get("content");
		wikiRequestService.rewrite(title, content);
		return "redirect:/wiki";
	}
	
	@RequestMapping(value = "/debatego/{id}/")
	public String debatego(@PathVariable long id) {
		// 여기서 해당 title 에 관련된 토론리스트 목록을 다 가져오면 됌
		debateservice.debatelistread(id);
		return "debatelist";
	}
	
	@RequestMapping(value = "/debatego/{id}/dabatewrite")
	public String debatewrite(@PathVariable long id) {
		//이 id를 세션에 넣어놨다가 빼서 라이트리퀘스트에서 사용하면 될듯
		session.setAttribute("debate_title_id", id);
		return "debatewrite";
	}
	
	@RequestMapping(value = "/debatego/{id}/dabateread")
	public String debateread(@PathVariable long id) {
		String page=debateservice.debateread(id);
		return page;
	}
	
	@RequestMapping("/debateWriteRequest")
	public String debatewriteRequest(@RequestParam Map<String,String> params) {
		String title = params.get("title");
		String content = params.get("content");
		long id = (long) session.getAttribute("debate_title_id");
		debateservice.debatewrite(id, title, content);
		return "redirect:/wiki";
	}
	
	@RequestMapping("/debateCommentWrite")
	public String debatecommentwrite(@RequestParam Map<String,String> params) {
		String nickname = params.get("nickname");
		String content = params.get("content");
		String debateid = params.get("debateid");
		Long debaid = Long.parseLong(debateid);
		debateCommentService.debateCommentwrite( nickname, content ,debaid);
		String page_temp1 ="redirect:/debatego/";
		String page_temp2 = params.get("id");
		String page_temp3="/dabateread";
		
		String page = page_temp1 + page_temp2 + page_temp3;
		return page;
	}
	
	@GetMapping(value="/debateCommentList" , produces = MediaTypes.HAL_JSON_VALUE)
	public @ResponseBody String debateCommnetList(){
		Debate debate = (Debate) session.getAttribute("debate");
		List<DebateComment> commentList1 = debateCommentService.getdebateCommentList(debate.getId());
		String value = "null";
		try {
			value = objectMapper.writeValueAsString(commentList1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	@GetMapping(value ="/documentmostList" , produces = MediaTypes.HAL_JSON_VALUE)
	public @ResponseBody String wikidocumentMost() {
		List<Wikidocument> wikidocumentMostList = wikiRequestService.readwikicount();
		String value = "null";
		try {
			value = objectMapper.writeValueAsString(wikidocumentMostList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	
	
	
}
