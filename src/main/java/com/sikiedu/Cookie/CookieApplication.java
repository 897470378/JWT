package com.sikiedu.Cookie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.sikiedu.Cookie.mapper")
@SpringBootApplication
public class CookieApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookieApplication.class, args);
	}
}
