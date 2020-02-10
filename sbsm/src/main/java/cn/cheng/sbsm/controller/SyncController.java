package cn.cheng.sbsm.controller;

import cn.cheng.sbsm.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 周刘成   2020-2-10
 */
@RestController
@RequestMapping("/sync")
public class SyncController {

    @Autowired
    private SyncService service;

    @GetMapping(value = "/hello")
    public String hello() {
        service.sync();
        return "success";
    }
}
