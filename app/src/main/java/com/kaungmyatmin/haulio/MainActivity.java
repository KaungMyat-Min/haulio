package com.kaungmyatmin.haulio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kaungmyatmin.haulio.ui.main.JobsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, JobsFragment.newInstance())
                    .commitNow();
        }
    }
}
