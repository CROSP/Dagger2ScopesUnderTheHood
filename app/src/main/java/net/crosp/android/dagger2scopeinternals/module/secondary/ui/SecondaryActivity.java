package net.crosp.android.dagger2scopeinternals.module.secondary.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import net.crosp.android.dagger2scopeinternals.R;
import net.crosp.android.dagger2scopeinternals.base.ui.activity.BaseSingleFragmentActivity;
import net.crosp.android.dagger2scopeinternals.di.contract.ProvidesComponent;
import net.crosp.android.dagger2scopeinternals.module.main.ui.MainActivity;
import net.crosp.android.dagger2scopeinternals.module.secondary.di.components.SecondaryScreenComponent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondaryActivity extends BaseSingleFragmentActivity implements ProvidesComponent<SecondaryScreenComponent>, SecondaryFirstFragment.SecondFragmentRouter, SecondarySecondFragment.FirstFragmentRouter {
    // Views
    @BindView(R.id.toolbar_main)
    Toolbar mMainToolbar;
    // UI Variables
    ActionBar mActionBar;
    private SecondaryScreenComponent mSecondaryScreenComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inject views
        injectDependencies();
        ButterKnife.bind(this);
        initUI();
        navigateToInitialScreen();
    }

    private void initUI() {
        initToolbar();
    }

    private void injectDependencies() {
        mSecondaryScreenComponent = mActivityComponent.plusSecondaryScreenComponent();
        mSecondaryScreenComponent.inject(this);
    }

    public void navigateToInitialScreen() {
        replaceFragment(SecondaryFirstFragment.class, false);
    }

    protected void initToolbar() {
        setSupportActionBar(mMainToolbar);
        mActionBar = getSupportActionBar();
    }
    // Layout configuration

    @Override
    public int getMainLayoutId() {
        return R.layout.activity_secondary;
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

    @Override
    public void onSwitchToSecondFragment() {
        replaceFragment(SecondarySecondFragment.class, false);

    }

    @Override
    public void onSwitchBackToMainActivity() {
        startNewActivity(MainActivity.class);
    }

    @Override
    public void onSwitchToFirstFragment() {
        replaceFragment(SecondaryFirstFragment.class, false);

    }

    @Override
    public SecondaryScreenComponent getComponent() {
        return mSecondaryScreenComponent;
    }

    // Routing

}
