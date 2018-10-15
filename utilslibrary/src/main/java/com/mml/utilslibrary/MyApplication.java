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
public class MyApplication extends Application {
    private static Context context;
    private static Application application;
    @Override
    public void onCreate() {
        super.onCreate();
        if(context==null){
            context=getApplicationContext();
        }
        if(application==null)
        {
            application=this;
        }
    }
    public static Context getContext() {
        return context;
    }
    public static Application getApplication(){
        return application;
    }
}
