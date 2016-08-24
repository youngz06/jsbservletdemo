package com.zyoungBlog.beans;

/**
 * Created by youngz on 16-8-18.
 */
public class Product {
    private String code;
    private String name;
    private float price;

    public Product(String code, String name, float price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
