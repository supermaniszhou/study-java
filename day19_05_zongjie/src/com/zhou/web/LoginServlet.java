package com.zhou.web;

import com.zhou.po.User;
import com.zhou.service.UserService;
import com.zhou.service.UserServiceImpl;
import com.zhou.util.BeanFactoryUtil;
import com.zhou.util.SecutityUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 周刘成   2019-12-5
 */
public class LoginServlet extends HttpServlet {

//    private UserService userService = BeanFactoryUtil.getBean(true, UserServiceImpl.class);
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String h = SecutityUtil.Md5(password);
        User user = userService.findUser(username, h);
        if (null != user) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            String remember = req.getParameter("remember");
            if (remember != null) {
                Cookie cookie = new Cookie("loginInfo", SecutityUtil.encode(username) + "_" + SecutityUtil.Md5(password));
                cookie.setMaxAge(Integer.MAX_VALUE);
                cookie.setPath(req.getContextPath());
                resp.addCookie(cookie);
            }
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login.jsp");
        }
    }
}
