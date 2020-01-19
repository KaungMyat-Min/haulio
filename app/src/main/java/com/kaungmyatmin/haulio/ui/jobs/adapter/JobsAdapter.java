package com.kaungmyatmin.haulio.ui.jobs.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kaungmyatmin.haulio.R;
import com.kaungmyatmin.haulio.common.baseclass.BaseViewHolder;
import com.kaungmyatmin.haulio.helper.NavigationHelper;
import com.kaungmyatmin.haulio.model.Job;

import java.util.List;

import javax.inject.Inject;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.MyViewHolder> {

    private static final String TAG = JobsAdapter.class.getSimpleName();

    private LayoutInflater inflater;
    private List<Job> jobs;
    private NavigationHelper navigationHelper;

    @Inject
    public JobsAdapter(LayoutInflater inflater, NavigationHelper navigationHelper) {
        this.inflater = inflater;
        this.navigationHelper = navigationHelper;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_job, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Job job = jobs.get(position);
        holder.bindData(job);
    }

    @Override
    public int getItemCount() {
        return jobs != null ? jobs.size() : 0;
    }
    //------------- getter and setter -----------

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
        notifyDataSetChanged();
    }

    //------------- view holder -------------

    public class MyViewHolder extends BaseViewHolder<Job> {

        private TextView tvJobNumber, tvCompany, tvAddress;
        private Button btnAccept;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        protected void bindViews(View view) {
            tvJobNumber = view.findViewById(R.id.job_number);
            tvCompany = view.findViewById(R.id.company);
            tvAddress = view.findViewById(R.id.address);
            btnAccept = view.findViewById(R.id.btn_accept);
        }

        @Override
        protected void updateTheme() {

        }

        @Override
        protected void bindData(Job job) {

            tvJobNumber.setText(String.valueOf(job.getJobId()));
            tvCompany.setText(job.getCompany());
            tvAddress.setText(job.getAddress());

            btnAccept.setOnClickListener(view -> {
                navigationHelper.toTransport(job);
            });

        }
    }
}
