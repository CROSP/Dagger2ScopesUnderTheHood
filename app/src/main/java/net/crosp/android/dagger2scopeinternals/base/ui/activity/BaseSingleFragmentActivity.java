package net.crosp.android.dagger2scopeinternals.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;

import net.crosp.android.dagger2scopeinternals.base.ui.contract.FragmentController;

/**
 * Created by Alexander Molochko on 1/1/2017.
 * Project HeartHealthMonitor
 * Copyright (C) 2016 CROSP Solutions
 */

public abstract class BaseSingleFragmentActivity extends BaseMultipleFragmentActivity
        implements FragmentController {

    /**
     * Provide fragment container id
     *
     * @return view group id where fragments will be inflated
     */
    @IdRes
    public abstract int getFragmentContainerLayoutId();

    @Override
    public void popFragmentFromBackStack() {
        mFragmentManager.popBackStack();
    }


    /**
     * Replacing fragment by class
     *
     * @param fragmentClass  fragment class object
     * @param arguments      bundle for passing arguments
     * @param addToBackStack add fragment to backstack
     * @return success
     */
    @Override
    public boolean replaceFragment(Class fragmentClass, Bundle arguments, boolean addToBackStack, boolean clearBackStack) {
        return super.replaceFragment(fragmentClass, getFragmentContainerLayoutId(), arguments, addToBackStack, clearBackStack);
    }

    @Override
    public boolean replaceFragment(Class fragmentClass, Bundle arguments) {
        return this.replaceFragment(fragmentClass, getFragmentContainerLayoutId(), arguments, true, false);
    }

    /**
     * Replace fragment without bundle
     *
     * @param fragmentClass  fragment class to be replaced with
     * @param addToBackStack add to back stack
     * @return success
     */
    @Override
    public boolean replaceFragment(Class fragmentClass, boolean addToBackStack) {
        return this.replaceFragment(fragmentClass, Bundle.EMPTY, addToBackStack, false);
    }

    @Override
    public boolean replaceFragment(Class fragmentClass, Bundle arguments, boolean addToBackStack) {
        return this.replaceFragment(fragmentClass, arguments, addToBackStack, false);
    }


    /**
     * Replace fragment without bundle
     *
     * @param fragmentClass  fragment class to be replaced with
     * @param addToBackStack add to back stack
     * @return success
     */
    @Override
    public boolean replaceFragment(Class fragmentClass, boolean addToBackStack, boolean clearBackStack) {
        return this.replaceFragment(fragmentClass, Bundle.EMPTY, addToBackStack, clearBackStack);
    }


}
