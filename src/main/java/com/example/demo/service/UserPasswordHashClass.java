package com.example.demo.service;

import java.security.MessageDigest;

import org.springframework.stereotype.Service;

@Service
public class UserPasswordHashClass {


	public String getHash(String origin) {
		
		String shastring="";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(origin.getBytes());
			byte bytedata[] = sh.digest();
			StringBuffer stringbuffer = new StringBuffer();
			int byteSize = bytedata.length;
			
				for(int i =0 ; i < byteSize; i++)
				{
					stringbuffer.append(Integer.toString((bytedata[i] & 0xff)+0x100, 16).substring(1));
				}
				shastring = stringbuffer.toString();
				
		}
		catch(Exception e){
			e.printStackTrace();
			shastring = null;
			
		}
		
		return shastring;
	}
}
