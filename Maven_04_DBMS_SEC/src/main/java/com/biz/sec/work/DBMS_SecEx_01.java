package com.biz.sec.work;

import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 * jasypt 도구를 사용하여 문자열을 암호화 하는 Test 수행
 * 
 * 평문자열(plantext) : 읽을수 있는 문자열
 * 암호화된 문자뎔(cryptText) : 읽을수는 있지만 무슨 내용인지 알 수 없는 형태
 * 
 */
public class DBMS_SecEx_01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// java 환경변수 가져오기
		Map<String, String> envList = System.getenv(); 
		
		
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(envList.get("BIZ"));
		
		// 암호화와 복호화를 수행할때 필요할 key
		String saltPass = envList.get("BIZ");
		System.out.print("username >> ");
		String planUserName = scan.nextLine();
		
		System.out.print("password >> ");
		String planPassword = scan.nextLine();
		
		String encUserName = pbEnc.encrypt(planUserName);
		String encPassword = pbEnc.encrypt(planPassword);
		
		
		
		
		System.out.printf("username : %s, %s\n",planUserName,encUserName);
		System.out.printf("password : %s, %s\n",planPassword,encPassword);
		
//		username :  6yOLBytB19pYygL9t9/ZMQ==
//		password :  f+bYsAKGthDRiNEWa+QQ8A==
		
	}
}




























