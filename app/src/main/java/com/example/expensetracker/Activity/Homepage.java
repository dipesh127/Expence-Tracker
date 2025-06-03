package com.example.expensetracker.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;

import com.example.expensetracker.Adapter.TrendsAdapter;
import com.example.expensetracker.Domain.TrendSDomain;
import com.example.expensetracker.MainActivity;
import com.example.expensetracker.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {
    private RecyclerView.Adapter adapterTrendlist;
    private RecyclerView recyclerViewTrends;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        initRecyclerView();
        BottomNavigation();
    }

    private void BottomNavigation() {

        LinearLayout profileBtn=findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,profilepage.class));
            }
        });
        LinearLayout walletBtn=findViewById(R.id.walletBtn);
         walletBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, MainActivity.class));
            }
        });


    }

    private void initRecyclerView(){
        ArrayList<TrendSDomain> items=new ArrayList<>();

        items.add(new TrendSDomain("Check the latest economy update","The national","pic123"));
        items.add(new TrendSDomain("Check the latest stocks update","Global Market","trend2"));
        items.add(new TrendSDomain("Market news","Global Market","trend2"));


        recyclerViewTrends=findViewById(R.id.view1);
        recyclerViewTrends.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterTrendlist=new TrendsAdapter(items);
        recyclerViewTrends.setAdapter(adapterTrendlist);
    }
}