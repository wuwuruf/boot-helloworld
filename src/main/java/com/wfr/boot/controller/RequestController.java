package com.wfr.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goto_(HttpServletRequest request) {
        request.setAttribute("msg", "哈哈");
        return "forward:/success"; // 请求转发
    }

    // RequestAttribute获取请求域参数
    // **注意:请求域中的参数和请求参数是不同的概念，不要混淆
    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> test01(@RequestParam("username") String username,
                                      @RequestParam("age") Integer age,
                                      @RequestAttribute("msg") String msg,
                                      HttpServletRequest request) {
        String msg1 = (String) request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("age", age);
        map.put("msg", msg);
        map.put("msg1", msg1);
        return map;
    }
}
