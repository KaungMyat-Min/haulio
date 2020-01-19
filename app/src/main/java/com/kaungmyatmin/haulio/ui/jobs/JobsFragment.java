package com.kaungmyatmin.haulio.ui.jobs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaungmyatmin.haulio.R;
import com.kaungmyatmin.haulio.common.baseclass.BaseFragment;
import com.kaungmyatmin.haulio.model.Job;
import com.kaungmyatmin.haulio.utli.MyLog;

import java.lang.annotation.Target;
import java.util.List;

import javax.inject.Inject;

public class JobsFragment extends BaseFragment {

    private final String TAG = JobsFragment.class.getSimpleName();
    @Inject
    JobsViewModel mViewModel;

    @Inject
    public JobsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        bindViews(view);
        updateTheme();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivityComponent().inject(this);

        mViewModel.fetchJobs();
        setObservers();

    }

    @Override
    protected void bindViews(View view) {

    }

    @Override
    protected void updateTheme() {

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void setObservers() {
        mViewModel.getJobsLiveData().observe(this, jobsDataWrapper -> {
            if(jobsDataWrapper.isLoading()){

            }else{

            }
        });
    }
}
