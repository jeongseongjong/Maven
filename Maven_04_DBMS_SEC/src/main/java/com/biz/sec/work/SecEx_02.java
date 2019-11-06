package com.biz.sec.work;

import java.util.Map;

import java.util.Map;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 * jasypt 도구를 사용하여 문자열을 암호화 하는 Test 수행
 * 
 * 평문자열(plantext) : 읽을수 있는 문자열
 * 암호화된 문자뎔(cryptText) : 읽을수는 있지만 무슨 내용인지 알 수 없는 형태
 * 
 */
public class SecEx_02 {

	public static void main(String[] args) {
		
		// java 환경변수 가져오기
		Map<String, String> envList = System.getenv(); 
		
		
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		// 암호화와 복호화를 수행할때 필요할 key
		String saltPass = envList.get("BIZ");
		
		String planText1 = "java";
		String planText2 = "Republic of Korea";
		
		String encText1 = "";
		String encText2 = "";
		
		/*
		 * 암호화를 수행하는 코드
		 */
		
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		// 암호화
		encText1 = pbEnc.encrypt(planText1);
		encText2 = pbEnc.encrypt(planText2);
		
		System.out.printf("plan : %s, enc : %s\n",planText1,encText1);
		System.out.printf("plan : %s, enc : %s\n",planText2,encText2);
		
		// 복호화
		String decText1 = pbEnc.decrypt(encText1);
		String decText2 = pbEnc.decrypt(encText2);
		
		System.out.printf("enc : %s, dec : %s\n", encText1, decText1);
		System.out.printf("enc : %s, dec : %s\n", encText2, decText2);
	}
}




























