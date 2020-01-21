package cn.cheng.sbsm.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理
 * 周刘成   2020-1-16
 * 通过实现HandlerExceptionResolver接口做全局异常处理
 */
@Configuration
public class GlobalExceptionPlugin implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof ArithmeticException) {
            modelAndView.setViewName("error1");
        }
        if (e instanceof NullPointerException) {
            modelAndView.setViewName("error2");
        }
        if(e instanceof Exception){
            modelAndView.addObject("error", e.toString());
        }
        return modelAndView;
    }
}
