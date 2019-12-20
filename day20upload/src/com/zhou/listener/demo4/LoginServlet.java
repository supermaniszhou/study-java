package com.zhou.listener.demo4;

import com.sun.deploy.util.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 周刘成   2019-12-19
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String name = request.getParameter("username");

        //第一种方法使用httpSessionListener
        /*if (name != null && !name.equals("")) {
            session.setAttribute("username", name);
        }
        ServletContext application = session.getServletContext();
        List onlineUserList = (List) application.getAttribute("onlineUserList");
        if (onlineUserList == null) {
            onlineUserList = new ArrayList();
            application.setAttribute("onlineUserList", onlineUserList);
        }
        onlineUserList.add(name);*/

        // 把用户名放入在线列表     把我们自定义的OnlineUserBindingListener类实例化以后存到session里面去，只要这行代码一旦执行，那么就会触发OnlineUserBindingListener类里的valueBound(HttpSessionBindingEvent event)方法
        session.setAttribute("onlineUserBindingListener",new OnlineUserBindingListener(name));

        response.sendRedirect("result.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
