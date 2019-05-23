package com.hcj.baseapplication.base;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.hcj.baseapplication.utils.AppManager;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by jianliang on 2016/7/6.
 */
public class GlobalApplication extends Application {
    private static GlobalApplication instance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Utils.init(this);

        AppManager.getAppManager();

        CrashReport.initCrashReport(getApplicationContext(), "31a5f1f394", false);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public static GlobalApplication getInstance() {
        if (null == instance) {
            instance = new GlobalApplication();
        }
        return instance;
    }
}
