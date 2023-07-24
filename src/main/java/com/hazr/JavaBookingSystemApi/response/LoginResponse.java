package com.hazr.JavaBookingSystemApi.response;

import com.hazr.JavaBookingSystemApi.model.UserType;

public class LoginResponse {

    private UserType userType;
    private long userId;

    public LoginResponse(UserType userType, long userId) {
        this.userType = userType;
        this.userId = userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
