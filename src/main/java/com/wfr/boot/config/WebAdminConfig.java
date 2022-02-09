package com.wfr.boot.config;

import com.wfr.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 定制Web功能的要实现WebConfigurer接口
@Configuration
public class WebAdminConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器注册中心添加拦截器
        // 链式调用方法
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")                 // 拦截所有请求，包括静态资源
                .excludePathPatterns("/login","/haha","/js/**","/css/**");  // 放行登录请求和静态资源
    }
}
