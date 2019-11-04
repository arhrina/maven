package com.biz.oracle.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 * static SqlSessionFactory 클래스를 객체로 선언하고
 * static {} 생성자에서 sqlSessionFactory 객체를 생성
 * getSelSessionFactory() 메서드에서 sqlSessionFactory를 return
 */
public class DBConnection {

	private static SqlSessionFactory sqlSessionFactory;
	
	
	static {
		
		String configFile = "com/biz/oracle/config/mybatis-config.xml";
		InputStream is = null;
		

		String encType = "PBEWithMD5AndDES";
		String encUser = "dKw0ifWBtbm+04TBiMU1Gw==";
		String encPassword = "MVeh/2RJ9XmuHqW3jrOMrQ==";
		// 암호화된 encUser, password를 복호화하기 위한 준비
		Map<String, String> systemENV = System.getenv();
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		pbEnc.setAlgorithm(encType);
		pbEnc.setPassword(systemENV.get("USERNAME")); // 환경변수의 USERNAME으로 암호화
		
		// 복호화된 문자열을 mybatis-config.xml에 전달
		Properties pros = new Properties();
		pros.put("username", pbEnc.decrypt(encUser));
		pros.put("password", pbEnc.decrypt(encPassword));
		
		try {
			is = Resources.getResourceAsStream(configFile);
			
			SqlSessionFactoryBuilder sessionFactoryBuilder
			= new SqlSessionFactoryBuilder();
			
			if(sqlSessionFactory == null) {
				sqlSessionFactory = sessionFactoryBuilder.build(is, pros);
				// pros 추가하고 mybatis-config.xml의 username, password를 수정
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
