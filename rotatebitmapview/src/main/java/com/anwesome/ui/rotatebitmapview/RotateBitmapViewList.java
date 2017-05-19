package com.anwesome.ui.rotatebitmapview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by anweshmishra on 19/05/17.
 */
public class RotateBitmapViewList {
    private Activity activity;
    private boolean isShown = false;
    private ListLayout listLayout;
    private ScrollView scrollView;
    public RotateBitmapViewList(Activity activity) {
        this.activity = activity;
        listLayout = new ListLayout(activity);
        scrollView = new ScrollView(activity);
        scrollView.addView(listLayout,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    public void addImage(Bitmap bitmap) {
        if(!isShown) {
            listLayout.addImage(bitmap);
        }
    }
    public void show() {
        if(!isShown) {
            activity.setContentView(scrollView);
            isShown = true;
        }
    }
}
