package com.example.taboolahometest.data;

import com.example.taboolahometest.pojo.ItemAPI;
import com.example.taboolahometest.pojo.ItemModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ItemClient
        {

            // We will make our builder here to use retrofit, using singleton design pattern.

            private static final String BASE_URL = "https://s3-us-west-2.amazonaws.com";
            private ItemAPI itemAPI;
            private static ItemClient INSTANCE;


            public ItemClient(){
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                itemAPI = retrofit.create(ItemAPI.class);
        }


        public static ItemClient getInstance(){
                if(null == INSTANCE){
                    INSTANCE = new ItemClient();
                }

                return INSTANCE;
        }


        public Call<List<ItemModel>> getItems(){
                return itemAPI.getItems();
        }


        }
