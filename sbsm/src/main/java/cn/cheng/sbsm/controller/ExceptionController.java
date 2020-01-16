package cn.cheng.sbsm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 周刘成   2020-1-16
 * SpringBoot处理异常方式一：自定义错误页面  错误页面在templates下 的error.html页面
 */
@RestController
public class ExceptionController extends BaseController {

    @RequestMapping("/show")
    public ModelAndView showInfo() {
        String str = null;
        str.length();
        return new ModelAndView(VIEW_PATH + "user/listUser");
    }

    @RequestMapping("/info")
    public ModelAndView info() {
        int a = 10 / 0;
        return new ModelAndView(VIEW_PATH + "user/listUser");
    }


}
