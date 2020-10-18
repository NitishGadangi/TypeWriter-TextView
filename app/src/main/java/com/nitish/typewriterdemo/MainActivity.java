package com.nitish.typewriterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nitish.typewriterview.TypeWriterView;

public class MainActivity extends AppCompatActivity {

    TypeWriterView typeWriterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeWriterView = findViewById(R.id.typeWriterView);
        typeWriterView.animateText("Hello this is a typewriter textview");
    }
}