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
	//어떤 문서의 하위문서로 작성이 될때 자신의 상위문서의 id 를 업데이트한다.
	
	@Transactional
	@Modifying
	@Query(value="update wikidocument set content = :content where title = :title", nativeQuery=true)
	void rewrite(@Param("title") String title,@Param("content") String content);
	
	@Transactional
	@Modifying
	@Query(value="update wikidocument set count = count+1 where title = :title", nativeQuery=true)
	void countup(@Param("title") String title); //읽기요청이 된 title 을 기준으로 count 를 올린다.
	
	@Transactional
	@Modifying
	@Query(value="select * from wikidocument  order by count desc limit 10;", nativeQuery=true)
	List <Wikidocument> countlist(); // 상위 10개를 내림차순으로 정렬한다.
	
}
