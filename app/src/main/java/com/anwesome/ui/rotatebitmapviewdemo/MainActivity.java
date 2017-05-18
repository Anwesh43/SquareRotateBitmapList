package com.anwesome.ui.rotatebitmapviewdemo;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.anwesome.ui.rotatebitmapview.RotateBitmapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RotateBitmapView rotateBitmapView = new RotateBitmapView(this, BitmapFactory.decodeResource(getResources(),R.drawable.stp));
        addContentView(rotateBitmapView,new ViewGroup.LayoutParams(600,600));
    }
}
