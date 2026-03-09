package com.portfolio.automation.models.ui;

public class UiExpectedProduct {

    private String product;
    private int price;
    private int qty;
    private int total;


    public UiExpectedProduct(String product, int price, int qty, int total) {
        this.product = product;
        this.price = price;
        this.qty = qty;
        this.total = total;
    }

    public String getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public int getTotal() {
        return total;
    }
}
