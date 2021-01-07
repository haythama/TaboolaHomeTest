package com.example.taboolahometest.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taboolahometest.data.ItemClient;
import com.example.taboolahometest.pojo.ItemModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemViewModel extends ViewModel {

    MutableLiveData<List<ItemModel>> itemsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> items = new MutableLiveData<>();


    public void getItems(){

        ItemClient.getInstance().getItems().enqueue(new Callback<List<ItemModel>>() {
            @Override
            public void onResponse(Call<List<ItemModel>> call, Response<List<ItemModel>> response) {
                itemsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ItemModel>> call, Throwable t) {
            items.setValue("error");
            }
        });

    }
}
