package com.example.demo.wikiRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.wikimodel.Debate;
import com.example.demo.wikimodel.Wikidocument;


public interface DebateRepository extends JpaRepository<Debate, Long>{
	List<Debate> findAllByDebateid(long id);
}
