package com.mall.shopping.mallshopping.config;

import com.mall.show.user.intercepter.TokenIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 *
 *
 * create-date: 2019/7/22-19:01
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public TokenIntercepter tokenIntercepter(){
        return new TokenIntercepter();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenIntercepter())
                .addPathPatterns("/shopping/**")
                .excludePathPatterns("/error");
    }
}
