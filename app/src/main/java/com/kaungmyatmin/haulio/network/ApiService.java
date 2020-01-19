package com.kaungmyatmin.haulio.network;

import com.kaungmyatmin.haulio.model.Job;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String API_VERSION = "bins/";

    @GET(API_VERSION + "8d195")
    Call<List<Job>> getJobs();
}