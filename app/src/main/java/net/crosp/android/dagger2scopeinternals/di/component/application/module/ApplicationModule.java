package net.crosp.android.dagger2scopeinternals.di.component.application.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import net.crosp.android.dagger2scopeinternals.di.scope.PerApplication;

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
public class ApplicationModule {

    Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
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