package com.zhou.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 周刘成   2019-12-5
 */
@WebServlet("/demo1")
public class ServletDemo1 extends HttpServlet {

    public ServletDemo1() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        //将用户输入的内容保存到request中
        request.setAttribute("title", title);
        request.setAttribute("content", content);
        //用RequestDispatcher对象请求转发至index.jsp页面
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
