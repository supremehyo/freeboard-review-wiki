package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.FreeboardComment;

public interface FreeboardCommnetRepository extends JpaRepository<FreeboardComment, Long>{
	List<FreeboardComment> findByFreeid(long freeid);

}
