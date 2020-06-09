package com.example.demo.DAO;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.wikiRepository.DebateRepository;
import com.example.demo.wikimodel.Debate;
import com.example.demo.wikimodel.Wikidocument;

@Component
public class DebateDao implements IDebateDao{
	@Autowired
	DebateRepository debateRepository;
	
	@Override
	public void debatewrite(long id, String title, String content) {
			Debate debate = new Debate(); 
			debate.setDebateid(id);
			debate.setDebatetitle(title);
			debate.setContent(content);
			debateRepository.save(debate);
			//Service 로 부터 전달받은 정보가 담긴 debate 객체를 DB에 저장한다.
	}
	@Override
	public List<Debate> debatelistread(long id) {
		//문서 id를 기준으로 하나의 문서에 생성된 토론 목록을 모두 가져와서
		//list에 담는다.
		List<Debate> list=debateRepository.findAllByDebateid(id);
		//session.setAttribute("debatelist", list); DAO에서 처리하지 않고 service에서 처리하도록 변경
		return list;
	}
	
	@Override
	public Debate debateread(long id) {
		Debate debate = debateRepository.findById(id).get();
		//session.setAttribute("debate", debate); DAO에서 처리하지 않고 service에서 처리하도록 변경
		return debate;
		//return "debateread";
	}
}
