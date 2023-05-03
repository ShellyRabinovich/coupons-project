package com.shelly.coupons.dto;

import com.shelly.coupons.entities.User;
import com.shelly.coupons.enums.UserType;

public class CustomersDTO {
    private long userId;
    private String userName;
    private String password;

    private String address;
    private String fullName;
    private String phoneNumber;


    public CustomersDTO() {
    }

    public CustomersDTO(long userId, String userName, String password, String address, String fullName, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
