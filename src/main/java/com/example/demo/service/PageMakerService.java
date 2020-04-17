package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.Model.Freeboard;
import com.example.demo.pageMaker.PageMaker;

@Service
public class PageMakerService {

	public PageMaker generatePagemaker(int pageNum , int countNum , JpaRepository<Freeboard, Long> repository) {
		int totalcount = (int)repository.count();
		PageMaker pagemaker = new PageMaker();
		
		/*---------������ ��ü�� ���ο� ���� �ٽ� �������ִ� �κ�------------------*/
        pagemaker.setTotalcount(totalcount);//��ü �Խñ� ���� �����Ѵ�
        pagemaker.setPagenum(pageNum-1);//���� �������� ������ ��ü�� �ٽ� �������ش�//��� ���������� PageMaker�� �����Ѵ�
        pagemaker.setContentnum(countNum);//�� �������� ��� �������� �����Ѵ�
        pagemaker.setCurrentblock(pageNum);//���� ����������� ������� ���� ������ ��ȣ�� ���ؼ� �����Ѵ�
        pagemaker.setLastblock(pagemaker.getTotalcount());//������ ��� ��ȣ�� ��ü �Խñ� ���� ���ؼ� ���Ѵ�
    /*---------������ ��ü�� ���ο� ���� �ٽ� �������ִ� �κ�------------------*/
        
        pagemaker.prevnext(pageNum);//���� ������ ��ȣ�� ȭ��ǥ ��Ÿ���� �����Ѵ�
        pagemaker.setStartPage(pagemaker.getCurrentblock());//���������� ��ȣ�� ���� ������ ������� ���Ѵ�
        pagemaker.setEndPage(pagemaker.getLastblock(),pagemaker.getCurrentblock());
        //���� ��� ��ȣ�� ������ ��� ��ȣ�� ������ �����ϰ� ������ ����� ������ ��ȣ�� �����Ѵ�

        return pagemaker;

	}
	
}
