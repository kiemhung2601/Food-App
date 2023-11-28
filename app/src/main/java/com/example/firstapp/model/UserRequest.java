package com.example.firstapp.model;

public class UserRequest {
    private String username;
    private String password;
    private String userType;

    public UserRequest(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
}
