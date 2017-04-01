package com.ekumid.socorro.ekumid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class RecyclerViewActivity extends AppCompatActivity {

   static RecyclerView recyclerView;
     static RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view);

        recyclerView=(RecyclerView)findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new MyAdapter(GetNearbyPlacesData.listItems,getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(RecyclerViewActivity.this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);




    }


}
