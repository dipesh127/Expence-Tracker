package com.example.expensetracker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.expensetracker.R;

public class Welcomepage extends AppCompatActivity {
public Button introBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);
        introBtn=findViewById(R.id.introBtn);

        introBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcomepage.this, Homepage.class));
            }
        });
    }
}