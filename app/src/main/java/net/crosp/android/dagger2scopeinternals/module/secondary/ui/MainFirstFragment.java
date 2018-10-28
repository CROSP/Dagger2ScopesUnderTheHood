package net.crosp.android.dagger2scopeinternals.module.secondary.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import net.crosp.android.dagger2scopeinternals.R;
import net.crosp.android.dagger2scopeinternals.base.ui.fragment.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFirstFragment extends BaseFragment {
    // Views
    @BindView(R.id.button_second_fragment)
    Button mSecondFragmentButton;

    // Callbacks
    @Inject
    SecondFragmentRouter mRouter;

    public MainFirstFragment() {
    }

    //================================================================================
    // Lifecycle callbacks
    //================================================================================

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_main_first;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Injecting dependencies
      //  this.getComponent(MainFirstViewComponent.class).inject(this);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //================================================================================
    // View implementation
    //================================================================================

    @OnClick(R.id.button_second_fragment)
    void switchToSecondFragment() {

    }

    public interface SecondFragmentRouter {
        void onSwitchToSecondFragmentRequested();
    }
}


