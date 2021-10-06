package com.ashwin_sudhakar.myretrofitapplication.Helpers;

import com.ashwin_sudhakar.myretrofitapplication.Interface.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static String BASE_URL ="https://jsonplaceholder.typicode.com";

    private static Retrofit retrofit = null;

    public static ApiInterface getApiClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }
}

