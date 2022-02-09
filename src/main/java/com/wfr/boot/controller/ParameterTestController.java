package com.wfr.boot.controller;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    // @GetMapping是一个组合注解,等价于@RequestMapping(method = RequestMethod.Get)
    @GetMapping("/test01/{username}/and/{age}")/* restful写法 */
    public Map<String, Object> test01(@PathVariable("username") String name,
                                      @PathVariable("age") int age,
                                      @PathVariable Map<String, String> kv, /* 必须是String，String的Map */
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> headers,
                                      @RequestParam("height") Integer height,
                                      @RequestParam("hobbies") List<String> hobbies,
                                      @RequestParam Map<String, String> params/* 这里Map后面那个String有点问题，收不到list */
                                     /* @CookieValue("_ga") String _ga,
                                      @CookieValue("_ga") Cookie cookie 我没_ga这个cookie*/) {

        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("username", name);
        stringObjectMap.put("age", age);
        stringObjectMap.put("kv", kv);
        stringObjectMap.put("userAgent", userAgent);
        stringObjectMap.put("headers", headers);
        stringObjectMap.put("height", height);
        stringObjectMap.put("hobbies", hobbies);
        stringObjectMap.put("params", params);
//        stringObjectMap.put("_ga", _ga);
//        System.out.println(cookie.getName());

        return stringObjectMap;
    }

    @PostMapping("/test02/")
    public String test02(@RequestBody String content){
        return content;
    }

    // 矩阵变量
    // 格式: /test03/{path};username=wfrrr;hobbies=basketball,tennis,football
    // SpringBoot默认没有开启矩阵变量的支持，需要手动配
    // 矩阵变量需要绑定在路径变量中,可以用pathVar指定是哪个路径变量下的矩阵变量
    @GetMapping("/test03/{path}")
    public Map test03(@MatrixVariable(value = "username",pathVar = "path") String username,
                      @MatrixVariable("hobbies") List<String> hobbies,
                      @PathVariable("path") String path){
        Map<String, Object> map = new HashMap<>();
        map.put("username",username);
        map.put("hobbies",hobbies);
        map.put("path",path);
        return map;
    }

    /**
     * 测试AOP
     * @param num1
     * @param num2
     * @return
     */
    @GetMapping("/testAOP/{num1}/{num2}")
    public int testAOP(@PathVariable("num1") int num1,
                       @PathVariable("num2") int num2) {
        for (int i = 0; i < num2; i++) {
            num1++;
        }
//        num1 = 1 / 0;
        return num1;
    }
}
