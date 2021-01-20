package com.sikiedu.Cookie.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sikiedu.Cookie.bean.User;
import com.sikiedu.Cookie.mapper.jwtMapper;
import com.sikiedu.Cookie.service.jwtService;

@Service
public class jwtServiceImpl implements jwtService {

	@Resource
	private jwtMapper jwtmapper;

	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		User u = jwtmapper.loginUser(user);
		
		if(u != null)
		{
			return u;
		}
		
		throw new RuntimeException("登录失败");
	}
}
