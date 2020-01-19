package com.kaungmyatmin.haulio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kaungmyatmin.haulio.common.baseclass.BaseActivity;
import com.kaungmyatmin.haulio.ui.jobs.JobsFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    JobsFragment jobsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getActivityComponent().inject(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, jobsFragment)
                    .commitNow();
        }
    }

    @Override
    protected void bindViews() {

    }

    @Override
    protected void updateTheme() {

    }
}
