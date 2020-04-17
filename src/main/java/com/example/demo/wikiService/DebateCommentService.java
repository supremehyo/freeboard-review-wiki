package com.example.demo.wikiService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.DebateCommentDao;
import com.example.demo.wikimodel.DebateComment;

@Service
public class DebateCommentService implements IDebateCommentService{
	
	@Autowired
	DebateCommentDao debateCommentDao;
	@Override
      public void debateCommentwrite(String nickname, String content,long debateid) {
    	  debateCommentDao.write(nickname, content ,debateid);
      }
	
	@Override
	public List<DebateComment> getdebateCommentList(long id) {
		List<DebateComment>  debateCommentlist= debateCommentDao.getdebateCommentList(id);
		return debateCommentlist;
	}
}
