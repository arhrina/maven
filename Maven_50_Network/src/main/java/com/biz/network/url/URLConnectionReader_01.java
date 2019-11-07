package com.biz.network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLConnectionReader_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/* String naverURL = "https://www.naver.com/";
		String encNaverURL = URLEncoder.encode(naverURL, "UTF-8");
		// 일부 홈페이지(site)는 주소를 직접 URL로 요청할 때 주소변환과정 등의 문제로 접속이 불가능하다
		// 이때는 UTF-8로 주소를 인코딩해줘야 한다
		URL naver = new URL(encNaverURL); */
		URL naver = new URL("https://www.naver.com/");
		URLConnection naverOpen = naver.openConnection();
		naverOpen.connect();// 실제로 사용하지 않으며, Stream이 작동될때마다 내부에서 반복수행된다
		// URLConnection을 이용하면 URL만 쓰는거(한글이 있을 때)보다 수월하게 접속이 가능
		BufferedReader br = new BufferedReader(new InputStreamReader(naverOpen.getInputStream()));
		String reader = "";
		while(true) {
			reader = br.readLine();
			if(reader == null) break;
			System.out.println(reader);
		}
		br.close();
	}
}
