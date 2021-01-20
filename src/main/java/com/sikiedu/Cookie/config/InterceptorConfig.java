package com.sikiedu.Cookie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sikiedu.Cookie.Interceptors.JWTInterceptor;


/*配置拦截器*/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new JWTInterceptor())
				.addPathPatterns("/**")					//拦截所有（接口需要token验证）
				.excludePathPatterns("/user/**");		//不拦截用户相关的访问
	}
}
