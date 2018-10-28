package net.crosp.android.dagger2scopeinternals.base.ui.fragment;

import android.support.v4.app.Fragment;

import net.crosp.android.dagger2scopeinternals.di.contract.ProvidesComponent;

/**
 * Created by Alexander Molochko on 12/18/16.
 * Project HeartHealthMonitor
 * Copyright (C) 2016 CROSP Solutions
 */

public abstract class BaseDIFragment extends Fragment {

    //================================================================================
    // DI
    //================================================================================
    // TODO get rid of component dependency from view, but unfortunately Android SDK is build in such way
    public <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((ProvidesComponent<C>) getActivity()).getComponent());
    }
}
