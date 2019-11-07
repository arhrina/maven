package com.biz.network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLConnectionReader_02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String naverURL = "https://www.naver.com/index.html";
		String encNaverURL = URLEncoder.encode(naverURL, "UTF-8");
		// 일부 홈페이지(site)는 주소를 직접 URL로 요청할 때 주소변환과정 등의 문제로 접속이 불가능하다
		// 이때는 UTF-8로 주소를 인코딩해줘야 한다
		URL naver = new URL(naverURL);
		// URL naver = new URL("https://www.naver.com/");
		URLConnection naverOpen = naver.openConnection();
		// URL에 설정된 URL String을 사용하지 않고 OutputStream으로 전송된 인코딩된 URL String을 사용하여 서버에 접속		
		naverOpen.setDoOutput(true);

		
		// URL Encoding의 문제가 있을 경우 Encoding된 URL String을 OutputStreamWriter로 재전송
		OutputStreamWriter os = new OutputStreamWriter(naverOpen.getOutputStream());
		os.write(encNaverURL);
		os.close();
		
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
