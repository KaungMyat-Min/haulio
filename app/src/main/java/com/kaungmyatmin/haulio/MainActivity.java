package com.kaungmyatmin.haulio;

import android.os.Bundle;

import com.kaungmyatmin.haulio.common.baseclass.BaseActivity;
import com.kaungmyatmin.haulio.helper.NavigationHelper;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    NavigationHelper navigationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getActivityComponent().inject(this);
        if (savedInstanceState == null) {
            navigationHelper.jobsFragment();
        }
    }

    @Override
    protected void bindViews() {

    }

    @Override
    protected void updateTheme() {

    }
}
