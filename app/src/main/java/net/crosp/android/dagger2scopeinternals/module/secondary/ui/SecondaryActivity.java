package net.crosp.android.dagger2scopeinternals.module.secondary.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import net.crosp.android.dagger2scopeinternals.R;
import net.crosp.android.dagger2scopeinternals.base.ui.activity.BaseSingleFragmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondaryActivity extends BaseSingleFragmentActivity implements MainFirstFragment.SecondFragmentRouter {
    // Views
    @BindView(R.id.toolbar_main)
    Toolbar mMainToolbar;
    // UI Variables
    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inject views
        ButterKnife.bind(this);
        initUI();
        navigateToInitialScreen();
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

    // Routing
    @Override
    public void onSwitchToSecondFragmentRequested() {

    }
}
