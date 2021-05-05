package cn.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ShiWei
 * @date 2021/4/23 - 18:17
 * <p>
 * 自定义拦截器
 * <p>
 * 有一个问题：当我实现HandlerInterceptor这个接口，竟然没有报错。一般实现接口，都会报错，你必须的实现它里面的方法。
 * 原因：该接口中是有方法的。这就是jdk1.8它对接口做了一个增强，以后接口当中允许你直接写这个方法，而且它实现了。
 * 也就是说：现在人家接口中定义方法并且都帮你把方法全部都实现过。所以如果你觉得不想再实现方法，那可以直接使用接口中默认的方法实现。
 * 如果你想去写新的实现，重写方法就可以了。
 * 该接口中有三个方法：preHandler(预处理，即方法之前走)，postHandle(后处理，即方法之后走)，afterCompletion(页面走完再走的)。
 */
public class MyInterceptor1 implements HandlerInterceptor {

    /**
     * 预处理，controller方法执行前
     * return true：放行，执行下一个拦截器，如果没有，执行controller中的方法；
     * return false：不放行，你看它的参数有request，response，可以利用这两个对象跳转到某某页面去，等于你后边controller方法没有执行，直接跳到某个页面，就可以做一些提示信息。
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1执行了...前111");
        //停止转发到新的页面
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        return true;
    }

    /**
     * 后处理方法，controller方法执行后，success.jsp执行之前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1执行了...后111");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
    }

    /**
     * success.jsp页面执行后，该方法会执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1执行了...最后111");
    }
}
