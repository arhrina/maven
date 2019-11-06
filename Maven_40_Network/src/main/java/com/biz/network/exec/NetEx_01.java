package com.biz.network.exec;

import java.io.IOException;
import java.net.InetAddress;

public class NetEx_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * Inet.getByName()
		 * www.naver.com : Domain Name을 DNS에게 보내서 IP Address를 가져오는 메소드
		 */
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println(naver);
		
		InetAddress callor = InetAddress.getByName("callor.com");
		System.out.println(callor);
		
		System.out.println(naver.getHostAddress()); // ip address만
		System.out.println(naver.getHostName()); // domain만
		InetAddress local = InetAddress.getLocalHost();
		InetAddress loopBack = InetAddress.getLoopbackAddress();
		System.out.println("local : " + local);
		// local pc가 가지고 있는 ip. NIC(Network Interface Card)에 설정되있는 IP
		// 3번째까지 같으면 같은 대역에 있으며 데이터를 주고 받을 수 있다
		System.out.println("loopBack : " + loopBack);
		// 모든 application이 내부에서 통신할 수 있는 주소. 최초에는 통신Test용으로 만들어졌다
	}
}
