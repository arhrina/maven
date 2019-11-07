package com.biz.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BindServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

		ServerSocket server = new ServerSocket(); // 소켓 생성
		
		InetSocketAddress iSocket = new InetSocketAddress(8085); // 기다릴 포트를 생성
		// 사용중인 포트인지 검사하는 절차가 내부에서 수행된다
		
		server.bind(iSocket); // bind Server를 만들기. 소켓번호로 지정하지 않고 bind 메소드로 지정
		// 서버 소켓에 포트정보를 연결
		// 포트가 사용중이라면 포트가 잠겨버리는 경우를 방지할 수 있다
		System.out.println("Server Wait..");
		Socket client = server.accept();
		InputStream is = client.getInputStream();
		// java의 *Stream은 파일, 네트워크, 콘솔, 프린터 등의 입출력 장치와 연동을 쉽게 하기 위한 클래스이다
		// 기능별로 연결만 해준다면 사용법은 거의 비슷하다
		
		while(true) {
			byte[] msg = new byte[255]; // 한번에 처리할 메세지의 크기를 지정. 버퍼 크기를 255바이트로 지정
			int imgSize = is.read(msg);
			// read는 클라이언트에서 전송된 메세지를 msg 배열변수에 담고 바이트 개수를 imgSize에 return
			String strMsg = new String(msg, 0, imgSize, "UTF-8");
			// String을 사용하여 바이트배열에 담긴 데이터를 UTF-8로 디코딩해 읽을 수 있는 문자열로 변환
			System.out.println(strMsg);
			if(strMsg.equals("-Q")) break;
		}
		System.out.println("Good Bye!! Stop Server!!");
	}
}
