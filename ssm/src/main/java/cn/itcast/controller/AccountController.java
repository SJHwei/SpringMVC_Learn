package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ShiWei
 * @date 2021/4/26 - 20:05
 * <p>
 * 账户web
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有账户。。。");
        //调用service方法
        //下面这个调用的是查询方法，有返回值，即可以存起来，也可以转发到页面上。
        //这儿我们存起来，存到model对象中
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        model.addAttribute("list", list);
        return "list";
    }

    /**
     * 保存
     *
     * @param account
     * @return
     */
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception {
        accountService.saveAccount(account);
        //可以跳转到list页面，但是如果不想要跳转到这个页面，你想去请求上面那个方法的话，那么久可以选择重定向或者转发，此处使用重定向
        response.sendRedirect(request.getContextPath() + "/account/findAll");
//        return "list";
    }
}
