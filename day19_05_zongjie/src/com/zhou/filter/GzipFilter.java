package com.zhou.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * 周刘成   2019-12-6
 */
@WebFilter(filterName = "gzipFilter", urlPatterns = "/*",
        initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class GzipFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        MyResponse myResponse = new MyResponse(response);
        filterChain.doFilter(request, myResponse);

        //压缩前的数据
//        String message="kkkkkkkkkkkkkkkkk世界";
        String message = "kkkkkkkkkkkkkkkkk世界";
        byte[] b = message.getBytes();
        //判断客户端是否支持gzip
        if (request.getHeader("Accept-Encoding").contains("gzip")) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            GZIPOutputStream outputStream = new GZIPOutputStream(baos);
            outputStream.write(b);
            outputStream.close();
            //压缩后的数据
            b = baos.toByteArray();
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Encoding", "gzip");
            response.setContentLength(b.length);

            ServletOutputStream sos = response.getOutputStream();
            sos.write(b);
        }

    }

    @Override
    public void destroy() {

    }

    class MyResponse extends HttpServletResponseWrapper {

        private ByteArrayOutputStream baos = new ByteArrayOutputStream();
        private PrintWriter pw = null;

        public MyResponse(HttpServletResponse response) {
            super(response);
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new MyOutputStream(baos);
        }

        public byte[] getBytes() {
            try {
                if (pw != null) {
                    pw.close();
                }
                baos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return baos.toByteArray();
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            pw = new PrintWriter(new OutputStreamWriter(baos, "UTF-8"));
            return pw;
        }
    }

    class MyOutputStream extends ServletOutputStream {

        private ByteArrayOutputStream baos;

        public MyOutputStream(ByteArrayOutputStream baos) {
            this.baos = baos;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {

        }

        @Override
        public void write(int b) throws IOException {
            baos.write(b);
        }
    }
}
