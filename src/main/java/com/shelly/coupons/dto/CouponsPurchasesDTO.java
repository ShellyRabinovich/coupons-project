package com.shelly.coupons.dto;

import java.util.Date;

public class CouponsPurchasesDTO {
    private long id;
    private String couponName;
    private int price;
    private Date timestamp;
    private int amount;
    private String fullName;
    private String address;
    private String phoneNumber;

    public CouponsPurchasesDTO() {
    }

    public CouponsPurchasesDTO(long id, String couponName, int price, Date timestamp, int amount, String fullName, String address, String phoneNumber) {
        this.id = id;
        this.couponName = couponName;
        this.price = price;
        this.timestamp = timestamp;
        this.amount = amount;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


