package com.kaungmyatmin.haulio.common.dependancyInjection.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.kaungmyatmin.haulio.utli.PreferenceUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application getApplication() {
        return mApplication;
    }

    @Provides
    static SharedPreferences provideSharePref(Application application) {
        return application.getSharedPreferences("MyClips", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    static PreferenceUtil getPreferenceUtil(Application application) {
        return new PreferenceUtil(application);
    }

}
