package com.kaungmyatmin.haulio.common.baseclass;


import android.view.View;

import androidx.fragment.app.Fragment;

import com.kaungmyatmin.haulio.common.dependancyInjection.activity.ActivityComponent;


public abstract class BaseFragment extends Fragment {
    private ActivityComponent mActivityComponent;

    protected ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = ((BaseActivity) getActivity()).getActivityComponent();
        }
        return mActivityComponent;
    }


    protected abstract void bindViews(View view);
    protected abstract void updateTheme();
    protected abstract void setListeners();
    protected abstract void setObservers();
}
