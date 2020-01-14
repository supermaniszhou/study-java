package cn.cheng.sbsm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 周刘成   2020-1-13
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
