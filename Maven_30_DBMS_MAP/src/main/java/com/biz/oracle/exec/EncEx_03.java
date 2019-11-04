package com.biz.oracle.exec;

import java.util.Map;
import java.util.Set;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx_03 {

	public static void main(String[] args) {
		Map<String, String> systemENV = System.getenv();
		// OS의 환경변수값(윈도 cmd에서 set 입력시 나오는 것 중 일부)을 받아와서 맵에 저장하는 메소드
		System.out.println(systemENV);
		Set<String> keys = systemENV.keySet();
		for(String s : keys)
			System.out.printf("%s = %s\n", s, systemENV.get(s));
		
		// TODO Auto-generated method stub
		String user = "iolist2";
		String password = "iolist2";
		String salt = systemENV.get("USERNAME");
		// salt를 외부에 노출하지 않기 위해 환경변수 중 일부를 가져와서 사용
		// 문제는 배포시 해당하는 환경의 환경변수를 맞춰줘야한다
		// 암호화키를 최소한 소스코드에서는 감출 수 있다
		
		String encUser = "";
		String encPassword = "";
		
		// 문자열을 암호화시키기 위한 클래스
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		String encType = "PBEWithMD5AndDES";
		// 암호화 타입. MD5 또는 DES형식. 자바에서 가장 쉽게 접근할 수 있는 암호화타입
		// jasypt만으로 암호화를 시키는 방법
		
		pbEnc.setAlgorithm(encType); // 암호화타입을 MD5, DES로 지정
		pbEnc.setPassword(salt); // 키값
		encUser = pbEnc.encrypt(user); // 암호화
		encPassword = pbEnc.encrypt(password); // 암호화
		System.out.printf("%s -> %s\n", user, encUser); // 암호화된 값을 확인
		System.out.printf("%s -> %s\n", password, encPassword); // 암호화된 값을 확인
		
		// 키만 모른다면 알고리즘을 유추해낼 수 없기 때문에 강력한 암호화 방법이 될 수 있다
		
		/*
iolist2 -> BGwMzzZc0kykFnmJx3c+eg==
iolist2 -> 5eM/6vXW7MMWv98XJW6VKA==
		 */
	}

}
