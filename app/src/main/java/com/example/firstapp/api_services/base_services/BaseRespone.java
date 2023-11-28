package com.example.firstapp.api_services.base_services;

public class BaseRespone<T> {
    private boolean success;
    private int statusCode;
    private String statusValue;
    private String executeDate;
    private T data;
    private String token;

    public BaseRespone(boolean success, int statusCode, String statusValue, String executeDate, T data, String token) {
        this.success = success;
        this.statusCode = statusCode;
        this.statusValue = statusValue;
        this.executeDate = executeDate;
        this.data = data;
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(String executeDate) {
        this.executeDate = executeDate;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
