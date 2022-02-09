package com.wfr.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    @GetMapping("/atwfr")
    public String testView(Model model){
        model.addAttribute("msg","古古666");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
