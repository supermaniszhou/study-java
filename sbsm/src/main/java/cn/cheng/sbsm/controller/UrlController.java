package cn.cheng.sbsm.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 周刘成   2020-1-14
 */
@RestController
public class UrlController {

    @RequestMapping("/{page}")
    public String showInfo(@PathVariable String page, Integer id, String name){
        System.out.println(id+"--"+name);
        return page;
    }
    @RequestMapping("/{page}/{id}/{path}")
    public String showInfo2(@PathVariable String page,@PathVariable Integer id,@PathVariable String path, String name){
        System.out.println(id+"--"+name);
        return page;
    }
}
