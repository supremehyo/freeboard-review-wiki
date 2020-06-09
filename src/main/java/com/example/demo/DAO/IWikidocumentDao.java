package com.example.demo.DAO;

import java.util.List;

import com.example.demo.wikimodel.Wikidocument;

public interface IWikidocumentDao {
	void documentwrite(String title, String content);
	Wikidocument documentread(String title);
	List<Wikidocument> documentlinklist(int i); //20-06-08 수정 DAO랑 service 역할 분리하기 위해 추가
	void documentdownwrite(String title, String content);
	void documentdownupdate(String title,int linktitle);
	void documentrewrite(String title, String content);
	void documentcount(String title);
	List<Wikidocument> mostcoutdocument();
}
