package com.example.test0319;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private ApiInterface apiService;
    String url = "http://yuriy.me/rakuten-rewards/";
    public ApiInterface getApiService() {
        // baseUrl: define API base URL, the common part of the URL
        // addConverterFactory: define transfer to which data type
        retrofit2.Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiInterface.class);
        return apiService;
    }
}