package com.kaungmyatmin.haulio.common.baseclass;



import androidx.appcompat.app.AppCompatActivity;

import com.kaungmyatmin.haulio.common.MyApplication;
import com.kaungmyatmin.haulio.common.dependancyInjection.activity.ActivityComponent;
import com.kaungmyatmin.haulio.common.dependancyInjection.activity.ActivityModule;
import com.kaungmyatmin.haulio.common.dependancyInjection.application.ApplicationComponent;


public abstract class BaseActivity extends AppCompatActivity {
    protected ActivityComponent getActivityComponent() {
        return getApplicationComponent().getActivityComponent(new ActivityModule(this));
    }

    private ApplicationComponent getApplicationComponent() {
        return ((MyApplication) getApplication()).getApplicationComponent();
    }

    protected abstract void bindViews();
    protected abstract void updateTheme();
}
