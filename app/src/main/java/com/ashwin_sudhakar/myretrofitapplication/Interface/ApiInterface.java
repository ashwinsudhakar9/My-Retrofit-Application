package com.ashwin_sudhakar.myretrofitapplication.Interface;

import com.ashwin_sudhakar.myretrofitapplication.Model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/posts")
    Call<List<DataModel>> getDataModels();
}
