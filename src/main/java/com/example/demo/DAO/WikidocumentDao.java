package com.example.demo.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.wikiRepository.WikidocumentRepository;
import com.example.demo.wikimodel.Wikidocument;

@Component
public class WikidocumentDao implements IWikidocumentDao{ // 이 객체가 서비스 파일에서 이용된다.
	@Autowired
	WikidocumentRepository wikidocumentRepository;
	@Autowired
	private HttpSession session;

	@Override
	public void documentwrite(String title, String content) { // 쓰기 기능
		Wikidocument wikidocument = new Wikidocument();
		wikidocument.setTitle(title);
		wikidocument.setContent(content);
		wikidocumentRepository.save(wikidocument);
	}
	@Override
	public String documentread(String title) { // 읽기 기능
		
		Wikidocument wikidocument=wikidocumentRepository.findByTitle(title);
		session.setAttribute("wikidocument", wikidocument);
		if(wikidocument == null) {
			return "wikireaderror";
		}
		int i = (int) wikidocument.getDocumentId();
		List<Wikidocument> list=wikidocumentRepository.findAllByLinktitle(i);
		session.setAttribute("linklist", list);
		return "wikiread";
	}
	
	@Override
	public void documentdownwrite(String title, String content) {
		Wikidocument wikidocument = new Wikidocument();
		wikidocument.setTitle(title);
		wikidocument.setContent(content);
		wikidocumentRepository.save(wikidocument);	
	}
	
	@Override
	public void documentdownupdate(String title,int linktitle) {
		wikidocumentRepository.downupdate(title,linktitle);
	}
	
	@Override
	public void documentrewrite(String title, String content) {
		wikidocumentRepository.rewrite(title, content);
	}
	@Override
	public void documentcount(String title) {
		wikidocumentRepository.countup(title);
	}
	@Override
	public List<Wikidocument> mostcoutdocument() {
		List<Wikidocument> wikidocumentMostlist =wikidocumentRepository.countlist();
		return wikidocumentMostlist;
	}
}
