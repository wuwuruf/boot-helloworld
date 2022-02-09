package com.wfr.boot.controller;

import com.wfr.boot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class IndexController {

    /**
     * 去登录页
     *
     * @return
     */
    @GetMapping({"/login", "/haha"})
    public String toLogin() {
        return "login";
    }

    /**
     * 提交表单登录
     *
     * @return
     */
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        String userName = user.getUserName();
        String password = user.getPassword();
        if ("gugu".equals(userName) && "123456".equals(password)) {
            session.setAttribute("loginUser", user);
            // template中的页面要通过请求处理，由模板引擎处理访问，不能通过浏览器直接访问，直接访问只能访问静态文件夹下的
            return "redirect:/main"; // 请求重定向到/main，防止表单重复提交
            // 这里估计视图解析自动在/main前面加上了项目根路径
        } else {
            model.addAttribute("msg", "密码错误，重新登陆");
            return "login";
        }
    }

    /**
     * 去main页面，这是为了防止表单重复提交
     *
     * @return
     */
    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

    /**
     * MultipartFile自动封装传过来的文件
     *
     * @param username
     * @param picture
     * @param photos
     * @return
     */
    @ResponseBody
    @PostMapping("/upload")
    public String fromUpload(@RequestParam("username") String username,
                             @RequestPart("picture") MultipartFile picture,
                             @RequestPart("photos") MultipartFile[] photos) throws IOException {
        if (!picture.isEmpty()) {
            String originalFilename = picture.getOriginalFilename();
            picture.transferTo(new File("D://小目标/" + originalFilename));
        }
        if (photos.length > 0) {
            for (MultipartFile multipartFile : photos) {
                String originalFilename = multipartFile.getOriginalFilename();
                multipartFile.transferTo(new File(("D://小目标/" + originalFilename)));
            }
        }

        return "username=" + username + ",photo大小:" + picture.getSize() + ",数组长度:" + photos.length;
    }
}
