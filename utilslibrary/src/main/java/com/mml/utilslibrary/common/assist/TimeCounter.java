package com.mml.utilslibrary.common.assist;


import com.mml.utilslibrary.android.LogUtils;
/**
 * 项目名称：Library
 * Created by Long on 2018/10/15.
 * 修改时间：2018/10/15 13:14
 * @author Long
 */
/**
 * Time Counter.

 */
public class TimeCounter {

    private static final String TAG = TimeCounter.class.getSimpleName();
    private long t;

    public TimeCounter() {
        start();
    }

    /**
     * Count start.
     */
    public long start() {
        t = System.currentTimeMillis();
        return t;
    }

    /**
     * Get duration and restart.
     */
    public long durationRestart() {
        long now = System.currentTimeMillis();
        long d = now - t;
        t = now;
        return d;
    }

    /**
     * Get duration.
     */
    public long duration() {
        return System.currentTimeMillis() - t;
    }

    /**
     * Print duration.
     */
    public void printDuration(String tag) {
        LogUtils.i(TAG, tag + " :  " + duration());
    }

    /**
     * Print duration.
     */
    public void printDurationRestart(String tag) {
        LogUtils.i(TAG, tag + " :  " + durationRestart());
    }
}