package com.shelly.coupons.dto;

import com.shelly.coupons.enums.UserType;

public class UsersDTO {
    private long id;
    private String name;
    private String password;
    private UserType userType;
    private String companyName;

    public UsersDTO() {
    }

    public UsersDTO(long id, String name, String password, UserType userType, String companyName) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userType = userType;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
