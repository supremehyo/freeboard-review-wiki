package com.example.demo.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.FreeboardComment;
import com.example.demo.repository.FreeboardCommnetRepository;

@Service
public class FreeboardCommentListService {

	@Autowired
	private FreeboardCommnetRepository freeboardCommnetRepository;
	public List<FreeboardComment> getList(Long freeid){
		List<FreeboardComment> freeboardCommentList = freeboardCommnetRepository.findByFreeid(freeid);
        int commentListSize = freeboardCommentList.size();
        if (commentListSize == 0) {
            return new ArrayList<FreeboardComment>();
        }
		LinkedList<FreeboardComment> CommentLinkedList = new LinkedList<FreeboardComment>();

        for (int i = 0; i < CommentLinkedList.size(); i++) {
            if (freeboardCommentList.get(i).getCommentlevel()==0) {//레벨 0 댓글들 먼저 연결리스트에 보관한다.
                CommentLinkedList.add(freeboardCommentList.get(i));//1개씩 추가한다.
            }
        }
        
		return freeboardCommentList;
	}
}
