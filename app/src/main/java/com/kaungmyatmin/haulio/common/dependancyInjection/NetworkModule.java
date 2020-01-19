package com.kaungmyatmin.haulio.common.dependancyInjection;

import com.kaungmyatmin.haulio.network.ApiService;
import com.kaungmyatmin.haulio.network.RetrofitBuilder;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class NetworkModule {

    @Provides
    @Singleton
    static ApiService provideApiService() {
        return RetrofitBuilder.createService(ApiService.class);
    }
}

