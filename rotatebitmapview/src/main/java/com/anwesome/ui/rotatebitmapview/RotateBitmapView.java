package com.anwesome.ui.rotatebitmapview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 19/05/17.
 */
public class RotateBitmapView extends View {
    private int time = 0,w,h;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    public RotateBitmapView(Context context,Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            bitmap = Bitmap.createScaledBitmap(bitmap,w/3,w/3,true);
        }
        time++;
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {

        }
        return true;
    }
    private class RotateBitmap {
        private float deg = 0;
        public void draw(Canvas canvas) {
            canvas.save();
            Path path = new Path();
            for(int i=-90;i<-90+deg;i++) {
                float x = w/2+w/6*(float)Math.cos(i*Math.PI/180),y = h/2+w/6*(float)Math.sin(i*Math.PI/180);
                if(i == -90) {
                    path.moveTo(x,y);
                }
                else {
                    path.lineTo(x,y);
                }
            }
            canvas.clipPath(path);
            canvas.drawBitmap(bitmap,w/2-bitmap.getWidth()/2,h/2-bitmap.getHeight()/2,paint);
            canvas.restore();
        }
        public void update(float facotor) {
            deg = 360*facotor;
        }
    }
}
