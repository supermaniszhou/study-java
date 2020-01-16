package cn.cheng.sbsm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 周刘成   2020-1-16
 * SpringBoot处理异常方式一：自定义错误页面  错误页面在templates下 的error.html页面
 */
@Controller
public class ExceptionController extends BaseController {

    @RequestMapping("/show")
    public String showInfo() {
        String str = null;
        str.length();
        return "index";
    }

    @RequestMapping("/info")
    public ModelAndView info() {
        int a = 10 / 0;
        return new ModelAndView(VIEW_PATH + "user/listUser");
    }

    /**
     * 算术异常
     * java.lang.ArithmeticException
     * * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
     * * 参数Exception e:会将产生异常对象注入到方法中
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView arithmeticExceptionHandler(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error1");
        modelAndView.addObject("error", e.toString());
        return modelAndView;
    }

    /**
     * java.lang.NullPointerException
     * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
     * 参数Exception e:会将产生异常对象注入到方法中
     */
    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullPointerExceptionHandler(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("error", e.toString());
        mv.setViewName("error2");
        return mv;
    }
}
