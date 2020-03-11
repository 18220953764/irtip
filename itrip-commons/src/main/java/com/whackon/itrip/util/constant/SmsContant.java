package com.whackon.itrip.util.constant;

import java.util.Properties;

/**
 * <b>短信发送功能常量信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class SmsContant {
	private static final Properties props = new Properties();

	static {
		try {
			props.load(SmsContant.class.getClassLoader().getResourceAsStream("prop/sms.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static final String SMS_ADDRESS = props.getProperty("sms.address");

	public static final String SMS_PORT = props.getProperty("sms.port");

	public static final String SMS_ACCOUNTSID = props.getProperty("sms.accountsid");

	public static final String SMS_ACCOUNTTOKEN = props.getProperty("sms.accounttoken");

	public static final String SMS_APPID = props.getProperty("sms.appid");

	public static final String SMS_TEMPID = props.getProperty("sms.tempid");
}
