package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Freeboard;

public interface FreeboardRepository extends JpaRepository<Freeboard, Long> {
	@Transactional
	@Modifying
	@Query(value = "update example.freeboard set content=:content where freeid=:freeid" ,  nativeQuery = true)
	void update(@Param("content") String name, @Param("freeid") long freeid);
	//�Ķ���� �ٿ���Ҷ� �տ� : �� �־ ���ִ°���
}
