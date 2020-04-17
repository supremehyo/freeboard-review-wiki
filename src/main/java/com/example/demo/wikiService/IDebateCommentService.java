package com.example.demo.wikiService;

import java.util.List;

import com.example.demo.wikimodel.DebateComment;

public interface IDebateCommentService {
	void debateCommentwrite(String nickname, String content, long id );
	List<DebateComment> getdebateCommentList(long id);
}
