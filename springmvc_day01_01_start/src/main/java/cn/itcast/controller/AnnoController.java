package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author ShiWei
 * @date 2021/4/14 - 21:30
 * <p>
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value={"msg"}) //把msg=花花存入到session域对中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println("执行了...");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取到请求体的内容
     *
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行了...");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable
     *
     * @return
     */
    @RequestMapping(value = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println("执行了...");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     * @param header
     * @return
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value="accept") String header) {
        System.out.println("执行了...");
        System.out.println(header);
        return "success";
    }

    /**
     * 获取Cookie的值
     * @return
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("执行了...");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * SessionAttributes的注解
     * @return
     */
    @RequestMapping(value = "/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes...");
        //底层会存储到request域对象中，当这个存完会跳转到success.jsp，现在就可以在success.jsp页面取值
        model.addAttribute("msg", "花花");
        return "success";
    }

    /**
     * 获取值
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes...");
        //底层会存储到request域对象中，当这个存完会跳转到success.jsp，现在就可以在success.jsp页面取值
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     * @param status
     * @return
     */
    @RequestMapping(value = "/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("getSessionAttributes...");
        System.out.println("getSessionAttributes...");
        status.setComplete();
        return "success";
    }
}
