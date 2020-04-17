package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Freeboard;
import com.example.demo.pageMaker.PageMaker;
import com.example.demo.repository.FreeboardRepository;


@Service
public class FreeboardListService {

@Autowired
private FreeboardRepository freeboardRepository;
@Autowired
private HttpSession session;

@Autowired
private PageMakerService pagemakerservice;

 public String freeboardList(int pageNum){	 

	 PageMaker pageMaker =pagemakerservice.generatePagemaker(pageNum, 10, freeboardRepository);
	 PageRequest pagerequest = PageRequest.of(pageNum-1, 10, Sort.Direction.DESC, "freeid");
	 Page<Freeboard> freeboardPage = freeboardRepository.findAll(pagerequest); // findall은 원래 페이지로 리턴함
	 
	 if(freeboardPage.getSize() ==0) {
//예외처리를 위해서 빈 리스트를 리턴해줌.
		 session.setAttribute("boardList", new ArrayList<Freeboard>());
		 session.setAttribute("pagemaker", pageMaker);
		 return "freeboard";
	 }
	 List<Freeboard> freeboardList = freeboardPage.getContent(); // getContent 는 페이지를 리스트로 변환해줌
	 session.setAttribute("boardList", freeboardList);
	 session.setAttribute("pagemaker", pageMaker);
	 return "freeboard";
 }
}
