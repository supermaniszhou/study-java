package cn.cheng.sbsm.controller;

import cn.cheng.sbsm.pojo.User;
import cn.cheng.sbsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


/**
 * 周刘成   2020-1-14
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toAddUser")
    public ModelAndView toAddUser(@ModelAttribute("msg") User user) {
        ModelAndView modelAndView = new ModelAndView(VIEW_PATH + "user/addUser");
        return modelAndView;
    }

    @PostMapping(value = "/doSave")
    public String doSave(@ModelAttribute("msg") @Valid User user, BindingResult result) {
        user.setId((int) (Math.random() * 10000 + 1));
        user.setRole("admin");
        try {
            if (!result.hasErrors()) {
                userService.insertUser(user);
//                return "forward:toListPage";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "views/user/addUser";
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
            User u=new User();
            u.setId(id);
            user = userService.selectUserById(u);
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
