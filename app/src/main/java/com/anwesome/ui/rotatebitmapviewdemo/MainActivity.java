package com.anwesome.ui.rotatebitmapviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.anwesome.ui.rotatebitmapview.RotateBitmapView;
import com.anwesome.ui.rotatebitmapview.RotateBitmapViewList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        RotateBitmapViewList rotateBitmapViewList = new RotateBitmapViewList(this);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.stp);
        for(int i=0;i<5;i++) {
            rotateBitmapViewList.addImage(bitmap);
        }
        rotateBitmapViewList.show();
    }
}
