package com.kaungmyatmin.haulio;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.kaungmyatmin.haulio.common.baseclass.BaseActivity;
import com.kaungmyatmin.haulio.helper.AuthHelper;
import com.kaungmyatmin.haulio.helper.MyLog;
import com.kaungmyatmin.haulio.helper.NavigationHelper;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    //--------- view variable start ---------
    private AppCompatImageButton ibBack, ibLogout;
    private Toolbar toolbar;
    private ActionBar actionBar;
    //-------- view variable end ---------

    @Inject
    AuthHelper authHelper;
    @Inject
    NavigationHelper navigationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getActivityComponent().inject(this);

        bindViews();
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        setListeners();
    }

    @Override
    protected void bindViews() {
        toolbar = findViewById(R.id.toolbar);
        ibLogout = toolbar.findViewById(R.id.action_log_out);
        ibBack = toolbar.findViewById(R.id.action_back);
    }

    @Override
    protected void setListeners() {

        ibLogout.setOnClickListener(view -> {
            authHelper.logout(this);
            navigationHelper.restartApplication();
        });

        ibBack.setOnClickListener(view -> {
            onBackPressed();
        });

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            switch (destination.getId()) {
                case R.id.dest_loginFragment:
                    actionBar.hide();
                    break;
                case R.id.dest_jobsFragment:
                    toolbar.findViewById(R.id.action_back).setVisibility(View.INVISIBLE);
                    actionBar.show();
                    break;
                default:
                    toolbar.findViewById(R.id.action_back).setVisibility(View.VISIBLE);
                    actionBar.show();
            }
        });
    }

}
