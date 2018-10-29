package net.crosp.android.dagger2scopeinternals.di.component.application;

import net.crosp.android.dagger2scopeinternals.di.component.Dagger2ScopeInternalsApplication;
import net.crosp.android.dagger2scopeinternals.di.component.activity.ActivityComponent;
import net.crosp.android.dagger2scopeinternals.di.component.activity.module.ActivityModule;
import net.crosp.android.dagger2scopeinternals.di.component.application.module.ApplicationUnscopedModule;
import net.crosp.android.dagger2scopeinternals.di.scope.PerApplication;

import dagger.Component;

/**
 * Created by Alexander Molochko on 1/8/17.
 * Project HeartHealthMonitor
 * Copyright (C) 2017 CROSP Solutions
 */
@PerApplication
@Component(modules = {
        ApplicationUnscopedModule.class})

public interface ApplicationComponent {
    // Injection methods
    void inject(Dagger2ScopeInternalsApplication mainApplication);

    // Subcomponents
    ActivityComponent plusActivityComponent(ActivityModule activityModule);

}
