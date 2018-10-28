package net.crosp.android.dagger2scopeinternals.module.main.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import net.crosp.android.dagger2scopeinternals.R;
import net.crosp.android.dagger2scopeinternals.base.ui.activity.BaseSingleFragmentActivity;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.contract.CarDataRepositoryContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseSingleFragmentActivity implements MainFirstFragment.SecondFragmentRouter {
    @Inject
    CarDataRepositoryContract mCarRepoOther;
    // Views
    @BindView(R.id.toolbar_main)
    Toolbar mMainToolbar;
    // UI Variables
    ActionBar mActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inject views
        injectDependencies();
        ButterKnife.bind(this);
        initUI();
        navigateToInitialScreen();
    }

    private void injectDependencies() {
        mAppComponent.inject(this);
        System.out.println(mCarRepoOther);
        mAppComponent.inject(this);
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
    public void onSwitchToSecondFragmentRequested() {

    }
}
