package com.biz.oracle.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "";
		String password = "";
		String salt = "com.biz.oracle";
		
		String encUser = "ZsQLMBXs7L5Cg0AB/2034Q==";
		String encPassword = "dBMoPKD1xUt2oyBTDhsdaQ==";
		
		// 문자열을 암호화시키기 위한 클래스
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		String encType = "PBEWithMD5AndDES";
		// 암호화 타입. MD5 또는 DES형식. 자바에서 가장 쉽게 접근할 수 있는 암호화타입
		// jasypt만으로 암호화를 시키는 방법
		
		pbEnc.setAlgorithm(encType); // 암호화타입을 MD5, DES로 지정
		pbEnc.setPassword(salt); // 키값
		user = pbEnc.decrypt(encUser); // 복호화
		password = pbEnc.decrypt(encPassword); // 복호화
		System.out.printf("%s -> %s\n", encUser, user); // 복호화된 값을 확인
		System.out.printf("%s -> %s\n", encPassword, password); // 복호화된 값을 확인
		
		// 키만 모른다면 알고리즘을 유추해낼 수 없기 때문에 강력한 암호화 방법이 될 수 있다
		
		/*
		 * iolist2 -> ZsQLMBXs7L5Cg0AB/2034Q==
		 * iolist2 -> dBMoPKD1xUt2oyBTDhsdaQ==
		 */
	}

}
