package com.shelly.coupons.dto;

import java.util.Date;

public class LimitedInfoCouponDTO {
    private String name;
    private int price;
    private String description;
    private Date endDate;
    private long id;

    public LimitedInfoCouponDTO() {
    }

    public LimitedInfoCouponDTO(String name, int price, String description, Date endDate, long id) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.endDate = endDate;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
