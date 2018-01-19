package com.wtu.servlet;

import com.wtu.entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by menglanyingfei on 2018/1/13.
 */
@WebServlet(name = "FindAllItemsServlet", value = "/FindAllItemsServlet")
public class FindAllItemsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 模拟数据
        List<Item> itemList = new ArrayList<>();
        Item item1 = new Item(1, "小米", 1500.0, 10, "非常好用");
        Item item2 = new Item(2, "华为", 1800.0, 10, "非常好用");
        Item item3 = new Item(3, "苹果手机", 5500.0, 10, "非常好用");
        Item item4 = new Item(4, "OPPO", 1500.0, 10, "非常好用");
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);

        request.setAttribute("itemsList", itemList);
        request.getRequestDispatcher("/jstl/showItems.jsp").forward(request, response);
    }
}











