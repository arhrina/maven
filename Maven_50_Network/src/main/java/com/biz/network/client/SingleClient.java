package com.biz.network.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * 네트워크에서의 Client
 * 
 * 필요에 따라 실행해서 서버에게 무엇인가 요청을 하고 결과를 기다리는 구조
 */
public class SingleClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String serverIP = "192.168.123.45"; // 접속하고자 하는 서버의 IP
		int serverPort = 8085; // 접속하고자 하는 서버의 Port
		// 위의 두개가 동시에 맞아야 한다. 소켓을 만들면서 서버 ip랑 포트를 전달하는 방법이 가장 무난하다
		Socket mySocket = new Socket(serverIP, serverPort);	// 서버가 아니므로 서버소켓이 아니고 그냥 소켓을 사용
		Scanner s = new Scanner(System.in);
		InputStream is = mySocket.getInputStream();
		DataInputStream data = new DataInputStream(is);
		OutputStream os = mySocket.getOutputStream(); // 서버에게 메시지전송을 위한 스트림
		String msg = "";
		while(true) {
			System.out.print(" >> ");
			String sendMsg = s.nextLine();
			
			byte[] buffer = sendMsg.getBytes("UTF-8"); // 서버에 보낼 문자열을 바이트배열로 변환할 임시의 메모리 버퍼
			// 키보드 입력을 UTF-8로 인코딩해서 버퍼 배열에 저장
			os.write(buffer);
			/* msg = data.readUTF();
			System.out.println("server : " + msg);
			*/
		}
	}
}
