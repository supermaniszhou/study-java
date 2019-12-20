package com.zhou.listener.demo4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 周刘成   2019-12-19
 */
@WebServlet("/loginOut")
public class LoginOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        String username = (String) session.getAttribute("username");
        session.invalidate();
//        ServletContext application = session.getServletContext();
//        List onlineUserList = (List) application.getAttribute("onlineUserList");
//        onlineUserList.remove(username);
        resp.sendRedirect("result.jsp");
    }
}
