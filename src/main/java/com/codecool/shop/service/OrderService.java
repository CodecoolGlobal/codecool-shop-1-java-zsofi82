package com.codecool.shop.service;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.SuperHeroDao;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.OrderItem;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.SuperHero;

import java.util.List;

public class OrderService {
    private final OrderDao orderDao;
    private final ProductCategoryDao productCategoryDao;
    private final SuperHeroDao superHeroDao;

    public OrderService(OrderDao orderDao, ProductCategoryDao productCategoryDao, SuperHeroDao superHeroDao) {
        this.orderDao = orderDao;
        this.productCategoryDao = productCategoryDao;
        this.superHeroDao = superHeroDao;
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
        SuperHero hero = superHeroDao.find(item.getHeroID());
        order.setProductQuantity(category, hero, item.getQuantity());
    }
}
