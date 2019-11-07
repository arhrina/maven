package com.biz.network.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

public class ServerThreadEx_02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket();
		InetSocketAddress iSocket = new InetSocketAddress(8085);
		server.bind(iSocket);
		ServerThreadV2 tServer = new ServerThreadV2(server);
		Thread tRun = new Thread(tServer); // Runnable이므로 Thread를 한번 거친다
		tRun.start();
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.print(">> ");
			String strSend = s.nextLine();
		}
	}
}
