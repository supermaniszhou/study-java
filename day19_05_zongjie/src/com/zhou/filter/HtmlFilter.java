package com.zhou.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 周刘成   2019-12-6
 */
public class HtmlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HtmlRequest request1=new HtmlRequest(request);
        filterChain.doFilter(request1, response);
    }

    @Override
    public void destroy() {

    }

    class HtmlRequest extends HttpServletRequestWrapper {
        public HtmlRequest(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            if (null != value) {
                value = filter(value);
            }
            return value;
        }

        public String filter(String message) {
            char[] chars = new char[message.length()];
            message.getChars(0, message.length(), chars, 0);
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < chars.length; i++) {

                switch (chars[i]) {
                    case '<':
                        result.append("&lt;");
                        break;
                    case '>':
                        result.append("&gt;");
                        break;
                    case '&':
                        result.append("&amp;");
                        break;
                    case '"':
                        result.append("&quot;");
                        break;
                    default:
                        result.append(chars[i]);
                }
            }
            return result.toString();
        }
    }
}
