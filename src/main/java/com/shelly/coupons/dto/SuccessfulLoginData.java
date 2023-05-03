package com.shelly.coupons.dto;

public class SuccessfulLoginData {

    private String token;

    public SuccessfulLoginData() {
    }

    public SuccessfulLoginData(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
