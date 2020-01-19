package com.kaungmyatmin.haulio.common.dependancyInjection.activity;


import androidx.lifecycle.ViewModel;

import com.kaungmyatmin.haulio.ui.jobs.JobsViewModel;
import com.kaungmyatmin.haulio.ui.transport.TransportViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }


    @Binds
    @IntoMap
    @ViewModelKey(JobsViewModel.class)
    abstract ViewModel provideJobsModel(JobsViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TransportViewModel.class)
    abstract ViewModel provideTransportModel(TransportViewModel viewModel);



}
