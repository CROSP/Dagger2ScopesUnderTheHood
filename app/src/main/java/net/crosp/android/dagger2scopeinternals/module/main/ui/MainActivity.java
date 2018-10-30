package net.crosp.android.dagger2scopeinternals.module.main.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import net.crosp.android.dagger2scopeinternals.R;
import net.crosp.android.dagger2scopeinternals.base.ui.activity.BaseSingleFragmentActivity;
import net.crosp.android.dagger2scopeinternals.di.contract.ProvidesComponent;
import net.crosp.android.dagger2scopeinternals.module.main.MainScreenDependencyContract;
import net.crosp.android.dagger2scopeinternals.module.main.di.components.MainScreenComponent;
import net.crosp.android.dagger2scopeinternals.module.secondary.ui.SecondaryActivity;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.contract.CarDataRepositoryContract;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.contract.GlobalEventNotifierContract;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.implementation.SomeEvent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseSingleFragmentActivity implements ProvidesComponent<MainScreenComponent>, MainFirstFragment.SecondFragmentRouter, MainSecondFragment.FirstFragmentRouter, GlobalEventNotifierContract.EventListener<SomeEvent> {
    @Inject
    CarDataRepositoryContract mCarRepoOther;
    @Inject
    MainScreenDependencyContract mMainScreenDependency;

    @Inject
    GlobalEventNotifierContract<SomeEvent> mGlobalEventNotifier;
    // Views
    @BindView(R.id.toolbar_main)
    Toolbar mMainToolbar;
    // UI Variables
    ActionBar mActionBar;

    MainScreenComponent mMainScreenComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inject views
        injectDependencies();
        ButterKnife.bind(this);
        initUI();
        navigateToInitialScreen();
        setEventListeners();
    }

    private void setEventListeners() {
        this.mGlobalEventNotifier.addListener(this);
    }

    private void injectDependencies() {
        mMainScreenComponent = mActivityComponent.plusMainScreenComponent();
        mMainScreenComponent.inject(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initUI() {
        initToolbar();
    }

    public void navigateToInitialScreen() {
        replaceFragment(MainFirstFragment.class, false);
    }

    protected void initToolbar() {
        setSupportActionBar(mMainToolbar);
        mActionBar = getSupportActionBar();
    }

    @Override
    public MainScreenComponent getComponent() {
        return mMainScreenComponent;
    }
    // Layout configuration

    @Override
    public int getMainLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.content_toolbar_single_fragment;
    }

    @Override
    public int getFragmentContainerLayoutId() {
        return R.id.frame_layout_fragment_container;
    }

    @Override
    public int getContentContainerId() {
        return R.id.linear_layout_content;
    }

    // Routing
    @Override
    public void onSwitchToSecondFragment() {
        replaceFragment(MainSecondFragment.class, false);
    }

    @Override
    public void onSwitchBackToFirstFragment() {
        replaceFragment(MainFirstFragment.class, false);
    }

    @Override
    public void switchToSecondaryActivity() {
        startNewActivity(SecondaryActivity.class);
    }


    @Override
    public void onEvent(SomeEvent event) {
        //
    }
}
