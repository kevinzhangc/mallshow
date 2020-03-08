package com.mall.show.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mall.show.shopping","com.mall.show.commons"})
@MapperScan("com.mall.show.shopping.dal")
public class ShoppingProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingProviderApplication.class, args);
	}

}
