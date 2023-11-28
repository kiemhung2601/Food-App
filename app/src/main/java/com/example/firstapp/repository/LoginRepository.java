package com.example.firstapp.repository;

import com.example.firstapp.api_services.ApiInterface;
import com.example.firstapp.api_services.ApiServices;
import com.example.firstapp.api_services.base_services.BaseRespone;
import com.example.firstapp.model.Product;
import com.example.firstapp.model.TestHome;
import com.example.firstapp.model.User;
import com.example.firstapp.model.UserRequest;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;

public class LoginRepository {
    public LoginRepository(){};
    ApiInterface apiServices = ApiServices.getApiServices();

    public Call<BaseRespone<List<TestHome>>> getProduct(){
        return apiServices.getProducts();
    }

    public Call<BaseRespone<User>> login(String username, String password){
        HashMap<String, Object> body = new HashMap<String, Object>();

        body.put("username", username);
        body.put("password", password);
        body.put("userType", "CUSTOMER");

        return apiServices.login(body);
    }
}
