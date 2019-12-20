package com.zhou.listener.demo4;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

/**
 * 周刘成   2019-12-19
 * 第一种方法：使用HttpSessionListener监听器实现
 */

//@WebListener
public class OnlineUserListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("新建session:" + httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //我的理解：在退出时session执行了销毁操作，所以在获取username时值为空
        HttpSession session = httpSessionEvent.getSession();
        ServletContext application = session.getServletContext();
        String username = (String) session.getAttribute("usrename");
        List onlineUser = (List) application.getAttribute("onlineUserList");
        onlineUser.remove(username);

    }
}
