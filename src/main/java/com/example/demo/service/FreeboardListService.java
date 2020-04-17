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
	 Page<Freeboard> freeboardPage = freeboardRepository.findAll(pagerequest); // findall�� ���� �������� ������
	 
	 if(freeboardPage.getSize() ==0) {
//����ó���� ���ؼ� �� ����Ʈ�� ��������.
		 session.setAttribute("boardList", new ArrayList<Freeboard>());
		 session.setAttribute("pagemaker", pageMaker);
		 return "freeboard";
	 }
	 List<Freeboard> freeboardList = freeboardPage.getContent(); // getContent �� �������� ����Ʈ�� ��ȯ����
	 session.setAttribute("boardList", freeboardList);
	 session.setAttribute("pagemaker", pageMaker);
	 return "freeboard";
 }
}
