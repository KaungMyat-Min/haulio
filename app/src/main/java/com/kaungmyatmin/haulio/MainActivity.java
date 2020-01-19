package com.kaungmyatmin.haulio;

import android.os.Bundle;

import com.kaungmyatmin.haulio.common.baseclass.BaseActivity;
import com.kaungmyatmin.haulio.helper.NavigationHelper;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getActivityComponent().inject(this);
    }

    @Override
    protected void bindViews() {

    }

    @Override
    protected void updateTheme() {

    }
}
