package com.kaungmyatmin.haulio.ui.jobs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.kaungmyatmin.haulio.common.baseclass.BaseViewModel;
import com.kaungmyatmin.haulio.model.DataWrapper;
import com.kaungmyatmin.haulio.model.Job;
import com.kaungmyatmin.haulio.usecase.FetchJobsUseCase;

import java.util.List;

import javax.inject.Inject;

public class JobsViewModel extends BaseViewModel {
    private LiveData<DataWrapper<List<Job>>> jobsLiveData;

    private final FetchJobsUseCase fetchJobsUseCase;

    @Inject
    public JobsViewModel(FetchJobsUseCase fetchJobsUseCase) {
        this.fetchJobsUseCase = fetchJobsUseCase;
        init();
    }


    @Override
    protected void init() {
        jobsLiveData = Transformations.map(fetchJobsUseCase.getResult(),response->response);
    }

    public void fetchJobs(){
        fetchJobsUseCase.fetchJobs();
    }



    //------------- getters and setter -------------
    public LiveData<DataWrapper<List<Job>>> getJobsLiveData() {
        return jobsLiveData;
    }
}
