package com.incekara.redis_cache.dto;

import com.incekara.redis_cache.model.User;


public class CreateUserDto {
    private String userName;
    private String password;

    public CreateUserDto() {
    }
    public CreateUserDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
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


}
