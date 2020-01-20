package com.kaungmyatmin.haulio;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.kaungmyatmin.haulio.common.baseclass.BaseActivity;
import com.kaungmyatmin.haulio.helper.AuthHelper;
import com.kaungmyatmin.haulio.helper.MyLog;
import com.kaungmyatmin.haulio.helper.NavigationHelper;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    AuthHelper authHelper;
    @Inject
    NavigationHelper navigationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getActivityComponent().inject(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            switch (destination.getId()) {
                case R.id.dest_loginFragment:
                    actionBar.hide();
                    break;
                default:
                    actionBar.show();
            }
        });

    }

    @Override
    protected void bindViews() {

    }

    @Override
    protected void updateTheme() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_log_out:

                authHelper.logout();
                navigationHelper.restartApplication();

                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return true;
    }
}
