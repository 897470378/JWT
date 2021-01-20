package com.sikiedu.Cookie.Interceptors;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sikiedu.Cookie.Util.JwtUtils;

public class JWTInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		//获取请求头中的令牌
		String token = request.getHeader("token");
		
		System.out.println(token);
		
		try {
			JwtUtils.verify(token);
			//放行请求
			return true;
		} catch (SignatureVerificationException e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("msg", "无效签名");
		} catch (TokenExpiredException e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("msg", "token过期");
		} catch (AlgorithmMismatchException e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("msg", "token算法不一致");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("msg", "token无效");
		} 
		
		//设置状态
		map.put("state", false);
		
		String json = new ObjectMapper().writeValueAsString(map);
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		
		//将map转为json
		return false;
	}
}
