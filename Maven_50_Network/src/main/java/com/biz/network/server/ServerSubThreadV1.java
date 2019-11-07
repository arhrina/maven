package com.biz.network.server;

import java.io.InputStream;
import java.net.Socket;

// 여러 client가 접속했을 시 client별로 Thread를 생성하고 메시지 수신을 처리
// 접속되는 client마다 thread를 생성
public class ServerSubThreadV1 implements Runnable {
	Socket client = null;
	int id = 0;
	
	public ServerSubThreadV1(Socket client, int id) {
		this.client = client;
		this.id = id;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			InputStream is = client.getInputStream();
			byte[] reader = new byte[255];
			int msgSize = is.read(reader);
			String msg = new String(reader, 0, msgSize, "UTF-8");
			System.out.printf("ID(%d) : %s\n", id, msg);
		} catch (Exception e) {
			// TODO: handle exception
			// client가 강제로 접속을 멈추면 Exception이 발생하는데 Exception 발생시 콘솔에 USER OUT 출력
			System.out.println(this.id + " USER OUT ");
		}
	}
}
