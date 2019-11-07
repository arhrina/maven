package com.biz.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThreadV1 implements Runnable {
	ServerSocket server = null;
	public ServerThreadV1(ServerSocket server) {
		// TODO Auto-generated constructor stub
		this.server = server;
	}
	public void run() {
		// TODO Auto-generated method stub
		Socket client = null;
		
		try {
			client = this.server.accept();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("client : " + client.getInetAddress().toString());
		
		InputStream is = null;
		try {
			is = client.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			byte[] reader = new byte[255];
			try {
				int msgSize = is.read(reader);
				String message = new String(reader, 0, msgSize, "UTF-8");
				System.out.println(message);
				if(message.equals("-Q"))
					break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Server STOP");
	}
}
