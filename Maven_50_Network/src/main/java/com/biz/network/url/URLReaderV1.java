package com.biz.network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReaderV1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL naver = new URL("https://www.naver.com/");
		InputStreamReader in = new InputStreamReader(naver.openStream());
		BufferedReader br = new BufferedReader(in);
		String reader = "";
		while(true) {
			reader = br.readLine();
			if(reader == null) break;
			System.out.println(reader);
		}
	}
}
