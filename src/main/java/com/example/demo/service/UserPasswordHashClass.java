package com.example.demo.service;

import java.security.MessageDigest;

import org.springframework.stereotype.Service;

@Service
public class UserPasswordHashClass {
	public String getHash(String origin) {
		
		String shastring="";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			//SHA-256 로 해쉬 암호화를 한다.
			sh.update(origin.getBytes()); //update()는 지정된 바이트 데이터를
			//사용해 Digest를 갱신한다. 
			byte bytedata[] = sh.digest();//digest()는 바이트배열로 해쉬를 반환한다.
			StringBuffer stringbuffer = new StringBuffer();
			int byteSize = bytedata.length;
				for(int i =0 ; i < byteSize; i++)
				{
					stringbuffer.append(Integer.toString((bytedata[i] & 0xff)+0x100, 16).substring(1));
					//해쉬된 데이터는 바이트 배열의 바이너리 데이터이므로 16진수 문자열로 변환해서 사용한다.
				}
				shastring = stringbuffer.toString();	
		}
		catch(Exception e){ // 오류처리
			e.printStackTrace();
			shastring = null;
		}
		return shastring; 
	}
}
