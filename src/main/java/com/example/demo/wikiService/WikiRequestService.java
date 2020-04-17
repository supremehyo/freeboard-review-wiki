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
		wikidocumentDao.documentdownupdate(title,linktitle); // ������ �������� ��� �����ϴ� �κ�
		
	}
	//���⿡�� ���� �� ������ �ȴ� update �� ����Ʈ �׷��� ���� ������Ʈ�� ���񽺿��� �ٷ� �����ͺ��̽��� �����ߴµ� 
	//�̹� ������Ʈ������ Dao�� ���ļ� Dao���� ������ �Լ����� �������� DB���� ����� �Ѵ�.
	
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
