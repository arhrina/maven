package com.biz.sec.work;

import java.util.Map;
import java.util.Set;

public class SystemENV_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// java에서, OS에서 설정한 환경변수 불러오기 
		Map<String, String> envList = System.getenv();
		Set<String> keys = envList.keySet();
		for(String key : keys) {
			System.out.printf("KEY : %s, VALUE : %s\n", key, envList.get(key));
		}
		// 환경변수 중 BIZ 확인
		System.out.println(envList.get("BIZ"));
		System.out.println(envList.get("KOREA")); // 없는 변수면 null return
	}
}
