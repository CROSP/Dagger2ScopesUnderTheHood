package net.crosp.android.dagger2scopeinternals.base.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.crosp.android.dagger2scopeinternals.base.ui.contract.ActivityController;
import net.crosp.android.dagger2scopeinternals.di.NamedConstants;
import net.crosp.android.dagger2scopeinternals.di.component.activity.ActivityComponent;
import net.crosp.android.dagger2scopeinternals.di.component.activity.module.ActivityModule;
import net.crosp.android.dagger2scopeinternals.di.component.application.ApplicationComponent;
import net.crosp.android.dagger2scopeinternals.di.contract.ProvidesComponent;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.contract.CarDataRepositoryContract;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Alexander Molochko on 12/12/2016.
 * Project HeartHealthMonitor
 * Copyright (C) 2016 CROSP Solutions
 */

public abstract class BaseActivity extends AppCompatActivity implements ActivityController {
    @Inject
    CarDataRepositoryContract mCarRepo;
    // Views
    protected ViewGroup mContentContainer;
    // Variables
    @Inject
    protected LayoutInflater mLayoutInflater;
    @Inject
    @Named(NamedConstants.Fragment.SUPPORT_FRAGMENT_MANAGER)
    protected FragmentManager mFragmentManager;
    protected ActivityComponent mActivityComponent;

    //================================================================================
    // Lifecycle callbacks
    //================================================================================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDependencyComponents();
        mFragmentManager = getSupportFragmentManager();
        mLayoutInflater = LayoutInflater.from(this);
        beforeSetContent();
        setContentView(getMainLayoutId());
        afterSetContent();
        mContentContainer = (ViewGroup) findViewById(getContentContainerId());
        if (mContentContainer != null) {
            mLayoutInflater.inflate(getContentLayoutId(), mContentContainer, true);
        }

    }

    private void initDependencyComponents() {
        ApplicationComponent appComponent = ((ProvidesComponent<ApplicationComponent>) getApplication()).getComponent();
        mActivityComponent = appComponent.plusActivityComponent(new ActivityModule(this));

    }

/*    @Override
    public ActivityComponent getComponent() {
        if (mActivityComponent == null) {
            initDependencyComponents();
        }
        return mActivityComponent;
    }*/

    //=======================A=========================================================
    // Hooks for executing actions during execution of activity lifecycle methods
    //================================================================================
    public void beforeSetContent() {

    }

    public void afterSetContent() {

    }
    //================================================================================
    // Template methods to be overridden by child classes
    // Get layout id in order to inflate it and add to the root view
    //================================================================================

    /**
     * Provide main layout id, layout resource used for setting content view
     *
     * @return main layout id @LayoutRes
     */
    public abstract
    @LayoutRes
    int getMainLayoutId();

    /**
     * Lauout id inside a layout provided by the  {@link #getMainLayoutId()} method.
     *
     * @return
     */
    public abstract
    @IdRes
    int getContentContainerId();

    /**
     * Provide main content layout
     * This layout is inflated inside a layout provided by the {@link #getContentContainerId()} method
     *
     * @return id of main content layout, where main screen content will be put
     */
    public abstract
    @LayoutRes
    int getContentLayoutId();

    //================================================================================
    // Public methods
    //================================================================================

    public LayoutInflater provideLayoutInflater() {
        return mLayoutInflater;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void navigateBackForce() {
        super.onBackPressed();
    }


    public String getStringByResourceId(int stringId) {
        return getString(stringId);
    }

    //================================================================================
    // ActivityController implementation
    //================================================================================
    @Override
    public void startNewActivity(Class activityClass) {
        startActivity(new Intent(this, activityClass));
    }

    @Override
    public void startNewActivityNewTask(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void startNewActivityCleaBackStack(Class activityClass) {
        startNewActivityCleaBackStack(activityClass, null);
    }

    @Override
    public void startNewActivityCleaBackStack(Class activityClass, Bundle bundle) {
        Intent intent = new Intent(this, activityClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }


    @Override
    public void startNewActivity(Class activityClass, Bundle bundle) {
        startActivity(new Intent(this, activityClass).putExtras(bundle));
    }

    @Override
    public void startNewActivityForResult(Class activityClass, int requestCode) {
        Intent intent = new Intent(this, activityClass);
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void startNewActivityForResult(Class activityClass, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, activityClass);
        intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void startNewActivityClearTop(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void startNewActivitySingleTop(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

}
