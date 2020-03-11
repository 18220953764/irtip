package com.whackon.itrip.util;

import com.cloopen.rest.sdk.CCPRestSDK;
import com.whackon.itrip.util.constant.SmsContant;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

/**
 * <b>短信发送工具类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("smsSenderUtil")
public class SmsSenderUtil {

	/**
	 * <b>根据用户手机号码发送短信验证码</b>
	 * @param userCode
	 * @param activeCode
	 * @return
	 * @throws Exception
	 */
	public boolean sendSms(String userCode, String activeCode) throws Exception {
		HashMap<String, Object> result = null;

		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init(SmsContant.SMS_ADDRESS, SmsContant.SMS_PORT);// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.setAccount(SmsContant.SMS_ACCOUNTSID, SmsContant.SMS_ACCOUNTTOKEN);// 初始化主帐号和主帐号TOKEN
		restAPI.setAppId(SmsContant.SMS_APPID);// 初始化应用ID
		result = restAPI.sendTemplateSMS(userCode, SmsContant.SMS_TEMPID, new String[]{activeCode, "30"});

		System.out.println("SDKTestSendTemplateSMS result=" + result);

		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
			return true;
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
		return false;
	}
}
