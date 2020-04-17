package com.example.demo.wikiRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.wikimodel.DebateComment;

public interface DebateCommentRepository extends JpaRepository<DebateComment, Long>{
		List<DebateComment> findByDebateid(long id);
}
