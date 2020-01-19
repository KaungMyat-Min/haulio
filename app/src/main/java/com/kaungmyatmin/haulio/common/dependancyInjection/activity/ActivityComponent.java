package com.kaungmyatmin.haulio.common.dependancyInjection.activity;



import com.kaungmyatmin.haulio.MainActivity;
import com.kaungmyatmin.haulio.ui.main.JobsFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class, ViewModelModule.class})
public interface ActivityComponent {

    void inject(MainActivity loginFragment);

    void inject(JobsFragment jobsFragment);
}
