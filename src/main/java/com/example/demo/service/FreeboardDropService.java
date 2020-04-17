package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Freeboard;
import com.example.demo.repository.FreeboardRepository;
@Service
public class FreeboardDropService {

	
	@Autowired
	FreeboardRepository freeboardrepository;
	
	public void drop(String freeid) {
		Long longfreeid = Long.parseLong(freeid);
		freeboardrepository.deleteById(longfreeid);
	}
}
