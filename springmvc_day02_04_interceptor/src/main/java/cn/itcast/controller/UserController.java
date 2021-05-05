package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ShiWei
 * @date 2021/4/23 - 9:02
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testInterceptor")
    public String testException() {
        System.out.println("testInterceptor执行了...");
        return "success";
    }
}
