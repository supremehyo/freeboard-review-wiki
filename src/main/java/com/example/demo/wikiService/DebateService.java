package com.example.demo.wikiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.DebateDao;
import com.example.demo.DAO.WikidocumentDao;

@Service
public class DebateService implements IDebateService{

		
	@Autowired
	DebateDao debatedao;
		@Override
		public void debatewrite(long id, String title, String content) {
			debatedao.debatewrite(id, title, content);
		}
		
		@Override
		public void debatelistread(long id) {
			debatedao.debatelistread(id);
		}
		
		@Override
		public String debateread(long id) {
			String page =debatedao.debateread(id);
			return page;
		}
}
