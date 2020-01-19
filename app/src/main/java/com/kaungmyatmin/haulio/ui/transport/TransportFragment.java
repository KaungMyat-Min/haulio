package com.kaungmyatmin.haulio.ui.transport;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaungmyatmin.haulio.R;
import com.kaungmyatmin.haulio.common.baseclass.BaseFragment;
import com.kaungmyatmin.haulio.helper.AuthHelper;
import com.kaungmyatmin.haulio.model.Job;
import com.kaungmyatmin.haulio.model.User;

import javax.inject.Inject;

public class TransportFragment extends BaseFragment {

    private final static String TAG = TransportFragment.class.getSimpleName();

    //-------- variables start ---------

    private Job job;
    private User user;

    //-------- variables start ---------


    //-------- view variables start ---------

    private TextView tvUserName, tvJobNumber;
    private ImageView ivProfilePic;

    //-------- view variables end ---------


    @Inject
    TransportViewModel mViewModel;

    @Inject
    AuthHelper authHelper;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        if (args != null) {
            job = (Job) args.getSerializable("job");
        }
        View view = inflater.inflate(R.layout.fragment_transport, container, false);
        bindViews(view);
        updateTheme();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivityComponent().inject(this);
        user = authHelper.getCurrentUser();

        tvUserName.setText(user.getName());
        tvJobNumber.setText(String.valueOf(job.getJobId()));

    }

    @Override
    protected void bindViews(View view) {
        tvJobNumber = view.findViewById(R.id.tv_job_number);
        tvUserName = view.findViewById(R.id.tv_user_name);
        ivProfilePic = view.findViewById(R.id.img_profile);
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
