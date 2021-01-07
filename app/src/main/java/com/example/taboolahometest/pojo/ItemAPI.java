package com.example.taboolahometest.pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ItemAPI {

    @GET("/taboola-mobile-sdk/public/home_assignment/data.json")
    public Call<List<ItemModel>> getItems();



}
