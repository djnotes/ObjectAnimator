package me.mehdi.android3animations;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import me.mehdi.android3animations.R;

public class Egg extends View {

    private static final int DEFAULT_RADIUS = 50;
    Paint mPaint;
    int mColor;
    String mLabel;
    boolean mHasCorner;
    int mRadius;



    public Egg(Context context) {
        super(context);
        init(context, null);
    }

    public Egg(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public Egg(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Egg(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    void init(Context ctx, AttributeSet attrs) {
        mPaint = new Paint();
        TypedArray a = ctx.getTheme().obtainStyledAttributes(attrs, R.styleable.Egg, 0, 0);
        try{
            mColor = a.getInt(R.styleable.Egg_bodyColor, Color.argb(100, 255, 0, 0));;
            mLabel = a.getString(R.styleable.Egg_label);
            mRadius = a.getInt(R.styleable.Egg_radius, DEFAULT_RADIUS);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = this.getMeasuredWidth() / 2;
        int height = this.getMeasuredHeight() / 2;

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setColor(mColor);

        canvas.drawCircle(width, height, mRadius, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(40);

        canvas.drawText(mLabel, width, height, mPaint);
    }
}
