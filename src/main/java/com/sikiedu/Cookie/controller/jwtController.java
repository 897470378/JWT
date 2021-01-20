package com.sikiedu.Cookie.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sikiedu.Cookie.Util.JwtUtils;
import com.sikiedu.Cookie.bean.User;
import com.sikiedu.Cookie.service.jwtService;

@RestController
public class jwtController {

	@Resource
	private jwtService jwtservice;
	
	@GetMapping("/user/login")
	public Map<String,Object> logUser(User user)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		
		try {
			User userDB = jwtservice.loginUser(user);
			
			Map<String,String> payload = new HashMap<String, String>();
			payload.put("id", userDB.getId().toString());
			payload.put("id", userDB.getUserName());
			
			//生成jwt令牌
			String token = JwtUtils.getToken(payload);
			
			map.put("state", true);
			map.put("msg", "认证成功");
			map.put("token", token);	//响应token
		} catch (Exception e) {
			// TODO: handle exception
			map.put("state", false);
			map.put("state", e.getMessage());
		}
		
		return map;
	}
	
	@PostMapping("/test")
	public Map<String,Object> test()
	{
		Map<String,Object> map = new HashMap<String, Object>();
		
		//处理自己的业务逻辑
		map.put("state", true);
		map.put("msg","请求成功");
		return map;
	}
}
