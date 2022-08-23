package com.codecool.shop.dao;

import com.codecool.shop.model.SuperPower;

import java.util.List;

public interface SuperPowerDao {
    void add(SuperPower superpower);

    SuperPower find(int id);

    void remove(int id);

    List<SuperPower> getAll();
}
