package com.whackon.itrip.util;


/**
 * 使用正则验证工具类
 */
public class RegValidationUtil {
	//设置电子邮件正则表达式
	private static final String emailRegEx = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

	//判断电子邮件信息格式是否正确
	public static boolean validateEmail(String email) {
		// 判断此时的email地址不能为null，并且不能是空字符串
		if (email != null && !"".equals(email)) {
			return email.matches(emailRegEx);
		}
		return false;
	}


}
