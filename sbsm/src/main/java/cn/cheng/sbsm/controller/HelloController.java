package cn.cheng.sbsm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 周刘成   2020-1-13
 * 测试springboot 集成jsp 和thymeleaf
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/jsp")
    public ModelAndView jspIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        modelAndView.addObject("name", "jsp");
        return modelAndView;
    }

    @RequestMapping("/html")
    public ModelAndView htmlindex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/index");
        modelAndView.addObject("name", "html");
        return modelAndView;
    }
}
