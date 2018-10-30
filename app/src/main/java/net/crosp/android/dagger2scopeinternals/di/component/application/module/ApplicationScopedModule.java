package net.crosp.android.dagger2scopeinternals.di.component.application.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import net.crosp.android.dagger2scopeinternals.di.component.Dagger2ScopeInternalsApplication;
import net.crosp.android.dagger2scopeinternals.di.scope.PerApplication;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.contract.CarPartsDataRepositoryContract;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.contract.GlobalEventNotifierContract;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.implementation.CarPartsDataRepository;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.implementation.SomeEvent;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

import static net.crosp.android.dagger2scopeinternals.di.NamedConstants.Context.GLOBAL_APP_CONTEXT;
import static net.crosp.android.dagger2scopeinternals.di.NamedConstants.Environment.SANDBOX_PATH;

/**
 * Created by Alexander Molochko on 1/8/17.
 * Project HeartHealthMonitor
 * Copyright (C) 2017 CROSP Solutions
 */

@Module
public class ApplicationScopedModule {

    Dagger2ScopeInternalsApplication mApplication;

    public ApplicationScopedModule(Dagger2ScopeInternalsApplication application) {
        mApplication = application;
    }

    @Provides
    @PerApplication
    CarPartsDataRepositoryContract provideCarPartsDataRepository() {
        return new CarPartsDataRepository();
    }

    @Provides
    @PerApplication
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @PerApplication
    Resources provideResources() {
        return this.mApplication.getResources();
    }

    @Provides
    @PerApplication
    GlobalEventNotifierContract<SomeEvent> provideEventNotifier() {
        return this.mApplication;
    }

    @Provides
    @PerApplication
    @Named(GLOBAL_APP_CONTEXT)
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @PerApplication
    @Named(SANDBOX_PATH)
    public String provideSandboxPath() {
        return mApplication.getApplicationInfo().dataDir;
    }
}