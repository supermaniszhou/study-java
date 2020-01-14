package cn.cheng.sbsm.controller;

import cn.cheng.sbsm.pojo.User;
import cn.cheng.sbsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * 周刘成   2020-1-14
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toAddUser")
    public ModelAndView toAddUser() {
        ModelAndView modelAndView = new ModelAndView(VIEW_PATH + "user/addUser");
        return modelAndView;
    }

    @PostMapping(value = "/doSave")
    public Map<String, Object> doSave(User user, HttpServletRequest request) {
        user.setId(1);
        user.setRole("admin");
        userService.insertUser(user);
        return responseTo("0", "success");
    }
}
