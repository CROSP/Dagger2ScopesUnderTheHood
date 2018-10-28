package net.crosp.android.dagger2scopeinternals.base.ui.contract;

import android.os.Bundle;

/**
 * Created by Alexander Molochko on 1/10/17.
 * Project HeartHealthMonitor
 * Copyright (C) 2017 CROSP Solutions
 */

public interface ActivityController {
    /**
     * Start new activity method in order to start activities from
     * fragments without tight coupling
     *
     * @param activityClass activity class
     */
    void startNewActivity(Class activityClass);

    void startNewActivityCleaBackStack(Class activityClass);

    void startNewActivityCleaBackStack(Class activityClass, Bundle bundle);

    /**
     * The same but with bundle
     *
     * @param activityClass activity class
     * @param bundle        bundle object
     */
    void startNewActivity(Class activityClass, Bundle bundle);

    /**
     * Start new activity for result
     *
     * @param activityClass activity class
     * @param requestCode   request code
     */
    void startNewActivityForResult(Class activityClass, int requestCode);

    /**
     * Start new activity for result with bundle
     *
     * @param activityClass activity class
     * @param bundle        bundle
     * @param requestCode   request code
     */
    void startNewActivityForResult(Class activityClass, Bundle bundle, int requestCode);

    /**
     * Start new activity in a new task
     *
     * @param activityClass activity class
     */
    void startNewActivityNewTask(Class activityClass);


    /**
     * Start new activity with clearing top activities
     *
     * @param activityClass activity class
     */
    void startNewActivityClearTop(Class activityClass);

    /**
     * Start new activity if not a top activity
     *
     * @param activityClass activity class
     */

    void startNewActivitySingleTop(Class activityClass);
}
