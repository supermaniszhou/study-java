package com.zhou.ajax;

import com.thoughtworks.xstream.XStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 周刘成   2019-12-20
 */
@WebServlet("/demo4")
public class ServletDemo4 extends HttpServlet {
    private List<Province> provinces = new ArrayList<Province>();

    @Override
    public void init() throws ServletException {
        Province sd = new Province(37, "山东省");
        Province hb = new Province(42, "湖北省");
        Province hn = new Province(41, "河南省");

        sd.getCities().add(new City(01, "济南市"));
        sd.getCities().add(new City(02, "青岛市"));
        sd.getCities().add(new City(03, "淄博市"));

        hb.getCities().add(new City(01, "武汉市"));
        hb.getCities().add(new City(02, "黄冈市"));
        hb.getCities().add(new City(03, "襄阳市"));

        hn.getCities().add(new City(01, "郑州市"));
        hn.getCities().add(new City(02, "开封市"));
        hn.getCities().add(new City(03, "洛阳市"));

        provinces.add(sd);
        provinces.add(hb);
        provinces.add(hn);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建XStream对象
        XStream stream = new XStream();
        //使用注解生成别名
        stream.autodetectAnnotations(true);
        stream.alias("provinces", List.class);
        String xml = stream.toXML(provinces);
        resp.setContentType("text/xml;charset=UTF-8");
        resp.getWriter().write(xml);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
