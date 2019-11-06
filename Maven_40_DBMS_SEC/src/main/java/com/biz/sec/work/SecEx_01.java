package com.biz.sec.work;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 * jasypt를 사용하여 문자열을 암호화
 * 
 * 평문(planText) : 읽을 수 있는 문자열
 * 암호문(cryptText) : 읽을 수는 있지만 무슨 내용인진 알 수 없는 형태
 */
public class SecEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		// java에서 쉽게 암복호화를 할 수 있는 클래스
		/*
		 * 암호화의 종류 : 단방향, 양방향
		 * 		가. 단방향 : 평문에서 암호문으로 암호화는 가능하지만 복호화는 불가능. 보안측면에서 유리하지만
		 * 					사용에 제약이 있다
		 * 		나. 양방향 : 암호화, 복호화가 모두 가능. 보안성은 다소 떨어져도 편리성이 있다
		 * 					만약 salt key가 노출되면 암호가 풀려버리므로 관리해주어야한다
		 * 
		 *  jasypt는 양방향이 가능
		 *  
		 *  java에서 DBMS를 연결하려면 userID와 password를 기록해야되는데 jdbc Connection 코드에 내용이 노출되어
		 *  보안이 취약하다
		 *  
		 *  최소한 소스코드만이라도 암호화하여 보안을 유지하기 위해 jasypt를 사용하는데
		 *  전송하는 과정에서는 평문으로 데이터를 보내야 하므로 단방향은 사용이 불가능하다
		 */
		
		String saltPass = "com.biz"; // 암복호화시 사용할 키
		String planText1 = "java";
		String planText2 = "Republic of Korea";
		
		String encText1 = "";
		String encText2 = "";
		
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		encText1 = pbEnc.encrypt(planText1); // 암호화
		encText2 = pbEnc.encrypt(planText2);
		
		System.out.printf("planText : %s\t\t\tencText : %s\n", planText1, encText1);
		System.out.printf("planText : %s\t\t\tencText : %s\n", planText2, encText2);
		
		String decText1 = pbEnc.decrypt(encText1); // 복호화
		String decText2 = pbEnc.decrypt(encText2);
		
		System.out.printf("encText : %s\t\t\tdecText : %s\n", encText1, decText1);
		System.out.printf("encText : %s\t\t\tdecText : %s\n", encText2, decText2);
		// 시스템에 환경변수 새로 만들기
	}
}
