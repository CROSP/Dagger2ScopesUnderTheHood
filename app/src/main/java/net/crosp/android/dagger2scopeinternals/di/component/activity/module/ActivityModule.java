package net.crosp.android.dagger2scopeinternals.di.component.activity.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import net.crosp.android.dagger2scopeinternals.di.NamedConstants;
import net.crosp.android.dagger2scopeinternals.di.scope.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexander Molochko on 1/22/17.
 * Project HeartHealthMonitor
 * Copyright (C) 2017 CROSP Solutions
 */
@Module
@PerActivity
public class ActivityModule {
    private final AppCompatActivity mActivity;
    public static final String CONTEXT_ACTIVITY = "context.activity";

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @PerActivity
    @Named(CONTEXT_ACTIVITY)
    Context provideActivityContext() {
        return this.mActivity;
    }

    /**
     * Provide the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity provideActivity() {
        return this.mActivity;
    }


    /**
     * Provide the layout inflater to dependents in the graph.
     */
    @Provides
    @PerActivity
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(mActivity);
    }

    /**
     * Provide the layout inflater to dependents in the graph.
     */
    @Provides
    @Named(NamedConstants.Fragment.SUPPORT_FRAGMENT_MANAGER)
    @PerActivity
    FragmentManager provideSupportFragmentManager() {
        return mActivity.getSupportFragmentManager();
    }

    @Provides
    @Named(NamedConstants.Fragment.DEFAULT_FRAGMENT_MANAGER)
    @PerActivity
    android.app.FragmentManager provideFragmentManager() {
        return mActivity.getFragmentManager();
    }
}
