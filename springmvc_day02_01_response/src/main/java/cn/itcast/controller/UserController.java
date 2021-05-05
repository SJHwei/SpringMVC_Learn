package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ShiWei
 * @date 2021/4/19 - 20:19
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回string
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString方法执行了...");
        //模拟从数据库中查询出User对象，然后把对象存起来，转发到页面上，在页面可以把值取出来
        User user = new User();
        user.setUsername("哈哈");
        user.setPassword("123");
        user.setAge(30);
        //model对象可以帮忙存数据
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 是void
     * 请求转发一次请求，不用编写项目的名称
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了...");

        //编写请求转发的程序
        //转发同时向往成功页面跳的话，该怎么写？

        //问题一：和之前不一样，之前直接写一个success字符串就行，直接帮忙跳转页面，现在为什么不行了？
        //答：其实自己手动调用转发的方法，它不会再帮你执行那个叫视图的解析器，如果不再执行这个解析器，它不会帮忙跳转这个目录下，去找jsp去了. (看springmvc.xml中的视图解析器对象配置)
        //所以需要自己提供完整的目录。
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        //问题二：当你转发完，它后面还有代码的话会继续执行，如果不想让其执行，可以加一个return的代码。
//        return;

        //重定向，重定向是两次请求
        //重定向的路径上需要加项目名称。使用request.getContextPath()得到项目名称。
        //注意：转发可以直接进入web-inf中啥啥的。重定向不能直接进入web-inf中
//        response.sendRedirect(request.getContextPath() + "/index.jsp");
//        return;

        //前面两种方式都是先跳到某个jsp，然后最终由tomcat服务器帮你生成html，最终帮你响应给你的用户。
        //还有这种情况，你可能直接发请求，控制器直接通过输出流来把数据直接响应给浏览器，如下面。
        //即两种方式：要么跳页面，要么直接响应。

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //直接会进行响应
        response.getWriter().print("你好");
        return;
    }

    /**
     * 返回ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //创建testModelAndView对象，该对象有两个常用的方法：addObject和setViewName。
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView方法执行了...");
        //模拟从数据库中查询出User对象，然后把对象存起来，转发到页面上，在页面可以把值取出来
        User user = new User();
        user.setUsername("哈哈");
        user.setPassword("123");
        user.setAge(30);

        //把user对象存储到mv对象中，也会把user对象存入到request对象
        mv.addObject("user", user);

        //跳转到哪个页面
        mv.setViewName("success");

        return mv;
    }

    /**
     * 使用关键字的方式进行转发和重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect方法执行了...");

        //请求的转发
//        return "forward:/WEB-INF/pages/success.jsp";

        //重定向
        //注意：重定向的路径上需要加项目名称。但是下面没有加，说明底层帮忙加上了。
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     * @return
     */
    @RequestMapping("/testAjax")
//    public void testAjax(@RequestBody String body) {
    public @ResponseBody User testAjax(User user) {
        //注意：后台就是服务器，页面上就是客户端

        //服务器端接收到请求了，拿到的是一个json的串(body)
        System.out.println("testAjax方法执行了...");
//        System.out.println(body);

        //把json串封装到javabean的对象当中，之后再把json的串响应回去，客户端拿到这个结果可以做一些局部的刷新和处理
        //这个是非常好做的，因为springmvc的框架已经做好了，你发过来的是json的一串字符串，我能拿到你发的串的key值和javabean中的属性名是相同的话，
        //那它是可以直接帮你把这个串封装到对象当中。也就是说，框架已经帮你做好了。
        //但是它在做这个转换的时候，就是把key封装到对象的时候，需要用到一组额外的一些jar包。具体jar包见资料。
        //导入这组jar包的坐标时，复制粘贴资料即可。
        //此时就不能是string body了，而是User user。

        //客户端发送ajax请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        //做响应，springmvc的框架已经把事全做好了，你只需要把该方法的返回值类型改为user即可。
        //但是如果这么写，你返回的是一个对象，但是我给咱们前端还是一个json的数据，那怎么办呢？
        //办法：需要将返回值类型转为json，这个不需要自己转，加一个注解即可：@ResponseBody
        return user;

    }
}
