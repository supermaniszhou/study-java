package com.zhou.filter;

import com.zhou.po.User;
import com.zhou.service.UserService;
import com.zhou.service.UserServiceImpl;
import com.zhou.util.BeanFactoryUtil;
import com.zhou.util.SecutityUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 周刘成   2019-12-5
 * 登录过滤器
 */
public class LoginFilter implements Filter {

    private UserService service = new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String value = "";
        if (null == user) {

            Cookie[] cookie = request.getCookies();
            for (int i = 0; i < cookie.length; i++) {
                Cookie c = cookie[i];
                if (("loginInfo").equals(c.getName())) {
                    value = c.getValue();
                    break;
                }
            }
            if (!"".equals(value)) {
                String[] arr = value.split("_");
                User u = service.findUser(SecutityUtil.decode(arr[0]), arr[1]);
                if (null != u) {
                    session.setAttribute("user", u);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
