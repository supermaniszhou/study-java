package com.zhou.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 周刘成   2019-12-20
 */
@WebServlet("/demo2")
public class ServletDemo2 extends HttpServlet {

    private List<String> usernames = Arrays.asList("zhangsan", "lisi");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean b = false;
        for (String s : usernames) {
            if (s.equals(username)) {
                b = true;
                break;
            }
        }
        resp.setContentType("text/html;charset=UTF-8");
        if (b) {
            resp.getWriter().write("<font color='red'>用户名不可用</font>");
        } else {
            resp.getWriter().write("<font color='green'>用户可用</font>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
