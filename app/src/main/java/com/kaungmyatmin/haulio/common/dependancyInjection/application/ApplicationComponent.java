package com.kaungmyatmin.haulio.common.dependancyInjection.application;



import com.kaungmyatmin.haulio.common.dependancyInjection.NetworkModule;
import com.kaungmyatmin.haulio.common.dependancyInjection.activity.ActivityComponent;
import com.kaungmyatmin.haulio.common.dependancyInjection.activity.ActivityModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
    ActivityComponent getActivityComponent(ActivityModule activityModule);
}
