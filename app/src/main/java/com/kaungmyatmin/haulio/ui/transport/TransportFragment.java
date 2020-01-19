package com.kaungmyatmin.haulio.ui.transport;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaungmyatmin.haulio.R;
import com.kaungmyatmin.haulio.common.baseclass.BaseFragment;
import com.kaungmyatmin.haulio.helper.MyLog;
import com.kaungmyatmin.haulio.model.Job;

public class TransportFragment extends BaseFragment {

    private final static String TAG = TransportFragment.class.getSimpleName();
    private Job job;

    //-------- view variables start ---------
    // -------- view variables end ---------

    private TransportViewModel mViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        job = (Job) args.getSerializable("job");

        MyLog.d(TAG,job.getCompany());
        View view = inflater.inflate(R.layout.fragment_transport, container, false);
        bindViews(view);
        updateTheme();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TransportViewModel.class);
        // TODO: Use the ViewModel
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

    }
}
