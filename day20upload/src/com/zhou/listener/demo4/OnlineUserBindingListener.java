package com.zhou.listener.demo4;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 周刘成   2019-12-19
 */
public class OnlineUserBindingListener implements HttpSessionBindingListener {

    private String username;

    public OnlineUserBindingListener(String username) {
        this.username = username;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        ServletContext application = session.getServletContext();
        List onlineUserList = (List) application.getAttribute("onlineUserList");
        if (onlineUserList == null) {
            onlineUserList = new ArrayList();
            application.setAttribute("onlineUserList", onlineUserList);
        }
        onlineUserList.add(this.username);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        ServletContext application = session.getServletContext();
        List online = (List) application.getAttribute("onlineUserList");
        online.remove(this.username);
    }
}
