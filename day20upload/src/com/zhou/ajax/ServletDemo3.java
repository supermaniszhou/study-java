package com.zhou.ajax;

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
@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet {
    private List<Product> products = new ArrayList<Product>();

    @Override
    public void init() throws ServletException {
        products.add(new Product(1, "充气筒", 20));
        products.add(new Product(2, "金瓶梅", 10));
        products.add(new Product(3, "袜子", 10));
        products.add(new Product(4, "洗衣粉", 10));
        products.add(new Product(5, "肥皂", 7));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        request.setAttribute("products", products);
        request.getRequestDispatcher("/ajax/listProducts.jsp").forward(request, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
