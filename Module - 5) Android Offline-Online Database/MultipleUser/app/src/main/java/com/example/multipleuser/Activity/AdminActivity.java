package com.example.multipleuser.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.multipleuser.R;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        setTitle("Admin");
    }
}