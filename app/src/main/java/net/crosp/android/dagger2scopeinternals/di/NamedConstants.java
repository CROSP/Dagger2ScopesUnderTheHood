package net.crosp.android.dagger2scopeinternals.di;

/**
 * Created by Alexander Molochko on 10/15/17.
 * Project HeartHealthMonitor
 * Copyright (C) 2017 CROSP Solutions
 */

public class NamedConstants {
    public static final String APPLICATION_PREFIX = "application.";

    public static class Context {
        public static final String GLOBAL_APP_CONTEXT = APPLICATION_PREFIX + "context.application";
        public static final String ACTIVITY_CONTEXT = APPLICATION_PREFIX + "context.activity";
        public static final String SERVICE_CONTEXT = APPLICATION_PREFIX + "context.service";
    }

    public static class Threading {

        public static final String APPLICATION_POST_EXECUTION_THREAD = APPLICATION_PREFIX + "threading.post_execution_thread";
        public static final String APPLICATION_EXECUTION_THREAD = APPLICATION_PREFIX + "threading.execution_thread";
        public static final String APPLICATION_MAIN_EXECUTION_THREAD = APPLICATION_PREFIX + "threading.main_execution_thread";
        public static final String REALM_DB_OPERATION_THREAD = APPLICATION_PREFIX + "threading.realm_db";
        public static final String ANDROID_MAIN_THREAD = APPLICATION_PREFIX + "threading.main";
    }

    public static class Fragment {
        public static final String DEFAULT_FRAGMENT_MANAGER = "fragment.manager.default";
        public static final String SUPPORT_FRAGMENT_MANAGER = "fragment.manager.support";
    }

    public static class Environment {
        public static final String SANDBOX_PATH = "env.sandboxpath";
    }
}
