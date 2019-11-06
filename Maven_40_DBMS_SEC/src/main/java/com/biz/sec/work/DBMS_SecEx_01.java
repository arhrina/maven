package com.biz.sec.work;

import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 * jasypt를 사용하여 문자열을 암호화
 * 
 * 평문(planText) : 읽을 수 있는 문자열
 * 암호문(cryptText) : 읽을 수는 있지만 무슨 내용인진 알 수 없는 형태
 */
public class DBMS_SecEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 환경변수 사용하기 위해 가져오기
		Scanner s = new Scanner(System.in);
		Map<String, String> envList = System.getenv();
		
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
		
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		String saltPass = envList.get("BIZ"); // 암복호화시 사용할 키. RUN하는 컴퓨터마다 세팅이 필요
		pbEnc.setPassword(saltPass);
		
		System.out.print("username >> ");
		String planUserName = s.nextLine();
		System.out.print("password >> ");
		String planPassword = s.nextLine();
		
		String encUserName = pbEnc.encrypt(planUserName);
		String encPassword = pbEnc.encrypt(planPassword);
		
		System.out.printf("username : %s\t\t\tencText : %s\n", planUserName, encUserName);
		System.out.printf("password : %s\t\t\tencText : %s\n", planPassword, encPassword);
		
		String decUserName = pbEnc.decrypt(encUserName);
		String decPassword = pbEnc.decrypt(encPassword);
		System.out.printf("encUsername : %s\t\t\tdecUsername : %s\n", encUserName, decUserName);
		System.out.printf("encPassword : %s\t\t\tdecPassword : %s\n", encPassword, decPassword);
		/*
		 * username : MDACR6pPSFSwlaxMxrCfGg==
		 * password : +i4bGGpkYkpWvsOVfHTdug==
		 */
	}
}
