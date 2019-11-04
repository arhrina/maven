package com.biz.oracle.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "USERID";
		String password = "PASSWORD";
		String salt = "com.biz.oracle";
		
		// 문자열을 암호화시키기 위한 클래스
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		String encType = "PBEWithMD5AndDES";
		// 암호화 타입. MD5 또는 DES형식. 자바에서 가장 쉽게 접근할 수 있는 암호화타입
		// jasypt만으로 암호화를 시키는 방법
		
		pbEnc.setAlgorithm(encType); // 암호화타입을 MD5, DES로 지정
		pbEnc.setPassword(salt); // 키값
		String encUser = pbEnc.encrypt(user); // 암호화
		String encPassword = pbEnc.encrypt(password); // 암호화
		System.out.printf("%s -> %s\n", user, encUser); // 암호화된 값을 확인
		System.out.printf("%s -> %s\n", password, encPassword); // 암호화된 값을 확인
		
		// 키만 모른다면 알고리즘을 유추해낼 수 없기 때문에 강력한 암호화 방법이 될 수 있다
		/*
		 * iolist2 -> ZsQLMBXs7L5Cg0AB/2034Q==
		 * iolist2 -> dBMoPKD1xUt2oyBTDhsdaQ==
		 */
	}

}
