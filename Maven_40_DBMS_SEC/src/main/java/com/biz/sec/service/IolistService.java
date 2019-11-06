package com.biz.sec.service;

import java.util.List;
import java.util.Map;

import com.biz.sec.config.DBConnection;
import com.biz.sec.mapper.IolistDao;

public class IolistService {
	protected IolistDao iDao;

// static{}, {} => 초기화블록
// static{} => static block
// {} => instance block
	{ // 인스턴스 생성자. IolistService의 생성자보다 먼저 실행되고 생성자 메소드와 관계없이 실행되는 코드 묶음
		// 생성자가 여러개 일 때 각 생성자마다 field를 초기화해줘야하는데, 생략을 하면 NullPointException이 발생할 수
		// 이럴 때 공통으로 초기화, 생성하는 코드들을 인스턴스 생성자에 작성해두면 생성자와 관계없이 자동으로 실행하여
		// NullPointException을 피할 수 있다
		iDao = DBConnection.getInstance().openSession(true).getMapper(IolistDao.class);
	}

	public void viewIolist() {
		List<Map<String, Object>> ioList = iDao.selectAllMap();
		for (Map<String, Object> i : ioList) {
			System.out.print(i.get("IO_SEQ") + "\n");
			System.out.print(i.get("IO_DATE") + "\n");
			System.out.print(i.get("IO_INOUT") + "\n");
			System.out.print(i.get("IO_QTY") + "\n");
			System.out.print(i.get("IO_PRICE") + "\n");
			System.out.print(i.get("IO_TOTAL") + "\n");
			System.out.print(i.get("IO_PCODE") + "\n");
			System.out.print(i.get("IO_DCODE") + "\n");
		}
	}
}
