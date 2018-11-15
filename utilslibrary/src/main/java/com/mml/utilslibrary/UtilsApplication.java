package com.mml.utilslibrary;

import android.app.Application;
import android.content.Context;

/**
 * 项目名称：commonUtils
 *
 * @author Long
 * @date 2018/10/15
 * 修改时间：2018/10/15 13:36
 */
public class UtilsApplication extends Application {
    /**
     * Global application context.
     */
    static Context context;
    private static Application application;

   public UtilsApplication(){
        context=this;
    }
    public static void initialize(Context context) {
        UtilsApplication.context= context;
    }
    public static Context getContext() {
        if(context==null)
        {
            throw new RuntimeException("Application context is null.");
        }
        return context;
    }
    public static Application getApplication(){
        return application;
    }
}
