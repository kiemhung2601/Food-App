package com.example.firstapp.model;

public class User {
    private int userId;
    private String username;
    private int customerId;
    private String fullName;
    private Boolean isPersonal;
    private int customerTypeId;
    private String customerTypeDisplay;

    public User(int userId, String username, int customerId, String fullName, Boolean isPersonal, int customerTypeId, String customerTypeDisplay) {
        this.userId = userId;
        this.username = username;
        this.customerId = customerId;
        this.fullName = fullName;
        this.isPersonal = isPersonal;
        this.customerTypeId = customerTypeId;
        this.customerTypeDisplay = customerTypeDisplay;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getPersonal() {
        return isPersonal;
    }

    public void setPersonal(Boolean personal) {
        isPersonal = personal;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeDisplay() {
        return customerTypeDisplay;
    }

    public void setCustomerTypeDisplay(String customerTypeDisplay) {
        this.customerTypeDisplay = customerTypeDisplay;
    }
}
