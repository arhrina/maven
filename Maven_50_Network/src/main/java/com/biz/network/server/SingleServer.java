package com.biz.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * 현재 클래스를 서버로 사용하기 위해 네트워크 Layer의 전송계층의 접속정보를 생성
		 * localhost를 기반으로 8085번 port에서 클라이언트의 응답을 기다리기 위해 객체를 생성
		 */
		ServerSocket server = new ServerSocket(8085);
		System.out.println("Server Wait..");
		/*
		 * 클라이언트의 응답을 기다리기
		 * blocking이 되면서 누군가 네트워크를 통해서 접속하기를 기다린다
		 * 클라이언트가 접속을 하면 클라이언트의 정보가 담긴 또 다른 socket 객체를 return한다
		 * client 객체에는 접속한 client에 대한 여러가지 정보가 담겨있다
		 */
		Socket client = server.accept();
		String clientAddr = client.getInetAddress().toString();
		String clientPort = client.getLocalPort() + "";
		System.out.println("Client IP : " + clientAddr);
		System.out.println("Client Port : " + clientPort);
	}

}
