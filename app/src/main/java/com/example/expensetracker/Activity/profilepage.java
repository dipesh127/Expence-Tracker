package com.example.expensetracker.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.expensetracker.Login;
import com.example.expensetracker.MainActivity;
import com.example.expensetracker.R;
import com.example.expensetracker.calendar;
import com.google.firebase.auth.FirebaseAuth;

public class profilepage extends AppCompatActivity {
    FirebaseAuth fAuth;
    protected Button bn;
    protected ConstraintLayout cal;
    protected ConstraintLayout rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
        fAuth=FirebaseAuth.getInstance();
        ImageView back=(ImageView) findViewById(R.id.imageView14);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profilepage.this, Homepage.class));

            }
        });
        ImageButton imgbut =(ImageButton) findViewById(R.id.imagebutton);
        imgbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profilepage.this, Login.class));
                FirebaseAuth.getInstance().signOut();
            }
        });
        cal=findViewById(R.id.calendar);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profilepage.this, calendar.class));
            }
        });
        rec=findViewById(R.id.record);
        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profilepage.this, MainActivity.class));
            }
        });
    }
}