package com.biz.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThreadV2 implements Runnable {
	ServerSocket server = null;
	public ServerThreadV2(ServerSocket server) {
		// TODO Auto-generated constructor stub
		this.server = server;
	}
	public void run() {
		// TODO Auto-generated method stub
		Socket client = null;
		// 클라이언트 응답 대기
		try {
			int id = 0;
			while(true) {
				// int id = (int)(Math.random() * 100);
				client = this.server.accept();
				ServerSubThreadV1 ss = new ServerSubThreadV1(client, ++id);
				Thread tRun = new Thread(ss);
				tRun.start();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
