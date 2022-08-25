package com.codecool.shop.controller;

import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.SuperHeroDaoMem;
import com.codecool.shop.model.OrderItem;
import com.codecool.shop.service.OrderService;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Collectors;

@WebServlet(name = "OrderController", value = "/api/order")
public class OrderController extends HttpServlet {
    private static final String ORDER_ATTRIBUTE_NAME = "order";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService service = new OrderService(
            OrderDaoMem.getInstance(),
            ProductCategoryDaoMem.getInstance(),
            SuperHeroDaoMem.getInstance()
        );
        HttpSession currentSession = request.getSession();
        int currentOrderId;

        if (currentSession.isNew()) {
            currentOrderId = service.addNewOrder();
            currentSession.setAttribute(ORDER_ATTRIBUTE_NAME, currentOrderId);
        } else {
            currentOrderId = (int)currentSession.getAttribute(ORDER_ATTRIBUTE_NAME);
        }

        OrderItem updatedItem = new Gson().fromJson(
            request.getReader(),
            OrderItem.class
        );

        service.updateOrder(currentOrderId, updatedItem);
        service.getAllOrders().forEach(order -> System.out.println(order.toString()));
        response.setStatus(200);
    }
}
