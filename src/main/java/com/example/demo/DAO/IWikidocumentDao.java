package com.example.demo.DAO;

import java.util.List;

import com.example.demo.wikimodel.Wikidocument;

public interface IWikidocumentDao {
	void documentwrite(String title, String content);
	String documentread(String title);
	void documentdownwrite(String title, String content);
	void documentdownupdate(String title,int linktitle);
	void documentrewrite(String title, String content);
	void documentcount(String title);
	List<Wikidocument> mostcoutdocument();
}
