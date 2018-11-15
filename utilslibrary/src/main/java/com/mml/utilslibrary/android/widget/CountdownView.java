package com.mml.utilslibrary.android.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * 项目名称：Library
 * @author Long
 * @date 2018/7/1
 * 修改时间：2018/7/1 23:59
 *    desc   : 验证码倒计时
 */
public class CountdownView extends AppCompatTextView implements Runnable {
    // 倒计时秒数

    private int mTotalTime = 60;
    // 秒数单位文本

    private static final String TIME_UNIT = "S";
    // 当前秒数

    private int mCurrentTime;
    // 记录原有的文本

    private CharSequence mRecordText;

    // 标记是否重置了倒计控件

    private boolean mFlag;

    public CountdownView(Context context) {
        super(context);
    }

    public CountdownView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountdownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置倒计时总秒数
     */
    public void setTotalTime(int totalTime) {
        this.mTotalTime = totalTime;
    }

    /**
     * 重置倒计时控件
     */
    public void resetState() {
        mFlag = true;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        //设置点击的属性
        setClickable(true);
    }

    @Override
    protected void onDetachedFromWindow() {
        // 移除延迟任务，避免内存泄露
        removeCallbacks(this);
        super.onDetachedFromWindow();
    }

    @Override
    public boolean performClick() {
        boolean click = super.performClick();
        mRecordText = getText();
        setEnabled(false);
        mCurrentTime = mTotalTime;
        post(this);
        return click;
    }

    /**
     * {@link Runnable}
     */
    @Override
    public void run() {
        if (mCurrentTime == 0 || mFlag) {
            setText(mRecordText);
            setEnabled(true);
            mFlag = false;
        } else {
            mCurrentTime--;
            setText(mCurrentTime + "\t" + TIME_UNIT);
            postDelayed(this, 1000);
        }
    }
}