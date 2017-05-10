package com.jxlc.tajiproject.ui.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.jxlc.tajiproject.bean.TowerCraneInfo;

/**
 * Created by Randal on 2017-05-06.
 */

public class TowerCrane2DView extends View {
    private Context mContext;
    private TowerCraneInfo mTowerCraneInfo = TowerCraneInfo.getDemoInfo();
    private Paint mPaint;

    private boolean isChecked;

    public TowerCrane2DView(Context context) {
        this(context, null);
    }

    public TowerCrane2DView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TowerCrane2DView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public void setTowerCraneInfo(TowerCraneInfo info) {
        mTowerCraneInfo = info;
    }

    public TowerCraneInfo getTowerCraneInfo() {
        return mTowerCraneInfo;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height ;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = (int)(mTowerCraneInfo.getFrontArmLength() * 2);
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = (int)(mTowerCraneInfo.getFrontArmLength() * 2);
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int whalf = this.getWidth() / 2;
        int hhalf = this.getHeight() / 2;
        int radius = whalf < hhalf ? whalf : hhalf;
        double ap = mTowerCraneInfo.getAngle() * Math.PI / 180;
        float a = (float)Math.sin(ap);
        float b = (float)Math.cos(ap);

        mPaint.setStyle(Paint.Style.FILL);                        // 前臂圆
        if (isChecked) {
            mPaint.setColor(Color.parseColor("#EF00FFFF"));
        } else {
            mPaint.setColor(Color.parseColor("#EF00E100"));
        }
        canvas.drawCircle(this.getWidth() / 2, this.getHeight() / 2, radius, mPaint);

        if (isChecked) {
            mPaint.setColor(Color.parseColor("#EF00DDDD"));       // 后臂圆
        } else {
            mPaint.setColor(Color.parseColor("#EF00B400"));
        }
        canvas.drawCircle(this.getWidth() / 2, this.getHeight() / 2, mTowerCraneInfo.getRearArmLength(), mPaint);

        mPaint.setColor(Color.BLACK);                                          // 吊车
        canvas.drawCircle(whalf + mTowerCraneInfo.getTrolleyDistance() * b,
                hhalf - mTowerCraneInfo.getTrolleyDistance() * a, 3, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        canvas.drawCircle(this.getWidth() / 2, this.getHeight() / 2, mTowerCraneInfo.getRearArmLength(), mPaint);

        canvas.drawLine(whalf - mTowerCraneInfo.getRearArmLength() * b,         // 吊臂
                hhalf + mTowerCraneInfo.getRearArmLength() * a,
                whalf + mTowerCraneInfo.getFrontArmLength() * b,
                hhalf - mTowerCraneInfo.getFrontArmLength() * a, mPaint);
    }

    public void setChecked(boolean check) {
        this.isChecked = check;
    }
}
