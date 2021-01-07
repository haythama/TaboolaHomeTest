package com.example.taboolahometest.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.taboolahometest.R;
import com.example.taboolahometest.pojo.ItemModel;
import com.taboola.android.PublisherInfo;
import com.taboola.android.Taboola;
import com.taboola.android.TaboolaWidget;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ItemViewModel itemViewModel;

    // Taboola adding
    private TaboolaWidget taboolaWidget;

    PublisherInfo publisherInfo = new PublisherInfo("sdk-tester");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        itemViewModel.getItems();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        final ItemsAdapter adapter = new ItemsAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        // Taboola
//        taboolaWidget = new TaboolaWidget(this);
//        taboolaWidget.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT));



        itemViewModel.itemsMutableLiveData.observe(this, new Observer<List<ItemModel>>() {
            @Override
            public void onChanged(List<ItemModel> itemModels) {
                adapter.setList(itemModels);
            }
        });

    }
}