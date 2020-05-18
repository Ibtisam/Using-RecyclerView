package com.example.usingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting reference of recycler view
        recyclerView = findViewById(R.id.countriesRV);

        //if you know that the size of data is fixed, you can set this for performance
        recyclerView.setHasFixedSize(true);

        //setting Layout manager for recycler view
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //setting the Adapter, for this you have to create a custom Adapter class
        myDataset = getResources().getStringArray(R.array.countries_array);
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);

        //adding a line divider after each item
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
