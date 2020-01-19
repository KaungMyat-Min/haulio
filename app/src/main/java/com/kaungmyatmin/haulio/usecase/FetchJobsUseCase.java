package com.kaungmyatmin.haulio.usecase;

import com.kaungmyatmin.haulio.common.baseclass.BaseObservableUseCase;
import com.kaungmyatmin.haulio.errorhandler.ErrorType;
import com.kaungmyatmin.haulio.model.Job;
import com.kaungmyatmin.haulio.model.schema.SchemaJobs;
import com.kaungmyatmin.haulio.network.ApiService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchJobsUseCase extends BaseObservableUseCase<List<Job>> {

    private final ApiService apiService;

    @Inject
    public FetchJobsUseCase(ApiService apiService) {
        this.apiService = apiService;
    }

    public void fetchJobs() {
        Call<SchemaJobs> call = apiService.getJobs();
        postLoading(true);
        call.enqueue(new Callback<SchemaJobs>() {
            @Override
            public void onResponse(Call<SchemaJobs> call, Response<SchemaJobs> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Job> jobs = response.body().getJobs();
                    postResult(jobs);
                }else{
                    postError(ErrorType.NETWORK_ERROR);
                }
            }

            @Override
            public void onFailure(Call<SchemaJobs> call, Throwable t) {
                postError(ErrorType.NETWORK_ERROR);
            }
        });
    }
}
