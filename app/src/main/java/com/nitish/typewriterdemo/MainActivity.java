package com.nitish.typewriterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewTreeObserver;

import com.nitish.typewriterview.TypeWriterView;

public class MainActivity extends AppCompatActivity {

    TypeWriterView typeWriterView;
    TypeWriterView typeWriterView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeWriterView = findViewById(R.id.typeWriterView);
        typeWriterView.avoidTextOverflowAtEdge(false); //explicitly disable  avoidTextOverflowAtEdge -> will give you weird animation at edges of view
        typeWriterView.animateText("This is a demo TypeWriterView. You can see the animation running. " +
                "As avoidTextOverflowAtEdge is off, " +
                "there is possibility of a wierd transition when the sentence hits the end of the View.");

        typeWriterView2 = findViewById(R.id.typeWriterView2);
        typeWriterView2.setCharacterDelay(80); //explicitly set the delay
        typeWriterView2.animateText("This is a demo TypeWriterView. You can see the animation running. " +
                "As avoidTextOverflowAtEdge is on, new line is added as soon as the word is about to hit the end of the view. " +
                "So animation will be super smooth.");
    }


}