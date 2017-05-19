package com.anwesome.ui.rotatebitmapview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 19/05/17.
 */
public class ListLayout extends ViewGroup{
    private int w,h;
    public ListLayout(Context context){
        super(context);
        initDimension(context);
    }
    public void initDimension(Context context) {
        DisplayManager displayManager = (DisplayManager)context.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display != null) {
            Point size = new Point();
            display.getRealSize(size);
            w = size.x;
            h = size.y;
        }
    }
    public void addImage(Bitmap bitmap) {
        RotateBitmapView rotateBitmapView = new RotateBitmapView(getContext(),bitmap);
        addView(rotateBitmapView,new LayoutParams(9*w/10,9*w/10));
        requestLayout();
    }
    public void onMeasure(int wspec,int hspec) {
        int newH = h/40;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            measureChild(child,wspec,hspec);
            newH += child.getMeasuredWidth() + h/40;
        }
        setMeasuredDimension(w,Math.max(newH+h/10,h));
    }
    public void onLayout(boolean reloaded,int a,int b,int w,int h) {
        int x = w/20,y = w/40;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            child.layout(x,y,x+child.getMeasuredWidth(),y+child.getMeasuredHeight());
            y += child.getMeasuredHeight()+h/40;
        }
    }
}
