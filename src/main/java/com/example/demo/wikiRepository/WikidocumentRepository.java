package com.example.demo.wikiRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.wikimodel.Wikidocument;

public interface WikidocumentRepository extends JpaRepository<Wikidocument, Long> {

	Wikidocument findByTitle(String title);
	List<Wikidocument> findAllByLinktitle(int id);
	@Transactional
	@Modifying
	@Query(value="update wikidocument set linktitle = :linktitle where title = :title", nativeQuery=true)
	void downupdate(@Param("title") String title,@Param("linktitle") int linktitle);
	
	@Transactional
	@Modifying
	@Query(value="update wikidocument set content = :content where title = :title", nativeQuery=true)
	void rewrite(@Param("title") String title,@Param("content") String content);
	
	@Transactional
	@Modifying
	@Query(value="update wikidocument set count = count+1 where title = :title", nativeQuery=true)
	void countup(@Param("title") String title);
	
	@Transactional
	@Modifying
	@Query(value="select * from wikidocument  order by count desc limit 10;", nativeQuery=true)
	List <Wikidocument> countlist();
	
}
