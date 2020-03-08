package com.mall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mall.user")
public class MallUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallUserApplication.class, args);
	}

}
