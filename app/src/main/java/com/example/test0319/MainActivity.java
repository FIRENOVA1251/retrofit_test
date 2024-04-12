package com.example.test0319;

import android.content.Context;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public TextView header_text, title_text;
    public static ListView listView;
    public static Context context;
    String title = "Title";
    ConnectApi connectApi = new ConnectApi();

    private int lastVisibleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        // Get data if return to MainActivity.
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            title = bundle.getString("title");
        }
        init_View();
        // Connect Api
        connectApi.connect_Api();
    }

    private void init_View(){

        header_text = findViewById(R.id.header);

        title_text = findViewById(R.id.title);
        title_text.setText(title);

        listView = findViewById(R.id.myListView);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                // Scroll down
                if (firstVisibleItem > lastVisibleItem) {
                    // Make the header go up
                    listView.animate().translationY(-header_text.getHeight()).setDuration(250);
                    header_text.animate().translationY(-header_text.getHeight()).setDuration(250);

                }
                //Scroll up
                else if (firstVisibleItem < lastVisibleItem) {
                    // Make the header go down
                    header_text.animate().translationY(0).setDuration(250);
                    listView.animate().translationY(0).setDuration(250);

                }
                //update position
                lastVisibleItem = firstVisibleItem;
            }
        });
    }
}