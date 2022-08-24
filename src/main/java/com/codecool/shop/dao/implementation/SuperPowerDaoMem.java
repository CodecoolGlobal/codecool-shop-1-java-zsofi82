package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SuperPowerDao;
import com.codecool.shop.model.SuperPower;

import java.util.ArrayList;
import java.util.List;

public class SuperPowerDaoMem implements SuperPowerDao {
    private List<SuperPower> data = new ArrayList<>();
    private static SuperPowerDaoMem instance = null;

    private SuperPowerDaoMem() {
    }

    public static SuperPowerDao getInstance() {
        if (instance == null) {
            instance = new SuperPowerDaoMem();
        }
        return instance;
    }

    @Override
    public void add(SuperPower superpower) {
        superpower.setId(data.size() + 1);
        data.add(superpower);
    }

    @Override
    public SuperPower find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<SuperPower> getAll() {
        return data;
    }
}
