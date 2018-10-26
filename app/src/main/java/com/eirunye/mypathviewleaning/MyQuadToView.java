package com.eirunye.mypathviewleaning;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;

/**
 * Author Eirunye
 * Created by on 2018/10/26.
 * Describe
 */
public class MyQuadToView extends View {
    private Paint paint;
    private Path path;

    private int mX = 400;
    private int mY = 500;
    private int oX;
    private ValueAnimator valueAnimator;

    public MyQuadToView(Context context) {
        this(context, null);
    }

    public MyQuadToView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyQuadToView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        path = new Path();
        startAnim();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        path.moveTo(100, 300);
//        path.quadTo(200,200,300,300);
//        path.quadTo(400,400,500,300);
//        path.quadTo(600,200,700,300);
//        path.quadTo(800,400,900,300);

//        path.rQuadTo(100, -100, 200, 0);
//        path.rQuadTo(100, 100, 200, 0);
//        path.rQuadTo(100, -100, 200, 0);
//        path.rQuadTo(100, 100, 200, 0);
//
//        path.lineTo(800, 900);
//        path.lineTo(200, 900);
//        path.close();

        path.reset();
        mY -= 5;
        int wlen = mX / 2;
        path.moveTo(-mX + oX, mY);
        for (int i = -mX; i <= getWidth() + mX; i += mX) {
            path.rQuadTo(wlen / 2, -50, wlen, 0);
            path.rQuadTo(wlen / 2, 50, wlen, 0);
        }
        path.lineTo(getWidth(), getHeight());
        path.lineTo(0, getHeight());
        path.close();
        canvas.drawPath(path, paint);
        if (mY <= -20) {
            mY = getHeight();
//            invalidate();
//            stopAnim();
        }
    }

    public void startAnim() {
        valueAnimator = ValueAnimator.ofInt(0, mX);
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                oX = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.start();
    }

    public void stopAnim() {
        if (valueAnimator != null && valueAnimator.isRunning()) valueAnimator.cancel();
    }

}
