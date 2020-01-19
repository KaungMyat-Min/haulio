package com.kaungmyatmin.haulio.common;

import android.app.Application;

import com.kaungmyatmin.haulio.common.dependancyInjection.application.ApplicationComponent;
import com.kaungmyatmin.haulio.common.dependancyInjection.application.ApplicationModule;
import com.kaungmyatmin.haulio.common.dependancyInjection.application.DaggerApplicationComponent;


public class MyApplication extends Application {


    private static MyApplication mInstance;



    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();



    }


    public static synchronized MyApplication getInstance() {
        return mInstance;
    }



    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
