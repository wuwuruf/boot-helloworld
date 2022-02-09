package com.wfr.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Deprecated
//@Configuration // 以下为手动配置，但是有starter就不需要了
public class MyDataSourceConfig {

    @ConfigurationProperties("spring.datasource") // 绑定配置文件
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        // 开启Druid的监控功能
//        druidDataSource.setFilters("stat");  ==>  这些set的东西都可以在配置文件写
        return druidDataSource;
    }

    /**
     * 配置Druid的监控页功能
     *
     * @return
     */
    // 原生web组件的另一种注入方式
    @Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean
                = new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        // 添加账号密码
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","admin");
        statViewServletServletRegistrationBean.addInitParameter("loginPassword","123456");

        return statViewServletServletRegistrationBean;
    }

    // 手动配置的其他东西可以去看官方文档
}
