package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomView extends View{
    private static final String TAG = "CustomView";
    private static final int IMAGE_SIZE = 250;
    private static final int WHAT_UPDATE = 1;
    private static final long DELAY_MS = 15;
    private static final int DELTA = 10;
    private int directionX = 1;
    private int directionY = 1;
    private final Drawable drawable;
    private Rect rect = new Rect();
    private Point point = new Point();
    private Point size = new Point();

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            if (directionY == 1) {
                if (point.y + DELTA + IMAGE_SIZE <= size.y)
                    point.y += DELTA;
                else
                    directionY *= -1;
            } else {
                if (point.y - DELTA >= 0)
                    point.y -= DELTA;
                else
                    directionY *= -1;
            }

            if (directionX == 1) {
                if (point.x + DELTA + IMAGE_SIZE <= size.x)
                    point.x += DELTA;
                else
                    directionX *= -1;
            } else {
                if (point.x - DELTA >= 0)
                    point.x -= DELTA;
                else
                    directionX *= -1;
            }

            invalidate();
            handler.sendEmptyMessageDelayed(WHAT_UPDATE, DELAY_MS);
        }
    };

    public CustomView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        Log.i(TAG,"CustomView( called");
        drawable = getResources().getDrawable(R.drawable.aaaa);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w,h,oldw,oldh);

        size.x = getWidth();
        size.y = getHeight();
        point.x = size.x/2 - IMAGE_SIZE/2;
        point.y = size.y/2 - IMAGE_SIZE/2;

        Log.i(TAG, "size = "+size);
        Log.i(TAG,"pointer = "+point);
        handler.sendEmptyMessageDelayed(WHAT_UPDATE, DELAY_MS);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        rect.left = point.x;
        rect.top = point.y;
        rect.right = point.x + IMAGE_SIZE;
        rect.bottom = point.y + IMAGE_SIZE;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        point.x = (int)event.getX() - IMAGE_SIZE/2;
        point.y = (int)event.getY() - IMAGE_SIZE/2;
        Log.i(TAG,"onTouchEvent "+point);
        invalidate();

        return super.onTouchEvent(event);
    }
}
