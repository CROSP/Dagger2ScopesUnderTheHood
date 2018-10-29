package net.crosp.android.dagger2scopeinternals.module.secondary.di.modules;

import android.app.Activity;

import net.crosp.android.dagger2scopeinternals.di.scope.PerFragment;
import net.crosp.android.dagger2scopeinternals.module.secondary.ui.SecondaryFirstFragment;
import net.crosp.android.dagger2scopeinternals.module.secondary.ui.SecondaryActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexander Molochko on 10/27/18.
 * Project Dagger2ScopeInternals
 * Copyright (C) 2018 CROSP Solutions
 */
@Module
public class SecondaryFirstFragmentModule {
    @Provides
    @PerFragment
    public SecondaryFirstFragment.SecondFragmentRouter provideSecondFragmentRouter(Activity containerActivity) {
        return (SecondaryActivity) containerActivity;
    }
}
