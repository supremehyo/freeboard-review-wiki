package com.example.demo.wikiService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.WikidocumentDao;
import com.example.demo.wikimodel.Wikidocument;

@Service
public class WikiRequestService implements IWikidocumentService {

	@Autowired
	WikidocumentDao wikidocumentDao;
	
	@Override
	public void write(String title, String content) {
		wikidocumentDao.documentwrite(title, content);
	}
	@Override
	public String read(String title) {
		String page=wikidocumentDao.documentread(title);
		
		return page;
	}
	
	@Override
	public void downwrite(String title, String content , int linktitle) {
		wikidocumentDao.documentdownwrite(title, content);
		wikidocumentDao.documentdownupdate(title,linktitle); // 상위에 하위문서 목록 업뎃하는 부분
		
	}
	//여기에는 서비스 명만 적으면 된다 update 나 딜리트 그런거 기존 프로젝트는 서비스에서 바로 데이터베이스로 연결했는데 
	//이번 프로젝트에서는 Dao를 거쳐서 Dao에서 선언함 함수에서 실질적인 DB와의 통신을 한다.
	
	@Override
	public void rewrite(String title, String content) {
		wikidocumentDao.documentrewrite(title, content);
	}
	
	@Override
	public void count(String title) {
		wikidocumentDao.documentcount(title);
	}

	@Override
	public List<Wikidocument> readwikicount() {
		List<Wikidocument> wikidocumentMostList = wikidocumentDao.mostcoutdocument();
		return wikidocumentMostList;
	}
	
	
}
