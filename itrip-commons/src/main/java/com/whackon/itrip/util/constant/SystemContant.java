package com.whackon.itrip.util.constant;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Properties;

public class SystemContant {
	private  static Properties props = new Properties();

	static {
		try {
			props.load(SystemContant.class.getClassLoader().getResourceAsStream("prop/commons.properties"));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static final String SECRET_key = props.getProperty("secret.key");
}
