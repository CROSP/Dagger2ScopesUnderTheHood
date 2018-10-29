package net.crosp.android.dagger2scopeinternals.module.secondary.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import net.crosp.android.dagger2scopeinternals.R;
import net.crosp.android.dagger2scopeinternals.base.ui.fragment.BaseFragment;
import net.crosp.android.dagger2scopeinternals.module.secondary.di.components.SecondaryScreenComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class SecondaryFirstFragment extends BaseFragment {
    // Views
    @BindView(R.id.button_second_fragment)
    Button mSecondFragmentButton;

    // Callbacks
    @Inject
    SecondFragmentRouter mRouter;

    public SecondaryFirstFragment() {
    }

    //================================================================================
    // Lifecycle callbacks
    //================================================================================

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_secondary_first;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Injecting dependencies
        this.getComponent(SecondaryScreenComponent.class)
                .plusMainFirstViewComponent()
                .inject(this);
    }


    //================================================================================
    // View implementation
    //================================================================================

    @OnClick(R.id.button_second_fragment)
    void switchToSecondFragment() {
        mRouter.onSwitchToSecondFragment();
    }

    @OnClick(R.id.button_main_activity)
    void switchBackToMainActivity() {
        mRouter.onSwitchBackToMainActivity();
    }


    public interface SecondFragmentRouter {
        void onSwitchToSecondFragment();

        void onSwitchBackToMainActivity();
    }
}


