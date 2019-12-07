package com.zhou.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 周刘成   2019-12-5
 *
 * 全局编码设置过滤器
 */
public class SetEncodingFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String encoding = filterConfig.getInitParameter("encoding");
        if (encoding == null) {
            encoding = "UTF-8";
        }
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=" + encoding);
        MyservletRequest myservletRequest = new MyservletRequest(request);
        filterChain.doFilter(myservletRequest, response);
    }

    @Override
    public void destroy() {

    }

    class MyservletRequest extends HttpServletRequestWrapper {
        public MyservletRequest(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            if (value == null) {
                return null;
            }
            if ("get".equalsIgnoreCase(super.getMethod())) {
                try {
                    byte[] b = value.getBytes();
                    value = new String(b, super.getCharacterEncoding());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return value;
        }
    }
}


