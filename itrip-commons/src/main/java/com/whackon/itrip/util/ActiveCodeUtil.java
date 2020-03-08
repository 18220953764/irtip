package com.whackon.itrip.util;

import java.util.Random;

/**
 * <b>激活码生成工具类</b>
 */
public class ActiveCodeUtil {

	/**
	 * <b>随机生成六位激活码</b>
	 * @return
	 */
	public static String createActiveCode() {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
}
