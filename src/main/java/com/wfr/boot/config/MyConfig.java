package com.wfr.boot.config;

import com.wfr.boot.MainApplication;
import com.wfr.boot.bean.Car;
import com.wfr.boot.bean.User;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration
// @EnableConfigurationProperties({Car.class})
public class MyConfig {

    @Bean
    public User user01(){
        return new User(19, "wfr","123456");
    }

    @ConditionalOnBean(name = "user01")
    @Bean
    public  User user02(){
        return new User(21, "gugu","123456");
    }

    @ConditionalOnMissingBean(name = "user01")
    @Bean
    public  User user03(){
        return new User(22, "gugunb","123456");
    }

    // 开启矩阵变量需要的操作：
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 配置不移除";"后面的内容
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }


    public static void main(String[] args) {
        // 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        String[] runBeanDefinitionNames = run.getBeanDefinitionNames();
        for (int i = 0; i < runBeanDefinitionNames.length; i++) {
            System.out.println(runBeanDefinitionNames[i]);
        }
    }
}
