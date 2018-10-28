package net.crosp.android.dagger2scopeinternals.di.component;

import android.app.Application;

import net.crosp.android.dagger2scopeinternals.di.component.application.ApplicationComponent;
import net.crosp.android.dagger2scopeinternals.di.component.application.DaggerApplicationComponent;
import net.crosp.android.dagger2scopeinternals.di.component.application.module.ApplicationUnscopedModule;
import net.crosp.android.dagger2scopeinternals.di.contract.ProvidesComponent;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.contract.CarDataRepositoryContract;

import javax.inject.Inject;

/**
 * Created by Alexander Molochko on 10/19/18.
 * Project Dagger2ScopeInternals
 * Copyright (C) 2018 CROSP Solutions
 */
public class Dagger2ScopeInternalsApplication extends Application implements ProvidesComponent<ApplicationComponent> {

    @Inject
    CarDataRepositoryContract mCarRepo;

    private ApplicationComponent mApplicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        buildApplicationComponent();
        mApplicationComponent.inject(this);
        System.out.println(mCarRepo);
    }

    private void buildApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationUnscopedModule(new ApplicationUnscopedModule(this))
                .build();
    }

    @Override
    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
