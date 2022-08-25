package com.codecool.shop.model;

import com.google.gson.annotations.Expose;

import java.util.Map;

public class OrderItem {
    @Expose
    private int productID;
    @Expose
    private int quantity;
    @Expose
    private int heroID;
    public OrderItem(int productID, int heroID) {
        this.productID = productID;
        this.heroID = heroID;
    }

    public OrderItem(int productID, int heroID, int quantity) {
        this.productID = productID;
        this.heroID = heroID;
        this.quantity = quantity;
    }

    public OrderItem() {

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getHeroID() {
        return heroID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (getProductID() != orderItem.getProductID()) return false;
        return getHeroID() == orderItem.getHeroID();
    }

    @Override
    public int hashCode() {
        int result = getProductID();
        result = 31 * result + getHeroID();
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
            "productID=" + productID +
            ", quantity=" + quantity +
            ", heroID=" + heroID +
            '}';
    }
}
