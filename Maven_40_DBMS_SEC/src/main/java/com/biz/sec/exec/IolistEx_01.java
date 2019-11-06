package com.biz.sec.exec;

import com.biz.sec.config.DBConnectionSEC;

public class IolistEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnectionSEC.getInstance().openSession(true); // mybatis-config.xml, DBConnec~~, iolist-mapper.xml 테스트
		
	}
}
