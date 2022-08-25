package com.codecool.shop.service;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.OrderItem;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

public class OrderService {
    private final OrderDao orderDao;
    private final ProductCategoryDao productCategoryDao;

    public OrderService(OrderDao orderDao, ProductCategoryDao productCategoryDao) {
        this.orderDao = orderDao;
        this.productCategoryDao = productCategoryDao;
    }

    public int addNewOrder() {
        Order order = new Order();
        orderDao.add(order);
        return order.getId();
    }

    public List<Order> getAllOrders() {
        return orderDao.getAll();
    }

    public void updateOrder(int orderId, OrderItem item) {
        Order order = orderDao.find(orderId);
        ProductCategory category = productCategoryDao.find(item.getProductID());
        order.setProductQuantity(category, item.getQuantity());
    }
}
