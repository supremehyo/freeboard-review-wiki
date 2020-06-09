package com.example.demo.wikiService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.DebateDao;
import com.example.demo.DAO.IDebateDao;
import com.example.demo.DAO.WikidocumentDao;
import com.example.demo.wikimodel.Debate;

@Service
public class DebateService implements IDebateService{
	@Autowired
	IDebateDao debatedao; 
	@Autowired
	private HttpSession session;
	//DAO 객체를 따로 두어서 비즈니스 로직과 DB접근을 따로 분리.
		@Override
		public void debatewrite(long id, String title, String content) {
			debatedao.debatewrite(id, title, content); //토론쓰기
		}		
		@Override
		public void debatelistread(long id) {
			List<Debate> list = debatedao.debatelistread(id);//토론 리스트 읽어오기
			session.setAttribute("debatelist", list);
		}
		@Override
		public String debateread(long id) {
			Debate debate =debatedao.debateread(id);//토론 읽기
			session.setAttribute("debate", debate);
			return "debateread";
		}
}
