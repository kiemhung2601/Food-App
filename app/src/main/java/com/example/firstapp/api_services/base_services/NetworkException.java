package com.example.firstapp.api_services.base_services;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import retrofit2.HttpException;
import retrofit2.Response;

public class NetworkException extends Exception {
    private int statusCode;
    private String statusText;
    private @Nullable Object data;

    private NetworkException(String statusText, int statusCode, @Nullable Object data) {
        super(statusText);
        this.statusText = statusText;
        this.statusCode = statusCode;
        this.data = data;
    }

    public static final NetworkException unauthorizedException(){
        return new NetworkException("Phiên đăng nhập đã hết hạn.\\nVui lòng đăng nhập lại!", 401, null);
    };

    public static final NetworkException maintenanceException(){
        return new NetworkException("Chức năng đang bảo trì.\\nVui lòng thử lại sau.", 502, null);
    };

    public static final NetworkException connectionException(){
        return new NetworkException("Rất tiếc, có lỗi xảy ra.\nVui lòng thử lại sau.", 599, null);
    };

    public static final NetworkException otherException(){
        return new NetworkException("Opps,\\nRất tiếc, có lỗi xảy ra. Vui lòng thử lại sau", 408, null);
    };

    public static final NetworkException apiExeption(String statusText, int statusCode, @Nullable Object data){
        return new NetworkException(statusText, statusCode, data);
    };

    public static <T> T converJson(Response<BaseRespone<T>> response) throws NetworkException {
        //Error network
        if(response.body() == null){
            ApiError errorBody = new Gson().fromJson(response.errorBody().charStream(), ApiError.class);
            switch (errorBody.getStatus()){
                case 401:
                    throw NetworkException.unauthorizedException();
                case 502:
                    throw NetworkException.maintenanceException();
                case 599:
                    throw NetworkException.connectionException();
                case 408:
                    throw NetworkException.otherException();
                default:
                    throw NetworkException.apiExeption(errorBody.getMessage(), errorBody.getStatus(), null);
            }
        }

        //Retrun data
        if(response.body().isSuccess()){
            return response.body().getData();
        }

        //Error api
        if (!response.body().isSuccess()) {
            if (response.body().getStatusCode() == 408) {
                throw NetworkException.unauthorizedException();
            }
            throw NetworkException.apiExeption(response.body().getStatusValue(), response.body().getStatusCode(), response.body());
        }
        return response.body().getData();
    };

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
}
