package com.wfr.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

/**
 *主程序类
 */
@ServletComponentScan(basePackages = "com.wfr.boot.webapi") // 扫描原生web组件，指定原生web组件位置
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

//        DataSource dataSourceBean = run.getBean(DataSource.class);
//        System.out.println(dataSourceBean.getClass());
//        System.out.println(dataSourceBean);
        System.out.println("111");
    }
}
