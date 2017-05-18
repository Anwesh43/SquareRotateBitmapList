package com.anwesome.ui.rotatebitmapview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ScrollView;

/**
 * Created by anweshmishra on 19/05/17.
 */
public class RotateBitmapViewList {
    private Activity activity;
    private boolean isShown = false;
    private ScrollView scrollView;
    public RotateBitmapViewList(Activity activity) {
        this.activity = activity;
        scrollView = new ScrollView(activity);
    }
    public void addImage(Bitmap bitmap) {
        if(!isShown) {

        }
    }
    public void show() {
        if(!isShown) {
            isShown = true;
        }
    }
}
