package com.example.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.wikiRepository.DebateCommentRepository;
import com.example.demo.wikiRepository.DebateRepository;
import com.example.demo.wikimodel.DebateComment;

@Component
public class DebateCommentDao implements IDebateCommentDao{
	@Autowired
	private DebateCommentRepository debateCommentRepository;

	
		@Override
		public void write( String nickname , String content, long debateid ) {
		 DebateComment debatecomment = new DebateComment();
		 debatecomment.setDebateid(debateid);
		 debatecomment.setNickname(nickname);
		 debatecomment.setContent(content);
		 debateCommentRepository.save(debatecomment);
		//Service 로 부터 전달받은 정보가 담긴 debatecomment 객체를 DB에 저장한다.
		}
		@Override
		public List<DebateComment> getdebateCommentList(long id) {
			List<DebateComment> debateCommentlist = debateCommentRepository.findByDebateid(id);
	        int commentListSize = debateCommentlist.size();
	        if (commentListSize == 0) {
	            return new ArrayList<DebateComment>();
	        }
			return debateCommentlist;
		}
}
