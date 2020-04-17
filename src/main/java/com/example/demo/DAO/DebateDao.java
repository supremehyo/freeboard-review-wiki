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
	private HttpSession session;
	@Autowired
	DebateRepository debateRepository;
	
	@Override
	public void debatewrite(long id, String title, String content) {
			Debate debate = new Debate();
			debate.setDebateid(id);
			debate.setDebatetitle(title);
			debate.setContent(content);
			debateRepository.save(debate);
	}
	@Override
	public void debatelistread(long id) {
		List<Debate> list=debateRepository.findAllByDebateid(id);
		session.setAttribute("debatelist", list);
	}
	
	@Override
	public String debateread(long id) {
		Debate debate = debateRepository.findById(id).get();
		session.setAttribute("debate", debate);
		return "debateread";
	}
}
