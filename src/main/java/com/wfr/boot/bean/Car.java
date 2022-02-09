package com.wfr.boot.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// lombok中的注解
@NoArgsConstructor // 无参构造器
@AllArgsConstructor // 全参构造器
@ToString // toString
@Data // get和set
@EqualsAndHashCode // 重写EqualsAndHashCode()

@Component
@ConfigurationProperties(prefix = "mycar")/* 该类的各属性与配置文件绑定，前缀为mycar */
public class Car {
    private String brand;
    private int price;

}
