package net.crosp.android.dagger2scopeinternals.module.secondary.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import net.crosp.android.dagger2scopeinternals.R;
import net.crosp.android.dagger2scopeinternals.base.ui.fragment.BaseFragment;
import net.crosp.android.dagger2scopeinternals.module.secondary.di.components.SecondaryScreenComponent;
import net.crosp.android.dagger2scopeinternals.module.shareddependencies.contract.CarPartsDataRepositoryContract;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class SecondarySecondFragment extends BaseFragment {
    // Callbacks
    @Inject
    CarPartsDataRepositoryContract mCarPartsDataRepository;
    @Inject
    FirstFragmentRouter mRouter;

    public SecondarySecondFragment() {
    }

    //================================================================================
    // Lifecycle callbacks
    //================================================================================

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_secondary_second;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Injecting dependencies
        this.getComponent(SecondaryScreenComponent.class)
                .plusSecondarySecondViewComponent()
                .inject(this);

    }

    //================================================================================
    // View implementation
    //================================================================================

    @OnClick(R.id.button_first_fragment)
    void switchToFirstFragment() {
        mRouter.onSwitchToFirstFragment();
    }

    public interface FirstFragmentRouter {
        void onSwitchToFirstFragment();
    }
}


