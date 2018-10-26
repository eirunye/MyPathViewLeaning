package com.eirunye.mypathviewleaning;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Author Eirunye
 * Created by on 2018/10/26.
 * Describe
 */
public class MyPathView extends View {

    Paint paint;
    Path path;

    public MyPathView(Context context) {
        this(context, null);
    }

    public MyPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                path.moveTo(event.getX(), event.getY());
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(), event.getY());
                invalidate();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    public void reset() {
        invalidate();
    }
}
