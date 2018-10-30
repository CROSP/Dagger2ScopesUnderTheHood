package net.crosp.android.dagger2scopeinternals.module.shareddependencies.contract;

/**
 * Created by Alexander Molochko on 10/30/18.
 * Project Dagger2ScopeInternals
 * Copyright (C) 2018 CROSP Solutions
 */
public interface GlobalEventNotifierContract<T> {
    void addListener(EventListener<T> eventListener);

    public static interface EventListener<T> {
        void onEvent(T event);
    }
}
