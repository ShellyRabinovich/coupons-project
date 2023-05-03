package com.shelly.coupons.dto;

import java.util.Date;

public class PurchasesDTO {
        private long id;
        private String couponName;
        private String customerName;
        private int amount;
        private Date timestamp;

        public PurchasesDTO() {
        }

    public PurchasesDTO(long id, String couponName, String customerName, int amount, Date timestamp) {
        this.id = id;
        this.couponName = couponName;
        this.customerName = customerName;
        this.amount = amount;
        this.timestamp = timestamp;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}



