package com.anwesome.ui.rotatebitmapview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 19/05/17.
 */
public class RotateBitmapView extends View {
    private int time = 0,w,h,size;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    private RotateBitmap rotateBitmap;
    private AnimationHandler animationHandler = new AnimationHandler();
    public RotateBitmapView(Context context,Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            size = w/3;
            bitmap = Bitmap.createScaledBitmap(bitmap,2*size,2*size,true);
            rotateBitmap = new RotateBitmap();

        }
        rotateBitmap.draw(canvas);
        time++;
    }
    public void update(float factor) {
        rotateBitmap.update(factor);
        postInvalidate();
    }
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(),y = event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN && x>=w/2-size && x<=w/2+size && y>=h/2-size && y<=h/2+size) {
            animationHandler.start();
        }
        return true;
    }
    private class RotateBitmap {
        private float deg = 0;
        public void draw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            paint.setColor(Color.GRAY);
            paint.setStrokeWidth(w/50);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(new RectF(w/2-size,h/2-size,w/2+size,h/2+size),paint);
            canvas.save();
            canvas.translate(w/2,h/2);
            Path path = new Path();
            for(float i=0;i<=deg;i++) {
                float r = 2*w/(3*(float)Math.sqrt(2));
                float x = (float)(r*Math.cos(i*Math.PI/180)),y = (float)(r*Math.sin(i*Math.PI/180));
                if(i == -90) {
                    path.moveTo(x,y);
                }
                else {
                    path.lineTo(x,y);
                }
            }
            canvas.clipPath(path);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawBitmap(bitmap,-bitmap.getWidth()/2,-bitmap.getHeight()/2,paint);
            canvas.restore();
        }
        public void update(float facotor) {
            deg = 360*facotor;
        }
    }
    private class AnimationHandler extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private int dir = 0;
        private boolean isAnimating = false;
        private ValueAnimator startAnim = ValueAnimator.ofFloat(0,1),endAnim = ValueAnimator.ofFloat(1,0);
        public AnimationHandler() {
            startAnim.addUpdateListener(this);
            endAnim.addUpdateListener(this);
            endAnim.addListener(this);
            startAnim.addListener(this);
            startAnim.setDuration(500);
            endAnim.setDuration(500);
        }
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            update((float)valueAnimator.getAnimatedValue());
        }
        public void onAnimationEnd(Animator animator) {
            if(isAnimating) {
                isAnimating = false;
            }
        }
        public void start() {
            if (!isAnimating) {
                if (dir == 0) {
                    startAnim.start();
                } else {
                    endAnim.start();
                }
                dir = dir == 0 ? 1 : 0;
                isAnimating = true;
            }
        }
    }
}
