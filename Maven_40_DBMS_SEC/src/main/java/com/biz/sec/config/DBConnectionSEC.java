package com.biz.sec.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnectionSEC {
	private static SqlSessionFactory sqlSessionFactory;
	// sqlSessionFactory를 이 프젝에서 하나만 만들어서 사용하겠다. SingleTone
	static {
		String saltPass = System.getenv()/* 맵 만드는 과정 생략하고 메소드 체이닝 */.get("BIZ");
		String configFile = "com/biz/sec/config/mybatis-config.xml";
		InputStream is = null;
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		String userName = "MDACR6pPSFSwlaxMxrCfGg==";
		String password = "+i4bGGpkYkpWvsOVfHTdug==";
		try {
			is = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			Properties pros = new Properties(); // 세팅값들을 모아서 설정을 하는 용도로 사용하는 클래스
			pros.put("username", pbEnc.decrypt(userName)); // map같은 방식으로 설정
			pros.put("password", pbEnc.decrypt(password));
			
			if(sqlSessionFactory == null) {
				sqlSessionFactory = builder.build(is, pros); // 세팅된 propertis 객체를 xml 대치문자에 전달인자로
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getInstance() {
		System.out.println("DB Connection");
		return sqlSessionFactory;
	}
}
