package com.zhou.listener.demo5;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 周刘成   2019-12-19
 */
@WebListener
public class UserRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        //5秒执行一次
//        new Timer(5 * 1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("应该掉线了");
//            }
//        }).start();
        System.out.println("request 销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        HttpSession session = request.getSession();
        String sessionid = session.getId();
        String page = request.getRequestURI();
        String user = (String) session.getAttribute("user");
        System.out.println("session id:" + sessionid);
        System.out.println("view page url:" + page);
        System.out.println("view page user:" + user);
    }
}
