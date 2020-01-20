package com.kaungmyatmin.haulio.ui.jobs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.kaungmyatmin.haulio.R;
import com.kaungmyatmin.haulio.common.baseclass.BaseFragment;
import com.kaungmyatmin.haulio.ui.jobs.adapter.JobsAdapter;

import javax.inject.Inject;

public class JobsFragment extends BaseFragment {

    private static final String TAG = JobsFragment.class.getSimpleName();

    //------- views variables start-------

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    //------- views variables end-------

    @Inject
    JobsViewModel mViewModel;
    @Inject
    JobsAdapter jobsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jobs, container, false);
        bindViews(view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivityComponent().inject(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(jobsAdapter);

        mViewModel.fetchJobs();
        setObservers();
    }

    @Override
    protected void bindViews(View view) {
        recyclerView = view.findViewById(R.id.rv_jobs);
        progressBar  = view.findViewById(R.id.progress_bar);
    }


    @Override
    protected void setListeners() {

    }

    @Override
    protected void setObservers() {

        mViewModel.getJobsLiveData().observe(this, jobsDataWrapper -> {

            if (jobsDataWrapper.isLoading()) {
               progressBar.setVisibility(View.VISIBLE);

            } else {
                progressBar.setVisibility(View.GONE);
            }

            if (jobsDataWrapper.getErrorType() != null) {
                //show error feedback
            } else {
                //hide error feedback
            }

            if (jobsDataWrapper.getData() != null) {
                jobsAdapter.setJobs(jobsDataWrapper.getData());
            } else {
                //show no job feedback
            }
        });
    }
}
