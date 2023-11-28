package com.example.firstapp.api_services;

import com.example.firstapp.api_services.base_services.BaseRespone;
import com.example.firstapp.model.Product;
import com.example.firstapp.model.TestHome;
import com.example.firstapp.model.User;
import com.example.firstapp.model.UserRequest;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("/api/v1/users/formEC")
    Call<BaseRespone<List<TestHome>>> getProducts();

    @POST("/api/v1/users/auth/login")
    Call<BaseRespone<User>> login(@Body HashMap<String, Object> body);

}
