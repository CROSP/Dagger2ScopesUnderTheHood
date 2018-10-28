package net.crosp.android.dagger2scopeinternals.di.component.application;

import net.crosp.android.dagger2scopeinternals.base.ui.activity.BaseActivity;
import net.crosp.android.dagger2scopeinternals.di.component.Dagger2ScopeInternalsApplication;
import net.crosp.android.dagger2scopeinternals.di.component.application.module.ApplicationUnscopedModule;
import net.crosp.android.dagger2scopeinternals.di.scope.PerApplication;
import net.crosp.android.dagger2scopeinternals.module.main.ui.MainActivity;

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

    void inject(MainActivity mainActivity);

    void inject(BaseActivity baseActivity);

    // Subcomponents
}
