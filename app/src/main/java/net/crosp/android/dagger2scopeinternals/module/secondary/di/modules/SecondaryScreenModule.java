package net.crosp.android.dagger2scopeinternals.module.secondary.di.modules;

import android.app.Activity;

import net.crosp.android.dagger2scopeinternals.di.scope.PerScreen;
import net.crosp.android.dagger2scopeinternals.module.secondary.ui.SecondaryActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexander Molochko on 10/27/18.
 * Project Dagger2ScopeInternals
 * Copyright (C) 2018 CROSP Solutions
 */
@Module
public class SecondaryScreenModule {
    @Provides
    @PerScreen
    public SecondaryActivity provideScreenActivity(Activity containerActivity) {
        return (SecondaryActivity) containerActivity;
    }
}
