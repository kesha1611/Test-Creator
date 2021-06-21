package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MakePaper extends AppCompatActivity {

    Button cppBtn,javaBtn,htmlBtn,sqlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_paper);

        cppBtn = findViewById(R.id.cpp_btn);
        javaBtn = findViewById(R.id.java_btn);
        htmlBtn = findViewById(R.id.html_btn);
        sqlBtn = findViewById(R.id.sql_btn);

        cppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CppActivity.class));
            }
        });

        javaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), jaActivity.class));
            }
        });

        sqlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), sqActivity.class));
            }
        });

        htmlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), htActivity.class));
            }
        });
    }
}
