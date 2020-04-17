package com.example.demo.DAO;

import java.util.List;

import com.example.demo.wikimodel.DebateComment;

public interface IDebateCommentDao {
	void write( String nickname , String content ,long id );
	List<DebateComment> getdebateCommentList(long id);
}
