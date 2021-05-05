package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ShiWei
 * @date 2021/4/10 - 15:33
 * <p>
 * 控制器类
 */
@Controller
@RequestMapping(path="/user")
public class HelloController {


    /**
     * 入门案例
     * /user/hello
     *
     * @return
     */
    @RequestMapping(path = "/hello") //path属性表示该方法的路径，index.jsp中超链接的href属性使用。
    public String sayHello() {
        System.out.println("hello StringMVC");
        return "success";
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(path="/testRequestMapping", params = {"username=heihei"}, headers = {"Accept"})
    public String testRequestMapping() {
        System.out.println("测试RequestMapping注解...");
        return "success";
    }
}
