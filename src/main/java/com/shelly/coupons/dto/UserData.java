package com.shelly.coupons.dto;

import com.shelly.coupons.enums.UserType;

public class UserData {
    private Long id;
    private Long companyId;
    private UserType userType;

    public UserData(Long id, Long companyId, UserType userType) {
        this.id = id;
        this.companyId = companyId;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
