package com.example.taboolahometest.data;

import androidx.fragment.app.Fragment;

import com.taboola.android.PublisherInfo;
import com.taboola.android.TaboolaWidget;

public class Taboola extends Fragment {

    private TaboolaWidget mMiddleTaboolaWidget;



    PublisherInfo publisherInfo = new PublisherInfo("sdk-tester");



    public Taboola(TaboolaWidget mMiddleTaboolaWidget) {
        this.mMiddleTaboolaWidget = mMiddleTaboolaWidget;
    }
}
