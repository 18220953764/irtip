package com.whackon.itrip.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.whackon.itrip.util.constant.SystemContant;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>JWT工具类，用户令牌生成的校验</b>
 */
public class JWTUtil {
	private static Algorithm algorithm =Algorithm.HMAC256(SystemContant.SECRET_key);
	/**
	 * <b>生成令牌</b>
	 */
	public  static String createToken(Long id) throws Exception{
		//创建JWTBuilder对象，用于创建Token
		JWTCreator.Builder builder = JWT.create();

		//创建一个MAP集合，用于存储JWT的头部信息
		Map<String,Object> header = new HashMap<String,Object>();
		//设定加密算法
		header.put("alg", "HS256");
		//设定token类型
		header.put("typ", "JWT");

		//设置头部信息
		builder.withHeader(header);

		//设置有效载荷信息
		builder.withClaim("id", id);

		//使用算法进行签名，生成最终的Token字符串
		return builder.sign(algorithm);

	}

	/**
	 * 校验解密token，获得用户逐渐
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static Long validateToken(String token) throws Exception{
		if(token !=null && !"".equals(token.trim())){
			try {
				// 通过加密算法进行解密操作
				JWTVerifier verifier = JWT.require(algorithm).build();
				// 进行解密校验
				DecodedJWT decodedJWT = verifier.verify(token);
				// 当没有产生异常信息时，说明该token已经被成功识别，那么获取相关数据
				return decodedJWT.getClaim("id").asLong();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1L;
	}
}


