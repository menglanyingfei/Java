package com.wtu.entity;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.13 15:40
 */
public class Item {
    private Integer id;
    private String name;
    private Double price;
    private Integer count;
    private String detail;

    public Item() {
    }

    public Item(Integer id, String name, Double price, Integer count, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.detail = detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
