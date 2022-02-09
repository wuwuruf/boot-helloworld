package com.wfr.boot.controller;

import com.wfr.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // lombok注解，日志，自动加上log类
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(@RequestParam(name = "name1",required = false,defaultValue = "gugu") String name1){
        log.info("请求进来了");
        return "Hello, World!" + name1;
    }
}
