package com.kaungmyatmin.haulio.common.dependancyInjection.activity;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentManager;


import com.kaungmyatmin.haulio.common.baseclass.BaseActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final BaseActivity mActivity;

    public ActivityModule(BaseActivity activity) {
        mActivity = activity;
    }

    @Provides
    BaseActivity getActivity() {
        return this.mActivity;
    }

    @Provides
    static Context getContext(BaseActivity activity) {
        return activity;
    }

    @Provides
    static FragmentManager getFragmentManager(BaseActivity activity) {
        return activity.getSupportFragmentManager();
    }

    @Provides
    static LayoutInflater getLayoutInflater(Context context) {
        return LayoutInflater.from(context);
    }


}
