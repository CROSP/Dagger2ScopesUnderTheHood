package net.crosp.android.dagger2scopeinternals.module.main.di.modules;

import android.app.Activity;

import net.crosp.android.dagger2scopeinternals.di.scope.PerScreen;
import net.crosp.android.dagger2scopeinternals.module.main.MainScreenDependency;
import net.crosp.android.dagger2scopeinternals.module.main.MainScreenDependencyContract;
import net.crosp.android.dagger2scopeinternals.module.main.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexander Molochko on 10/27/18.
 * Project Dagger2ScopeInternals
 * Copyright (C) 2018 CROSP Solutions
 */
@Module
public class MainScreenModule {
    @Provides
    @PerScreen
    public MainActivity provideScreenActivity(Activity containerActivity) {
        return (MainActivity) containerActivity;
    }

    @Provides
    @PerScreen
    public MainScreenDependencyContract provideMainScreenDependency() {
        return new MainScreenDependency();
    }
}
