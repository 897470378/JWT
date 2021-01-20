package com.sikiedu.Cookie.Util;

import java.util.Calendar;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtils {

	// 签名
	private static final String SING = "!Q$%@e@5125";

	/*
	 * 生成token header.payload.sign
	 */
	public static String getToken(Map<String, String> map) {

		// 时间工具类,这里表示7天
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DATE, 7);

		// 创建jwtbuilder
		Builder builder = JWT.create();

		// payload
		map.forEach((k, v) -> {
			builder.withClaim(k, v);
		});

		String token = builder.withExpiresAt(instance.getTime()) // 指定过期时间
				.sign(Algorithm.HMAC256(SING)); // 指定sign

		return token;
	}

	/*
	 * 验证token合法性
	 */
	public static DecodedJWT verify(String token) {
		return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
	}
}
