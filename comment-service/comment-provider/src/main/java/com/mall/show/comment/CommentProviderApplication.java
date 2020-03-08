package com.mall.show.comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mall.show.comment","com.mall.show.commons"})
@MapperScan("com.mall.show.comment.dal")
public class CommentProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentProviderApplication.class, args);
	}

}
