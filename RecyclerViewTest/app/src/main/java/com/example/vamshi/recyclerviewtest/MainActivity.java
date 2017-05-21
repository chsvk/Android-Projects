package com.example.vamshi.recyclerviewtest;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myList;
    private RecyclerView.Adapter adapter;
    private List<ModelForListItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = (RecyclerView)findViewById(R.id.myList);
        myList.setHasFixedSize(true);
        myList.setLayoutManager(new LinearLayoutManager(this));
        items = new ArrayList<>();

        for(int i =0; i<=20; i++){
            ModelForListItem item = new ModelForListItem("Heading", "description");
            items.add(item);
        }

        adapter = new Adapter(items, this);
        myList.setAdapter(adapter);
    }
}
