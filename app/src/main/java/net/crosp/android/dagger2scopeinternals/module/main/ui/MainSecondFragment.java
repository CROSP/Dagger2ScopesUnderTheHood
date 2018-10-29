package net.crosp.android.dagger2scopeinternals.module.main.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import net.crosp.android.dagger2scopeinternals.R;
import net.crosp.android.dagger2scopeinternals.base.ui.fragment.BaseFragment;
import net.crosp.android.dagger2scopeinternals.module.main.di.components.MainScreenComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainSecondFragment extends BaseFragment {
    // Views
    @BindView(R.id.button_first_fragment)
    Button mFirstFragmentButton;

    // Callbacks
    @Inject
    FirstFragmentRouter mRouter;

    public MainSecondFragment() {
    }

    //================================================================================
    // Lifecycle callbacks
    //================================================================================

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_main_second;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Injecting dependencies
        this.getComponent(MainScreenComponent.class)
                .plusMainSecondViewComponent()
                .inject(this);

    }


    //================================================================================
    // View implementation
    //================================================================================

    @OnClick(R.id.button_first_fragment)
    void switchToFirstFragment() {
        mRouter.onSwitchBackToFirstFragment();
    }

    @OnClick(R.id.button_secondary_activity)
    void switchToSecondaryActivity() {
        mRouter.switchToSecondaryActivity();
    }

    public interface FirstFragmentRouter {
        void onSwitchBackToFirstFragment();

        void switchToSecondaryActivity();
    }
}


