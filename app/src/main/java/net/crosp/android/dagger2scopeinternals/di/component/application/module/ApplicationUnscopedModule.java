package net.crosp.android.dagger2scopeinternals.di.component.application.module;

import android.app.Application;
import android.content.Context;

import net.crosp.android.dagger2scopeinternals.module.shareddependencies.contract.CarDataRepositoryContract;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.implementation.CarDataRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static net.crosp.android.dagger2scopeinternals.di.NamedConstants.Context.GLOBAL_APP_CONTEXT;

/**
 * Created by Alexander Molochko on 1/8/17.
 * Project HeartHealthMonitor
 * Copyright (C) 2017 CROSP Solutions
 */

@Module
public class ApplicationUnscopedModule {

    Application mApplication;

    public ApplicationUnscopedModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Named(GLOBAL_APP_CONTEXT)
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    public CarDataRepositoryContract provideCarDataRepository() {
        return new CarDataRepository();
    }
}