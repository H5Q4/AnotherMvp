package com.szhr.anothermvp.ui.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.szhr.anothermvp.R;

public class LoadingView extends View {

  private Context mContext;
  private int mOuterRadius;
  private int mInnerRadius;
  private Paint mPaint;
  private int mPaintCount;

  public LoadingView(Context context) {
    this(context, null);
  }

  public LoadingView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    mContext = context;
    mOuterRadius = dp2px(28);
    mInnerRadius = dp2px(mOuterRadius / 6);
    setUpPaint();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    mPaintCount++;
    System.out.println(mPaintCount);
    int x = getWidth();
    int y = getHeight();
    mPaint.setColor(ContextCompat.getColor(mContext, R.color.teal_900));
    canvas.drawCircle(x / 2, y / 2, mOuterRadius, mPaint);
    mPaint.setColor(ContextCompat.getColor(mContext, R.color.pink_900));
    canvas.drawCircle(x / 2, y / 2, mInnerRadius, mPaint);

    if (mPaintCount < mInnerRadius) {
      if (mPaintCount < mInnerRadius / 2) {
        mOuterRadius -= 1;
        mInnerRadius += 1;
      } else {
        mOuterRadius += 1;
        mInnerRadius -= 1;
      }
      invalidate();
    } else {
      mPaintCount = 0;
      mOuterRadius = dp2px(28);
      mInnerRadius = dp2px(mOuterRadius / 6);
      invalidate();
    }
  }

  private void setUpPaint() {
    mPaint = new Paint();
    mPaint.setStyle(Paint.Style.FILL);
  }

  private int dp2px(int dp) {
    DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
    float density = displayMetrics.density;
    return Math.round(dp * density);
  }
}
