package com.example.demo.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.wikiRepository.WikidocumentRepository;
import com.example.demo.wikimodel.Wikidocument;

@Component
public class WikidocumentDao implements IWikidocumentDao{
	@Autowired
	WikidocumentRepository wikidocumentRepository;
	@Autowired
	private HttpSession session;

	@Override
	public void documentwrite(String title, String content) {//쓰기기능
		Wikidocument wikidocument = new Wikidocument();
		wikidocument.setTitle(title);
		wikidocument.setContent(content);
		wikidocumentRepository.save(wikidocument);
	}
	@Override
	public Wikidocument documentread(String title) {
		//title 정보를 받아서 그 제목을 가진 문서를 DB에서 가져오고 Wikidocument 객체에 저장하고 리턴.
		Wikidocument wikidocument=wikidocumentRepository.findByTitle(title);
		return wikidocument; 
	}
	
	@Override
	public List<Wikidocument> documentlinklist(int i){
		//하위문서 링크목록을 DB에서 가져오는 메소드
		List<Wikidocument> list=wikidocumentRepository.findAllByLinktitle(i);
		return list;
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
