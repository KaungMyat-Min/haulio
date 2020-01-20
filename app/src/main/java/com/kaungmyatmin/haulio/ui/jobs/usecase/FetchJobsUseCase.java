package com.kaungmyatmin.haulio.ui.jobs.usecase;

import com.kaungmyatmin.haulio.common.baseclass.BaseObservableUseCase;
import com.kaungmyatmin.haulio.errorhandler.ErrorType;
import com.kaungmyatmin.haulio.model.Job;
import com.kaungmyatmin.haulio.network.ApiService;
import com.kaungmyatmin.haulio.helper.MyLog;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchJobsUseCase extends BaseObservableUseCase<List<Job>> {

    private static final String TAG = FetchJobsUseCase.class.getSimpleName();
    private final ApiService apiService;

    @Inject
    public FetchJobsUseCase(ApiService apiService) {
        this.apiService = apiService;
    }

    public void fetchJobs() {
        Call<List<Job>> call = apiService.getJobs();
        postLoading(true);
        call.enqueue(new Callback<List<Job>>() {
            @Override
            public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                MyLog.d(TAG,response.message());
                if (response.isSuccessful() && response.body() != null) {
                    List<Job> jobs = response.body();
                    postResult(jobs);
                }else{
                    postError(ErrorType.NETWORK_ERROR);
                }
            }

            @Override
            public void onFailure(Call<List<Job>> call, Throwable t) {
                MyLog.d(TAG,t.getMessage());
                postError(ErrorType.NETWORK_ERROR);
            }
        });
    }
}
