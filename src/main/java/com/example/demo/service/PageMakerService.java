package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.Model.Freeboard;
import com.example.demo.pageMaker.PageMaker;

@Service
public class PageMakerService {

	public PageMaker generatePagemaker(int pageNum , int countNum , 
			JpaRepository<Freeboard, Long> repository) {
		int totalcount = (int)repository.count();
		PageMaker pagemaker = new PageMaker();
		
        pagemaker.setTotalcount(totalcount);//전체 게시글 개수 지정한다
        pagemaker.setPagenum(pageNum-1);//현재 페이지를 페이지 객체에 다시 지정해준다//몇번 페이지인지 PageMaker에 세팅한다
        pagemaker.setContentnum(countNum);//한 페이지에 몇개씩 보여줄지 세팅한다
        pagemaker.setCurrentblock(pageNum);//현재 페이지블록이 몇번인지 현재 페이지 번호를 통해서 지정한다
        pagemaker.setLastblock(pagemaker.getTotalcount());//마지막 블록 번호를 전체 게시글 수를 통해서 정한다
        
        pagemaker.prevnext(pageNum);//현재 페이지 번호로 화살표 나타낼지 결정한다
        pagemaker.setStartPage(pagemaker.getCurrentblock());//시작페이지 번호를 현재 페이지 블록으로 정한다
        pagemaker.setEndPage(pagemaker.getLastblock(),pagemaker.getCurrentblock());
        //현재 블록 번호와 마지막 블록 번호를 보내서 대조하고 페이지 블록의 마지막 번호를 지정한다

        return pagemaker;

	}
	
}