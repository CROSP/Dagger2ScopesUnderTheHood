package net.crosp.android.dagger2scopeinternals.di.component.activity;

import net.crosp.android.dagger2scopeinternals.base.ui.activity.BaseActivity;
import net.crosp.android.dagger2scopeinternals.di.component.activity.module.ActivityModule;
import net.crosp.android.dagger2scopeinternals.di.scope.PerActivity;
import net.crosp.android.dagger2scopeinternals.module.main.di.components.MainScreenComponent;
import net.crosp.android.dagger2scopeinternals.module.secondary.di.components.SecondaryScreenComponent;

import dagger.Subcomponent;

/**
 * Created by Alexander Molochko on 1/22/17.
 * Project HeartHealthMonitor
 * Copyright (C) 2017 CROSP Solutions
 */
@PerActivity
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    public void inject(BaseActivity baseActivity);

    // Subcomponents

    MainScreenComponent plusMainScreenComponent();

    SecondaryScreenComponent plusSecondaryScreenComponent();

}
