package com.shelly.coupons.dto;

import java.util.Date;

public class CustomersPurchasesDTO {
    private long id;
    private String couponName;
    private int price;
    private Date timestamp;
    private int amount;

    public CustomersPurchasesDTO() {
    }

    public CustomersPurchasesDTO(long id, String couponName, int price, Date timestamp, int amount) {
        this.id = id;
        this.couponName = couponName;
        this.price = price;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
