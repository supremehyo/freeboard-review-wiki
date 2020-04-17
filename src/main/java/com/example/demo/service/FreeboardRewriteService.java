package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.FreeboardRepository;

@Service
public class FreeboardRewriteService {
	@Autowired
	FreeboardRepository freeboardrepository;
	
	public String Rewrite(String updatestring,String freeid) {
		Long longfreeid = Long.parseLong(freeid);
		freeboardrepository.update(updatestring, longfreeid);
		return "";
	}
}
