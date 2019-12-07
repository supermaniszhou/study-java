package com.zhou.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.EndDocument;
import java.io.IOException;

/**
 * 周刘成   2019-12-6
 * 敏感词拦截
 */
public class DirtyWordFilter implements Filter {
    protected String[] words;
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        words = new String[]{"糟糕", "混蛋", "畜生", "搞基", "禽兽"};
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            MyDirtyWordFilter wordFilter = new MyDirtyWordFilter(request);
            filterChain.doFilter(wordFilter, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {

    }

    public String filter(String message) {
        try {
            if (words.length > 0) {
                for (int i = 0; i < words.length; i++) {
                    if (message.indexOf(words[i]) != -1) {
                        message = message.replaceAll(words[i], "**");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    class MyDirtyWordFilter extends HttpServletRequestWrapper {
        public MyDirtyWordFilter(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            return filter(value);
        }

//        @Override
//        public String[] getParameterValues(String name) {
//            String[] values = super.getParameterValues(name);
//            for (int i = 0; i < values.length; i++) {
//                values[i] = filter(values[i]);
//            }
//            return values;
//        }
    }

}


