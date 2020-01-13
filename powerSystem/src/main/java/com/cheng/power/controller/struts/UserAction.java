package com.cheng.power.controller.struts;

import com.cheng.power.controller.BaseAction;
import com.cheng.power.entity.User;
import com.cheng.power.service.UserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * 周刘成   2020-1-8
 */
@Controller
@Namespace("/")
public class UserAction extends BaseAction<User> {

//    private static final Logger logger = LoggerFactory.getLogger(UserAction.class);

    @Autowired
    private UserService userService;

    @Action(value = "/query", results = {
            @Result(name = "success", location = "system/test.jsp"),
            @Result(name = "error", location = "system/add.html")
    })
    public String query() {
        Iterable<User> list = userService.findAll();
//        logger.info("");
        return "success";
    }

}
