package com.biz.sec.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnection {
	private static SqlSessionFactory sqlSessionFactory;
	// sqlSessionFactory를 이 프젝에서 하나만 만들어서 사용하겠다. SingleTone
	static {
		String configFile = "com/biz/sec/config/mybatis-config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			/* 암호화하고 삭제. DBMS에 접근할 username과 password를 실제 값으로 적용하고
			 * prj를 실행
			Properties pros = new Properties(); // 세팅값들을 모아서 설정을 하는 용도로 사용하는 클래스
			pros.put("username", USERNAME); // map같은 방식으로 설정
			pros.put("password", PASSWORD);
			*/
			if(sqlSessionFactory == null) {
				sqlSessionFactory = builder.build(is); // 세팅된 propertis 객체를 xml 대치문자에 전달인자로
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getInstance() {
		return sqlSessionFactory;
	}
}
