package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoMem implements OrderDao {
    List<Order> data = new ArrayList<>();
    private static OrderDaoMem instance = null;

    private OrderDaoMem() {
    }

    public static OrderDaoMem getInstance() {
        if (instance == null) {
            instance = new OrderDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Order order) {
        order.setId(data.size() + 1);
        order.setName(String.format("Order #%d", order.getId()));
        data.add(order);
    }

    @Override
    public Order find(int id) {
        return data.stream()
            .filter(order -> order.getId() == id)
            .findFirst()
            .orElseThrow();
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Order> getAll() {
        return List.copyOf(data);
    }
}
