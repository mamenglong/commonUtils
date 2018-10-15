package com.mml.utilslibrary.common.utils;

import android.content.Context;
import android.util.DisplayMetrics;

import com.mml.utilslibrary.android.LogUtils;


/**
 * 项目名称：Library
 * Created by Long on 2018/10/15.
 * 修改时间：2018/10/15 13:14
 * @author Long
 */
public class DisplayUtil {
    private static final String TAG = DisplayUtil.class.getSimpleName();

    /**
     * 获取 显示信息
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm;
    }

    /**
     * 打印 显示信息
     */
    public static DisplayMetrics printDisplayInfo(Context context) {
        DisplayMetrics dm = getDisplayMetrics(context);

            StringBuilder sb = new StringBuilder();
            sb.append("_______  显示信息:  ");
            sb.append("\ndensity         :").append(dm.density);
            sb.append("\ndensityDpi      :").append(dm.densityDpi);
            sb.append("\nheightPixels    :").append(dm.heightPixels);
            sb.append("\nwidthPixels     :").append(dm.widthPixels);
            sb.append("\nscaledDensity   :").append(dm.scaledDensity);
            sb.append("\nxdpi            :").append(dm.xdpi);
            sb.append("\nydpi            :").append(dm.ydpi);
            LogUtils.i(TAG, sb.toString());

        return dm;
    }
}
