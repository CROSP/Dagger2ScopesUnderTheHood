package net.crosp.android.dagger2scopeinternals.base.ui.contract;

import android.os.Bundle;
import android.support.annotation.LayoutRes;

/**
 * Created by Alexander Molochko on 9/3/15.
 * Project HeartHealthMonitor
 * Copyright (C) 2017 CROSP Solutions
 */

public interface FragmentController {
    void popFragmentFromBackStack();

    /**
     * Replace fragment with new one by class
     *
     * @param fragmentClass  fragment class object
     * @param arguments      bundle for passing arguments
     * @param addToBackStack add fragment to backstack
     * @return fragment was successfully replaced
     */
    boolean replaceFragment(Class fragmentClass, Bundle arguments, boolean addToBackStack, boolean clearBackStack);

    /**
     * Replace fragment with new one by class
     *
     * @param fragmentClass fragment class object
     * @return fragment was successfully replaced
     */
    boolean replaceFragment(Class fragmentClass, Bundle arguments);

    /**
     * Replace fragment without bundle
     *
     * @param fragmentClass  fragment class to be replaced with
     * @param addToBackStack add to back stack
     * @return fragment was successfully replaced
     */
    boolean replaceFragment(Class fragmentClass, boolean addToBackStack);

    boolean replaceFragment(Class fragmentClass, Bundle arguments, boolean addToBackStack);

    /**
     * Replace fragment and clear back stack
     *
     * @param fragmentClass  fragment class to be replaced with
     * @param addToBackStack add to back stack
     * @param clearBackStack clear previous back stack
     * @return success
     */
    boolean replaceFragment(Class fragmentClass, boolean addToBackStack, boolean clearBackStack);

    interface Multiple {
        void popFragmentFromBackStack(int container);

        boolean replaceFragment(Class fragmentClass, @LayoutRes int container, Bundle arguments, boolean addToBackStack, boolean clearBackStack);

        boolean replaceFragment(Class fragmentClass, @LayoutRes int container, boolean addToBackStack);

        boolean replaceFragment(Class fragmentClass, @LayoutRes int container, boolean addToBackStack, boolean clearBackStack);
    }
}

