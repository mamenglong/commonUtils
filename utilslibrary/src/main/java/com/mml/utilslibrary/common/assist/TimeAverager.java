package com.mml.utilslibrary.common.assist;

/**
 * 项目名称：Library
 * Created by Long on 2018/10/15.
 * 修改时间：2018/10/15 13:14
 * @author Long
 */
/**
 * 时间均值计算器,只能用于单线程计时。

 */
public class TimeAverager {
    /**
     * 计时器
     */
    private TimeCounter tc = new TimeCounter();
    /**
     * 均值器
     */
    private Averager av = new Averager();

    /**
     * 一个计时开始
     */
    public long start() {
        return tc.start();
    }

    /**
     * 一个计时结束
     */
    public long end() {
        long time = tc.duration();
        av.add(time);
        return time;
    }

    /**
     * 一个计时结束,并且启动下次计时。
     */
    public long endAndRestart() {
        long time = tc.durationRestart();
        av.add(time);
        return time;
    }

    /**
     * 求全部计时均值
     */
    public Number average() {
        return av.getAverage();
    }

    /**
     * 打印全部时间值
     */
    public void print() {
        av.print();
    }

    /**
     * 清楚数据
     */
    public void clear() {
        av.clear();
    }
}
