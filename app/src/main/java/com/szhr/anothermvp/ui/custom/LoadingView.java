package com.szhr.anothermvp.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class LoadingView extends View {

  private Context mContext;
  private int mRadius = dp2px(64);

  public LoadingView(Context context) {
    this(context, null);
  }

  public LoadingView(Context context, AttributeSet attrs) {
    super(context, attrs);
    mContext = context;
  }

  private int dp2px(int dp) {
    DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
    float density = displayMetrics.density;
    return Math.round(dp * density);
  }
}
