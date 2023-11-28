package com.example.firstapp.api_services;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServices {
    private static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new CustomerInterceptor())
            .build();
    private static String baseUrl = "https://api.com";
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(baseUrl).client(client).addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static ApiInterface apiServices = retrofit.create(ApiInterface.class);

    public static ApiInterface getApiServices(){
        return apiServices;
    }
}
