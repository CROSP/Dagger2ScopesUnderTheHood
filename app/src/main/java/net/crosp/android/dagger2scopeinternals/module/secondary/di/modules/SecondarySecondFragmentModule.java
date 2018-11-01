package net.crosp.android.dagger2scopeinternals.module.secondary.di.modules;

import android.app.Activity;

import net.crosp.android.dagger2scopeinternals.module.secondary.ui.SecondaryActivity;
import net.crosp.android.dagger2scopeinternals.module.secondary.ui.SecondarySecondFragment;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.contract.CarPartsDataRepositoryContract;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.implementation.CarPartsDataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexander Molochko on 10/27/18.
 * Project Dagger2ScopeInternals
 * Copyright (C) 2018 CROSP Solutions
 */
@Module
public class SecondarySecondFragmentModule {
    @Provides
    @Singleton
    public SecondarySecondFragment.FirstFragmentRouter provideFirstFragmentRouter(Activity containerActivity) {
        return (SecondaryActivity) containerActivity;
    }

    @Provides
    @Singleton
    CarPartsDataRepositoryContract provideCarPartsDataRepository() {
        return new CarPartsDataRepository();
    }
}
