package com.kaungmyatmin.haulio.common.dependancyInjection.activity;



import com.kaungmyatmin.haulio.MainActivity;
import com.kaungmyatmin.haulio.ui.login.LoginFragment;
import com.kaungmyatmin.haulio.ui.jobs.JobsFragment;
import com.kaungmyatmin.haulio.ui.splash.SplashFragment;
import com.kaungmyatmin.haulio.ui.transport.TransportFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class, ViewModelModule.class})
public interface ActivityComponent {

    void inject(MainActivity loginFragment);

    void inject(JobsFragment jobsFragment);

    void inject(TransportFragment transportFragment);

    void inject(LoginFragment loginFragment);

    void inject(SplashFragment splashFragment);
}
