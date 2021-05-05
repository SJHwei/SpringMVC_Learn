package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SysexMessage;

/**
 * @author ShiWei
 * @date 2021/4/23 - 9:23
 *
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理异常业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取到异常对象
        SysException ex = null;
        if (e instanceof SysException) {
            ex = (SysException)e;
        } else {
            ex = new SysException("系统正在维护...");
        }
        //创建ModelAndView对象，该对象可以帮忙跳转到某某某页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
