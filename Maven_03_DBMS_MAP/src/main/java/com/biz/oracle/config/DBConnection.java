package com.biz.oracle.config;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnection {

	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String configFile = "com/biz/oracle/config/mybatis-config.xml";
		InputStream inputStream = null;
		
		String encType = "PBEWithMD5AndDES";
		String encUser = "58USVwFMWDqG5ainM0BRSQ==";
		String encPassword = "q/nyOJHTisOsDdjtgrzu+A==";
		
		// 암호화된 encUser, encPassword를 복호화 하기 위한 준비
		Map<String,String> systemENV = System.getenv();
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		pbEnc.setAlgorithm(encType);
		pbEnc.setPassword(systemENV.get("USERNAME"));
		
		// 복호화된 문자열을 mybatis-config.xml에 전달하기 위한 절차
		Properties pros = new Properties();
		pros.put("username", pbEnc.decrypt(encUser));
		pros.put("password", pbEnc.decrypt(encPassword));
		
		try {
			inputStream = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			if(sqlSessionFactory == null) {
				sqlSessionFactory = builder.build(inputStream,pros);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
