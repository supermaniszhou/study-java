package cn.cheng.sbsm.controller;

import cn.cheng.sbsm.pojo.User;
import cn.cheng.sbsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
    public ModelAndView doSave(@Validated User user, HttpServletRequest request) {
        user.setId((int) (Math.random() * 10000 + 1));
        user.setRole("admin");
        try {
            userService.insertUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ModelAndView("forward:toListPage");
    }

    @RequestMapping(value = "/toListPage")
    public ModelAndView toListPage() {
        ModelAndView modelAndView = new ModelAndView(VIEW_PATH + "user/listUser");
        List<User> list = userService.selectAllUser();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping(value = "/toEdit")
    public ModelAndView toEdit(Integer id) {
        ModelAndView modelAndView = new ModelAndView(VIEW_PATH + "user/editUser");
        User user = null;
        try {
            user = userService.selectUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/doEdit")
    public ModelAndView doEdit(User user) {
        //在modelAndView中使用redirect重定向，使用forward完成转发
        ModelAndView modelAndView = new ModelAndView("forward:toListPage");
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
