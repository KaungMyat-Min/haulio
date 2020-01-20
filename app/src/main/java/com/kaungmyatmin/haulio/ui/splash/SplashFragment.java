package com.kaungmyatmin.haulio.ui.splash;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaungmyatmin.haulio.R;
import com.kaungmyatmin.haulio.common.baseclass.BaseFragment;
import com.kaungmyatmin.haulio.helper.AuthHelper;
import com.kaungmyatmin.haulio.helper.NavigationHelper;
import com.kaungmyatmin.haulio.model.User;

import javax.inject.Inject;

public class SplashFragment extends BaseFragment {

    @Inject
    SplashViewModel mViewModel;
    @Inject
    AuthHelper authHelper;
    @Inject
    NavigationHelper navigationHelper;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_splash, container, false);
        bindViews(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivityComponent().inject(this);

        if(authHelper.isLogged()){
            navigationHelper.toJobs();
        }else {
            navigationHelper.toLogin();
        }

        setListeners();
        setObservers();

    }
    @Override
    protected void bindViews(View view) {

    }


    @Override
    protected void setListeners() {

    }

    @Override
    protected void setObservers() {

    }
}
