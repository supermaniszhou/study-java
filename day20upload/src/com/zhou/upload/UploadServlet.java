package com.zhou.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 周刘成   2019-12-18
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        boolean flag = ServletFileUpload.isMultipartContent(req);
        if (!flag) {
            throw new RuntimeException("");
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File("d:"));//临时文件的存储目录

        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        fileUpload.setFileSizeMax(3 * 1024 * 1024);
        fileUpload.setSizeMax(10 * 1024 * 1024);

        List<FileItem> list = null;
        try {
            list = fileUpload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
            throw new RuntimeException("解析请求失败");
        }

        //遍历处理请求内容是文本还是附件
        list.stream().forEach(item -> {
            if (item.isFormField()) {
                processCommon(item);
            } else {
                processUploadWrite(item);
            }
        });
    }

    public void processCommon(FileItem fileItem) {
        String fieldName = fileItem.getFieldName();
        String fieldValue = "";
        try {
            fieldValue = fileItem.getString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(fieldName + "=" + fieldValue);

    }

    public void processUploadWrite(FileItem fileItem) {
        String fileName = fileItem.getName();
        if (fileName != null && !fileName.equals("")) {
            //限制上传文件的类型
            System.out.println(fileItem.getContentType());
            try {
                String realpath = getServletContext().getRealPath("/WEB-INF/files");
                String childPath = getChildDirect(realpath);
                File f = new File(realpath.concat(childPath), fileName);
                fileItem.write(f);
                fileItem.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //使用io流上传文件
    public void processUpload(FileItem fileItem) {
        String fileName = fileItem.getName();
        if (fileName != null && !fileName.equals("")) {
            //限制上传文件的类型
            System.out.println(fileItem.getContentType());
            InputStream in = null;
            FileOutputStream fos = null;
            try {
                in = fileItem.getInputStream();
                String realpath = getServletContext().getRealPath("/WEB-INF/files");
                String childPath = getChildDirect(realpath);
                File f = new File(realpath.concat(childPath), fileName);
                fos = new FileOutputStream(f);
                byte[] b = new byte[1024];
                int len = 0;
                while ((len = in.read(b)) != -1) {
                    fos.write(b);
                }
                fileItem.delete();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fos) {
                        fos.close();
                    }
                    if (null != in) {
                        in.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getChildDirect(String realpath) {
        LocalDate l = LocalDate.now();
        String path = File.separator + l.getYear() + File.separator + l.getMonthValue() + File.separator + l.getDayOfMonth();
        String save = realpath.concat(path);
        File file = new File(save);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }
}
