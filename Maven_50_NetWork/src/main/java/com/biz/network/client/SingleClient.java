package com.biz.network.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * 네트워크에서 Client
 * 필요에 따라서 실행을 하여 Server에게 무엇인가 요청을 하고
 * 결과를 기다리는 구조
 * 
 */
public class SingleClient {

	public static void main(String[] args) throws IOException{
		
		String serverIP = "192.168.123.45"; // client에서 접속하고자 하는 서버 IP
		int serverPort = 8085; // client에서 접속하고자 하는 서버의 Port
		Socket mySocket = new Socket(serverIP, serverPort);
		Scanner scan = new Scanner(System.in);
		
		// 서버에서 전송되어올 메시지를 수신하기 위해서
		InputStream is = mySocket.getInputStream();
		DataInputStream data = new DataInputStream(is);
		
		// Server에게 메시지를 전송하기 위해
		OutputStream os = mySocket.getOutputStream();
		
		
		String msg = "";
		while(true) {
			
			System.out.print(" >> ");
			String sendMsg = scan.nextLine();
			
			// 서버에게 보낼 문자열을 byte형식의 배열값을 변환하기 위해
			// 일시로 사용할 메모리 버퍼를 선언
			// 키보드에서 입력된 문자열을 UTF-8방식으로 인코딩하여
			// buffer 배열변수에 저장
			byte[] buffer = sendMsg.getBytes("UTF-8");
			os.write(buffer);
			
			// msg = data.readUTF();
			// System.out.println("Server:" + msg);
		}
			
		
		
	}
}
