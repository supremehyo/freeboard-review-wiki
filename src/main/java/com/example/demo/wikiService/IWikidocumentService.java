package com.example.demo.wikiService;

import java.util.List;

import com.example.demo.wikimodel.Wikidocument;

public interface IWikidocumentService {
		
	void write(String title , String content);
	String read(String documentId);//그냥 읽는거
	void count(String title);
	void downwrite(String title,String content ,int linktitle);
	void rewrite(String title, String content);
	List <Wikidocument> readwikicount();
}
